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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class PropiedadView {

    private PropiedadController controller;
    private TableView<Propiedad> tablaPropiedades;

    // Campos generales
    private ComboBox<String> cmbTipo;
    private TextField txtDireccion;
    private TextField txtArriendo;
    private TextField txtMetros;

    // Campos exclusivos de CASA
    private TextField txtCantidadPisos;
    private CheckBox chkTienePatio;

    // Campos exclusivos de DEPARTAMENTO
    private TextField txtNumeroPiso;
    private TextField txtGastosComunes;

    private Label lblEstado;
    private int idSeleccionado = -1;

    public PropiedadView() {
        this.controller = new PropiedadController();
    }

    public Scene crearEscena() {
        VBox panelFormulario = crearPanelFormulario();
        VBox panelTabla = crearPanelTabla();

        HBox.setHgrow(panelTabla, Priority.ALWAYS);

        HBox raiz = new HBox(20, panelFormulario, panelTabla);
        raiz.setPadding(new Insets(20));

        cargarDatosEnTabla();
        actualizarCamposPorTipo(); // Estado inicial

        return new Scene(raiz, 960, 560);
    }

    private VBox crearPanelFormulario() {
        Label lblTitulo = new Label("Gestión de Propiedades");
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        cmbTipo = new ComboBox<>();
        cmbTipo.getItems().addAll("CASA", "DEPARTAMENTO");
        cmbTipo.setValue("CASA");
        cmbTipo.setMaxWidth(Double.MAX_VALUE);
        cmbTipo.setOnAction(e -> actualizarCamposPorTipo());

        txtDireccion = new TextField();
        txtDireccion.setPromptText("Ej: Av. Los Alerces 420");

        txtArriendo = new TextField();
        txtArriendo.setPromptText("Ej: 650000");

        txtMetros = new TextField();
        txtMetros.setPromptText("Ej: 120");

        // Exclusivo Casa
        txtCantidadPisos = new TextField();
        txtCantidadPisos.setPromptText("Ej: 2");
        chkTienePatio = new CheckBox("¿Tiene patio?");

        // Exclusivo Departamento
        txtNumeroPiso = new TextField();
        txtNumeroPiso.setPromptText("Ej: 5");
        txtGastosComunes = new TextField();
        txtGastosComunes.setPromptText("Ej: 95000");

        Button btnGuardar = new Button("Guardar");
        Button btnActualizar = new Button("Actualizar");
        Button btnEliminar = new Button("Eliminar");
        Button btnLimpiar = new Button("Limpiar");

        btnGuardar.setOnAction(e -> accionGuardar());
        btnActualizar.setOnAction(e -> accionActualizar());
        btnEliminar.setOnAction(e -> accionEliminar());
        btnLimpiar.setOnAction(e -> limpiarFormulario());

        HBox filaBotones = new HBox(8, btnGuardar, btnActualizar, btnEliminar, btnLimpiar);

        lblEstado = new Label("Listo. Conectado a Oracle.");

        VBox panel = new VBox(8,
                lblTitulo,
                new Label("Tipo:"), cmbTipo,
                new Label("Dirección:"), txtDireccion,
                new Label("Arriendo Base ($):"), txtArriendo,
                new Label("Metros Cuadrados (m²):"), txtMetros,
                new Label("Cantidad Pisos (Casa):"), txtCantidadPisos,
                chkTienePatio,
                new Label("N° Piso (Depto):"), txtNumeroPiso,
                new Label("Gastos Comunes (Depto):"), txtGastosComunes,
                filaBotones,
                lblEstado
        );
        panel.setPrefWidth(320);
        return panel;
    }

    private VBox crearPanelTabla() {
        Label lblSubtitulo = new Label("Propiedades en Oracle Database");
        lblSubtitulo.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        tablaPropiedades = new TableView<>();

        // Columnas directas (usan PropertyValueFactory igual que el profe)
        TableColumn<Propiedad, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colId.setPrefWidth(50);

        TableColumn<Propiedad, String> colTipo = new TableColumn<>("Tipo");
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colTipo.setPrefWidth(110);

        TableColumn<Propiedad, String> colDireccion = new TableColumn<>("Dirección");
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colDireccion.setPrefWidth(180);

        TableColumn<Propiedad, Integer> colMetros = new TableColumn<>("m²");
        colMetros.setCellValueFactory(new PropertyValueFactory<>("metrosCuadrados"));
        colMetros.setPrefWidth(60);

        // Columnas polimórficas (métodos calculados, no atributos directos)
        TableColumn<Propiedad, String> colDetalle = new TableColumn<>("Detalle");
        colDetalle.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getDetalle()));
        colDetalle.setPrefWidth(180);

        TableColumn<Propiedad, Integer> colPago = new TableColumn<>("Pago Mensual");
        colPago.setCellValueFactory(d -> new SimpleIntegerProperty(d.getValue().calcularPagoMensual()).asObject());
        colPago.setPrefWidth(110);

        tablaPropiedades.getColumns().add(colId);
        tablaPropiedades.getColumns().add(colTipo);
        tablaPropiedades.getColumns().add(colDireccion);
        tablaPropiedades.getColumns().add(colMetros);
        tablaPropiedades.getColumns().add(colDetalle);
        tablaPropiedades.getColumns().add(colPago);

        // Al seleccionar una fila, recargar todo el formulario
        tablaPropiedades.getSelectionModel().selectedItemProperty().addListener((obs, anterior, seleccionado) -> {
            if (seleccionado != null) {
                idSeleccionado = seleccionado.getId();
                cmbTipo.setValue(seleccionado.getTipo());
                actualizarCamposPorTipo();

                txtDireccion.setText(seleccionado.getDireccion());
                txtArriendo.setText(String.valueOf(seleccionado.getArriendoBase()));
                txtMetros.setText(String.valueOf(seleccionado.getMetrosCuadrados()));

                if (seleccionado instanceof Casa casa) {
                    txtCantidadPisos.setText(String.valueOf(casa.getCantidadPisos()));
                    chkTienePatio.setSelected(casa.isTienePatio());
                } else if (seleccionado instanceof Departamento depto) {
                    txtNumeroPiso.setText(String.valueOf(depto.getNumeroPiso()));
                    txtGastosComunes.setText(String.valueOf(depto.getGastosComunes()));
                }

                lblEstado.setText("Editando propiedad ID #" + idSeleccionado);
            }
        });

        VBox.setVgrow(tablaPropiedades, Priority.ALWAYS);
        return new VBox(10, lblSubtitulo, tablaPropiedades);
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

    private void accionGuardar() {
        try {
            String direccion = txtDireccion.getText().trim();
            int arriendo = Integer.parseInt(txtArriendo.getText().trim());
            int metros = Integer.parseInt(txtMetros.getText().trim());

            boolean exito;
            if ("CASA".equals(cmbTipo.getValue())) {
                int pisos = Integer.parseInt(txtCantidadPisos.getText().trim());
                boolean patio = chkTienePatio.isSelected();
                exito = controller.guardarCasa(direccion, arriendo, metros, pisos, patio);
            } else {
                int numPiso = Integer.parseInt(txtNumeroPiso.getText().trim());
                int gastos = Integer.parseInt(txtGastosComunes.getText().trim());
                exito = controller.guardarDepartamento(direccion, arriendo, metros, numPiso, gastos);
            }

            if (exito) {
                lblEstado.setText("Propiedad guardada correctamente en Oracle.");
                limpiarFormulario();
                cargarDatosEnTabla();
            } else {
                lblEstado.setText("Error: No se pudo guardar en la base de datos.");
            }
        } catch (NumberFormatException e) {
            lblEstado.setText("Error: Revisa que los campos numéricos sean válidos.");
        }
    }

    private void accionActualizar() {
        if (idSeleccionado == -1) {
            lblEstado.setText("Selecciona primero una propiedad en la tabla.");
            return;
        }

        try {
            String direccion = txtDireccion.getText().trim();
            int arriendo = Integer.parseInt(txtArriendo.getText().trim());
            int metros = Integer.parseInt(txtMetros.getText().trim());

            boolean exito;
            if ("CASA".equals(cmbTipo.getValue())) {
                int pisos = Integer.parseInt(txtCantidadPisos.getText().trim());
                boolean patio = chkTienePatio.isSelected();
                exito = controller.actualizarCasa(idSeleccionado, direccion, arriendo, metros, pisos, patio);
            } else {
                int numPiso = Integer.parseInt(txtNumeroPiso.getText().trim());
                int gastos = Integer.parseInt(txtGastosComunes.getText().trim());
                exito = controller.actualizarDepartamento(idSeleccionado, direccion, arriendo, metros, numPiso, gastos);
            }

            if (exito) {
                lblEstado.setText("Propiedad ID #" + idSeleccionado + " actualizada.");
                limpiarFormulario();
                cargarDatosEnTabla();
            } else {
                lblEstado.setText("Error al actualizar los datos.");
            }
        } catch (NumberFormatException e) {
            lblEstado.setText("Error: Revisa que los campos numéricos sean válidos.");
        }
    }

    private void accionEliminar() {
        if (idSeleccionado == -1) {
            lblEstado.setText("Selecciona primero una propiedad en la tabla.");
            return;
        }

        boolean exito = controller.eliminarPropiedad(idSeleccionado);

        if (exito) {
            lblEstado.setText("Propiedad eliminada de Oracle.");
            limpiarFormulario();
            cargarDatosEnTabla();
        } else {
            lblEstado.setText("No se pudo eliminar la propiedad.");
        }
    }

    private void cargarDatosEnTabla() {
        ObservableList<Propiedad> datos = FXCollections.observableArrayList(
                controller.obtenerTodas()
        );
        tablaPropiedades.setItems(datos);
    }

    private void limpiarFormulario() {
        idSeleccionado = -1;
        cmbTipo.setValue("CASA");
        txtDireccion.clear();
        txtArriendo.clear();
        txtMetros.clear();
        txtCantidadPisos.clear();
        chkTienePatio.setSelected(false);
        txtNumeroPiso.clear();
        txtGastosComunes.clear();
        actualizarCamposPorTipo();
        tablaPropiedades.getSelectionModel().clearSelection();
    }
}