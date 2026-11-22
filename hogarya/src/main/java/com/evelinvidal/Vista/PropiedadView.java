package com.evelinvidal.Vista;

import com.evelinvidal.Controller.PropiedadController;
import com.evelinvidal.Modelo.Casa;
import com.evelinvidal.Modelo.Departamento;
import com.evelinvidal.Modelo.Propiedad;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class PropiedadView extends BorderPane {

    private final PropiedadController controller;
    private final ObservableList<Propiedad> listaPropiedades;

    private ComboBox<String> cmbTipo;
    private TextField txtDireccion;
    private TextField txtArriendo;
    private TextField txtMetros;

    private TextField txtCantidadPisos;
    private CheckBox chkTienePatio;

    private TextField txtNumeroPiso;
    private TextField txtGastosComunes;

    private TableView<Propiedad> tabla;
    private Propiedad propiedadSeleccionada = null;

    public PropiedadView() {
        this.controller = new PropiedadController();
        this.listaPropiedades = FXCollections.observableArrayList();

        setPadding(new Insets(15));
        setLeft(crearFormulario());
        setCenter(crearTabla());

        cargarDatos();
        actualizarCamposPorTipo();
    }

    private VBox crearFormulario() {
        VBox panel = new VBox(10);
        panel.setPadding(new Insets(0, 20, 0, 0));
        panel.setPrefWidth(300);

        Label titulo = new Label("Gestión de Propiedades");
        titulo.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        cmbTipo = new ComboBox<>();
        cmbTipo.getItems().addAll("CASA", "DEPARTAMENTO");
        cmbTipo.setValue("CASA");
        cmbTipo.setMaxWidth(Double.MAX_VALUE);
        cmbTipo.setOnAction(e -> actualizarCamposPorTipo());

        txtDireccion = new TextField();
        txtDireccion.setPromptText("Dirección (ej: Av. Los Alerces 420)");

        txtArriendo = new TextField();
        txtArriendo.setPromptText("Arriendo Base ($)");

        txtMetros = new TextField();
        txtMetros.setPromptText("Metros Cuadrados (m²)");

        txtCantidadPisos = new TextField();
        txtCantidadPisos.setPromptText("Cantidad de pisos");
        chkTienePatio = new CheckBox("¿Tiene patio?");

        txtNumeroPiso = new TextField();
        txtNumeroPiso.setPromptText("Número de piso");
        txtGastosComunes = new TextField();
        txtGastosComunes.setPromptText("Gastos comunes ($)");

        Button btnGuardar = new Button("Guardar");
        btnGuardar.setMaxWidth(Double.MAX_VALUE);
        btnGuardar.setOnAction(e -> accionGuardar());

        Button btnActualizar = new Button("Actualizar");
        btnActualizar.setMaxWidth(Double.MAX_VALUE);
        btnActualizar.setOnAction(e -> accionActualizar());

        Button btnEliminar = new Button("Eliminar");
        btnEliminar.setMaxWidth(Double.MAX_VALUE);
        btnEliminar.setOnAction(e -> accionEliminar());

        Button btnLimpiar = new Button("Limpiar Formulario");
        btnLimpiar.setMaxWidth(Double.MAX_VALUE);
        btnLimpiar.setOnAction(e -> limpiarFormulario());

        HBox filaBotones1 = new HBox(10, btnGuardar, btnActualizar);
        HBox filaBotones2 = new HBox(10, btnEliminar, btnLimpiar);

        panel.getChildren().addAll(
            titulo,
            new Label("Tipo de Propiedad:"), cmbTipo,
            new Label("Datos Generales:"), txtDireccion, txtArriendo, txtMetros,
            new Separator(),
            new Label("Exclusivo Casa:"), txtCantidadPisos, chkTienePatio,
            new Separator(),
            new Label("Exclusivo Departamento:"), txtNumeroPiso, txtGastosComunes,
            new Separator(),
            filaBotones1, filaBotones2
        );

        return panel;
    }

    private TableView<Propiedad> crearTabla() {
        tabla = new TableView<>(listaPropiedades);
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Propiedad, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(d -> new SimpleIntegerProperty(d.getValue().getId()).asObject());
        colId.setMaxWidth(50);

        TableColumn<Propiedad, String> colTipo = new TableColumn<>("Tipo");
        colTipo.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getTipo()));

        TableColumn<Propiedad, String> colDir = new TableColumn<>("Dirección");
        colDir.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getDireccion()));

        TableColumn<Propiedad, Integer> colM2 = new TableColumn<>("m²");
        colM2.setCellValueFactory(d -> new SimpleIntegerProperty(d.getValue().getMetrosCuadrados()).asObject());
        colM2.setMaxWidth(60);

        TableColumn<Propiedad, String> colDetalle = new TableColumn<>("Detalle");
        colDetalle.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getDetalle()));

        TableColumn<Propiedad, Integer> colPago = new TableColumn<>("Pago Mensual");
        colPago.setCellValueFactory(d -> new SimpleIntegerProperty(d.getValue().calcularPagoMensual()).asObject());

        tabla.getColumns().addAll(java.util.List.of(colId, colTipo, colDir, colM2, colDetalle, colPago));

        tabla.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                cargarPropiedadEnFormulario(newSel);
            }
        });

        return tabla;
    }

    private void actualizarCamposPorTipo() {
        boolean esCasa = "CASA".equals(cmbTipo.getValue());

        txtCantidadPisos.setDisable(!esCasa);
        chkTienePatio.setDisable(!esCasa);

        txtNumeroPiso.setDisable(esCasa);
        txtGastosComunes.setDisable(esCasa);

        if (esCasa) {
            txtNumeroPiso.clear();
            txtGastosComunes.clear();
        } else {
            txtCantidadPisos.clear();
            chkTienePatio.setSelected(false);
        }
    }

    private void cargarPropiedadEnFormulario(Propiedad p) {
        propiedadSeleccionada = p;
        cmbTipo.setValue(p.getTipo());
        actualizarCamposPorTipo();

        txtDireccion.setText(p.getDireccion());
        txtArriendo.setText(String.valueOf(p.getArriendoBase()));
        txtMetros.setText(String.valueOf(p.getMetrosCuadrados()));

        if (p instanceof Casa casa) {
            txtCantidadPisos.setText(String.valueOf(casa.getCantidadPisos()));
            chkTienePatio.setSelected(casa.isTienePatio());
        } else if (p instanceof Departamento depto) {
            txtNumeroPiso.setText(String.valueOf(depto.getNumeroPiso()));
            txtGastosComunes.setText(String.valueOf(depto.getGastosComunes()));
        }
    }

    private void accionGuardar() {
        try {
            String direccion = txtDireccion.getText().trim();
            int arriendo = Integer.parseInt(txtArriendo.getText().trim());
            int m2 = Integer.parseInt(txtMetros.getText().trim());

            if (direccion.isEmpty()) {
                mostrarAlerta("Error", "La dirección no puede estar vacía.");
                return;
            }

            boolean exito;
            if ("CASA".equals(cmbTipo.getValue())) {
                int pisos = Integer.parseInt(txtCantidadPisos.getText().trim());
                boolean patio = chkTienePatio.isSelected();
                exito = controller.guardarCasa(direccion, arriendo, m2, pisos, patio);
            } else {
                int numPiso = Integer.parseInt(txtNumeroPiso.getText().trim());
                int gastos = Integer.parseInt(txtGastosComunes.getText().trim());
                exito = controller.guardarDepartamento(direccion, arriendo, m2, numPiso, gastos);
            }

            if (exito) {
                cargarDatos();
                limpiarFormulario();
            } else {
                mostrarAlerta("Error BD", "No se pudo guardar la propiedad.");
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("Error de formato", "Revisa que los campos numéricos tengan números válidos.");
        }
    }

    private void accionActualizar() {
        if (propiedadSeleccionada == null) {
            mostrarAlerta("Aviso", "Selecciona una propiedad de la tabla para actualizar.");
            return;
        }

        try {
            int id = propiedadSeleccionada.getId();
            String direccion = txtDireccion.getText().trim();
            int arriendo = Integer.parseInt(txtArriendo.getText().trim());
            int m2 = Integer.parseInt(txtMetros.getText().trim());

            boolean exito;
            if ("CASA".equals(cmbTipo.getValue())) {
                int pisos = Integer.parseInt(txtCantidadPisos.getText().trim());
                boolean patio = chkTienePatio.isSelected();
                exito = controller.actualizarCasa(id, direccion, arriendo, m2, pisos, patio);
            } else {
                int numPiso = Integer.parseInt(txtNumeroPiso.getText().trim());
                int gastos = Integer.parseInt(txtGastosComunes.getText().trim());
                exito = controller.actualizarDepartamento(id, direccion, arriendo, m2, numPiso, gastos);
            }

            if (exito) {
                cargarDatos();
                limpiarFormulario();
            } else {
                mostrarAlerta("Error BD", "No se pudo actualizar la propiedad.");
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("Error de formato", "Revisa que los campos numéricos tengan números válidos.");
        }
    }

    private void accionEliminar() {
        if (propiedadSeleccionada == null) {
            mostrarAlerta("Aviso", "Selecciona una propiedad de la tabla para eliminar.");
            return;
        }

        if (controller.eliminarPropiedad(propiedadSeleccionada.getId())) {
            cargarDatos();
            limpiarFormulario();
        } else {
            mostrarAlerta("Error BD", "No se pudo eliminar la propiedad.");
        }
    }

    private void cargarDatos() {
        listaPropiedades.setAll(controller.obtenerTodas());
    }

    private void limpiarFormulario() {
        propiedadSeleccionada = null;
        tabla.getSelectionModel().clearSelection();
        cmbTipo.setValue("CASA");
        txtDireccion.clear();
        txtArriendo.clear();
        txtMetros.clear();
        txtCantidadPisos.clear();
        chkTienePatio.setSelected(false);
        txtNumeroPiso.clear();
        txtGastosComunes.clear();
        actualizarCamposPorTipo();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}