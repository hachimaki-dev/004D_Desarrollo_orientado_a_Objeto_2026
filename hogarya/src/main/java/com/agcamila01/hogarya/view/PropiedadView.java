package com.agcamila01.hogarya.view;

import com.agcamila01.hogarya.controller.PropiedadController;
import com.agcamila01.hogarya.model.Casa;
import com.agcamila01.hogarya.model.Departamento;
import com.agcamila01.hogarya.model.Propiedad;

import javafx.beans.property.ReadOnlyIntegerWrapper;
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

    private PropiedadController propiedadController;
    private TableView<Propiedad> tablaPropiedades;

    //para formulario
    private ComboBox<String> cmbSeleccionarPropiedad;
    private TextField txtDireccion;
    private TextField txtArriendoBase;
    private TextField txtMetrosCuadrados;
    //casaa
    private TextField txtCantidadPisos;
    private CheckBox chkTienePatio;
    //departamento
    private TextField txtNumeroPiso;
    private TextField txtGastosComunes;

    private Label lblEstado;
    private int idSeleccionado = -1;

    public PropiedadView() {
        this.propiedadController = new PropiedadController();
        this.tablaPropiedades = new TableView<>();
    }

    public Scene escenaCompleta() {
        VBox panelFormulario = crearPanelFormulario();
        VBox panelTabla = crearPanelTabla();
        HBox.setHgrow(panelTabla, Priority.ALWAYS);
        
        HBox root = new HBox(20, panelFormulario, panelTabla);
        root.setPadding(new Insets(20));

        cargarDatosEnTabla();

        return new Scene(root, 1100, 600);
    }

    private VBox crearPanelFormulario() {
        Label lblTitulo = new Label("Registra tu propiedad");

        cmbSeleccionarPropiedad = new ComboBox<>();
        cmbSeleccionarPropiedad.getItems().addAll("CASA", "DEPARTAMENTO");
        cmbSeleccionarPropiedad.setPromptText("Seleccione un tipo de propiedad");
        cmbSeleccionarPropiedad.setMaxWidth(Double.MAX_VALUE);

        txtDireccion = new TextField();
        txtDireccion.setPromptText("Ej: Egaña 651");

        txtArriendoBase = new TextField();
        txtArriendoBase.setPromptText("Ej: 500000");

        txtMetrosCuadrados = new TextField();
        txtMetrosCuadrados.setPromptText("Ej: 200");

        txtCantidadPisos = new TextField();
        txtCantidadPisos.setPromptText("Ej: 2");

        chkTienePatio = new CheckBox("Tiene patio");

        txtNumeroPiso = new TextField();
        txtNumeroPiso.setPromptText("Ej: 5");

        txtGastosComunes = new TextField();
        txtGastosComunes.setPromptText("Ej: 95000");

        VBox camposCasa = new VBox(6, txtCantidadPisos, chkTienePatio);
        VBox camposDepartamento = new VBox(6, txtNumeroPiso, txtGastosComunes);

        camposCasa.visibleProperty().bind(cmbSeleccionarPropiedad.valueProperty().isEqualTo("CASA"));
        camposCasa.managedProperty().bind(camposCasa.visibleProperty());

        camposDepartamento.visibleProperty().bind(cmbSeleccionarPropiedad.valueProperty().isEqualTo("DEPARTAMENTO"));
        camposDepartamento.managedProperty().bind(camposDepartamento.visibleProperty());
        
        Button btnRegistrar = new Button("Registrar");
        Button btnActualizar = new Button("Actualizar");
        Button btnEliminar = new Button("Eliminar");
        Button btnLimpiar = new Button("Limpiar");

        btnRegistrar.setOnAction(evento -> accionRegistrar());
        btnActualizar.setOnAction(evento -> accionActualizar());
        btnEliminar.setOnAction(evento -> accionEliminar());
        btnLimpiar.setOnAction(evento -> limpiarFormulario());

        var mostrarSeleccion = tablaPropiedades.getSelectionModel().selectedItemProperty();
        btnRegistrar.disableProperty().bind(mostrarSeleccion.isNotNull());
        btnActualizar.disableProperty().bind(mostrarSeleccion.isNull());
        btnEliminar.disableProperty().bind(mostrarSeleccion.isNull());

        HBox filaBotones = new HBox(8, btnRegistrar, btnActualizar, btnEliminar, btnLimpiar);

        lblEstado = new Label();
        lblEstado.setWrapText(true);
        
        VBox contenedorFormulario = new VBox(10, lblTitulo, cmbSeleccionarPropiedad, txtDireccion, txtArriendoBase, txtMetrosCuadrados, camposCasa, camposDepartamento, filaBotones, lblEstado);
        contenedorFormulario.setPrefWidth(270);
        return contenedorFormulario;
    }

    private VBox crearPanelTabla() {
        tablaPropiedades.setFixedCellSize(35);
        tablaPropiedades.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);

        TableColumn<Propiedad, Integer> columnaID = new TableColumn<>("ID");
        columnaID.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Propiedad, String> columnaTipo = new TableColumn<>("Tipo");
        columnaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));

        TableColumn<Propiedad, String> columnaDireccion = new TableColumn<>("Dirección");
        columnaDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));

        TableColumn<Propiedad, Integer> columnaMetros = new TableColumn<>("Metros Cuadrados");
        columnaMetros.setCellValueFactory(new PropertyValueFactory<>("metrosCuadrados"));

        TableColumn<Propiedad, Integer> columnaArriendoBase = new TableColumn<>("Arriendo Base");
        columnaArriendoBase.setCellValueFactory(new PropertyValueFactory<>("arriendoBase"));

        TableColumn<Propiedad, String> columnaDetalle = new TableColumn<>("Detalle");
        columnaDetalle.setCellValueFactory(new PropertyValueFactory<>("detalle"));

        TableColumn<Propiedad, Integer> columnaPago = new TableColumn<>("Pago Mensual");
        columnaPago.setCellValueFactory(datos -> {
            int pagoMensual = datos.getValue().calcularPagoMensual();
            return new ReadOnlyIntegerWrapper(pagoMensual).asObject();
        });

        // Al seleccionar una fila, cargar sus datos en el formulario.
        tablaPropiedades.getSelectionModel().selectedItemProperty().addListener(
            (observable, anterior, seleccionada) -> {
                if (seleccionada == null) {
                    idSeleccionado = -1;
                    return;
                }

                idSeleccionado = seleccionada.getId();
                cmbSeleccionarPropiedad.setValue(seleccionada.getTipo());
                txtDireccion.setText(seleccionada.getDireccion());
                txtArriendoBase.setText(String.valueOf(seleccionada.getArriendoBase()));
                txtMetrosCuadrados.setText(String.valueOf(seleccionada.getMetrosCuadrados()));

                if (seleccionada instanceof Casa casa) {
                    txtCantidadPisos.setText(String.valueOf(casa.getCantidadPisos()));
                    chkTienePatio.setSelected(casa.isTienePatio());
                    txtNumeroPiso.clear();
                    txtGastosComunes.clear();
                } else if (seleccionada instanceof Departamento departamento) {
                    txtNumeroPiso.setText(String.valueOf(departamento.getNumeroPiso()));
                    txtGastosComunes.setText(String.valueOf(departamento.getGastosComunes()));
                    txtCantidadPisos.clear();
                    chkTienePatio.setSelected(false);
                }
            });

        tablaPropiedades.getColumns().addAll(columnaID, columnaTipo, columnaDireccion, columnaMetros, columnaArriendoBase, columnaDetalle, columnaPago);

        VBox panelTabla = new VBox(8, new Label("Propiedades en arriendo"), tablaPropiedades);
        VBox.setVgrow(tablaPropiedades, Priority.ALWAYS);
        return panelTabla;
    }

    private void accionRegistrar() {
        String tipoPropiedad = cmbSeleccionarPropiedad.getValue();

        if (tipoPropiedad == null) {
            lblEstado.setText("Selecciona un tipo de propiedad");
            return;
        }

        try {
            String direccion = txtDireccion.getText().trim();
            int arriendoBase = Integer.parseInt(txtArriendoBase.getText().trim());
            int metrosCuadrados = Integer.parseInt(txtMetrosCuadrados.getText().trim());

            Propiedad propiedadNueva;

            if ("CASA".equals(tipoPropiedad)) {
                int cantidadPisos = Integer.parseInt(txtCantidadPisos.getText().trim());
                boolean tienePatio = chkTienePatio.isSelected();

                propiedadNueva = new Casa(0, direccion, arriendoBase, metrosCuadrados, cantidadPisos, tienePatio);
            } else {
                int numeroPiso = Integer.parseInt(txtNumeroPiso.getText().trim());
                int gastosComunes = Integer.parseInt(txtGastosComunes.getText().trim());

                propiedadNueva = new Departamento(0, direccion, arriendoBase, metrosCuadrados, numeroPiso, gastosComunes);
            }

            if (propiedadController.registrarPropiedad(propiedadNueva)) {
                limpiarFormulario();
                cargarDatosEnTabla();
                lblEstado.setText("Propiedad Registrada");
            } else {
                lblEstado.setText("No se pudo registrar la propiedad. Revisa los datos.");
            }
        } catch (NumberFormatException e) {
            lblEstado.setText("Completa los campos numéricos con enteros sin puntos ni comas.");
        }
    }

    private void accionActualizar() {
        if (idSeleccionado <= 0) {
            lblEstado.setText("Selecciona una propiedad de la tabla");
            return;
        }

        String tipoPropiedad = cmbSeleccionarPropiedad.getValue();

        if (tipoPropiedad == null) {
            lblEstado.setText("Selecciona un tipo de propiedad");
            return;
        }

        try {
            String direccion = txtDireccion.getText().trim();
            int arriendoBase = Integer.parseInt(txtArriendoBase.getText().trim());
            int metrosCuadrados = Integer.parseInt(txtMetrosCuadrados.getText().trim());

            Propiedad propiedadEditada;

            if ("CASA".equals(tipoPropiedad)) {
                int cantidadPisos = Integer.parseInt(txtCantidadPisos.getText().trim());
                boolean tienePatio = chkTienePatio.isSelected();

                propiedadEditada = new Casa(idSeleccionado, direccion, arriendoBase, metrosCuadrados, cantidadPisos, tienePatio);
            } else {
                int numeroPiso = Integer.parseInt(txtNumeroPiso.getText().trim());
                int gastosComunes = Integer.parseInt(txtGastosComunes.getText().trim());

                propiedadEditada = new Departamento(idSeleccionado, direccion, arriendoBase, metrosCuadrados, numeroPiso, gastosComunes);
            }

            if (propiedadController.actualizarPropiedad(propiedadEditada)) {
                limpiarFormulario();
                cargarDatosEnTabla();
                lblEstado.setText("Propiedad actualizada");
            } else {
                lblEstado.setText("No se pudo actualizar la propiedad. Revisa los datos.");
            }
        } catch (NumberFormatException e) {
            lblEstado.setText("Completa los campos numéricos con enteros sin puntos ni comas.");
        }
    }

    private void accionEliminar() {
        if (idSeleccionado <= 0) {
            lblEstado.setText("Selecciona una propiedad de la tabla");
            return;
        }

        if (propiedadController.eliminarPropiedad(idSeleccionado)) {
            limpiarFormulario();
            cargarDatosEnTabla();
            lblEstado.setText("Propiedad eliminada");
        } else {
            lblEstado.setText("No se pudo eliminar la propiedad");
        }
    }

    private void cargarDatosEnTabla() {
        tablaPropiedades.getItems().setAll(propiedadController.obtenerPropiedades());
    }

    private void limpiarFormulario() {
        tablaPropiedades.getSelectionModel().clearSelection();
        idSeleccionado = -1;
        cmbSeleccionarPropiedad.setValue(null);
        txtDireccion.clear();
        txtArriendoBase.clear();
        txtMetrosCuadrados.clear();
        txtCantidadPisos.clear();
        chkTienePatio.setSelected(false);
        txtNumeroPiso.clear();
        txtGastosComunes.clear();
        lblEstado.setText("");

    }
    
}
