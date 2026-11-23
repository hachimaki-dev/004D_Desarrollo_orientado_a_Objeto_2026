
package com.caso2_franco_dietert.view;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import com.caso2_franco_dietert.controller.PropiedadController;
import com.caso2_franco_dietert.model.Casa;
import com.caso2_franco_dietert.model.Departamento;
import com.caso2_franco_dietert.model.Propiedad;

public class PropiedadView {

    PropiedadController controller = new PropiedadController();

    TableView<Propiedad> tablaPropiedades;

    Label tituloFormulario;
    ComboBox<String> tipoPropiedad;

    TextField txf_id;
    TextField txf_direccion;
    TextField txf_arriendoBase;
    TextField txf_metrosCuadrados;

    HBox contenedor_formulario;
    HBox contenedor_especificaciones;
    HBox contenedor_botones;

    VBox contenedor_principal;

    TextField cantidadPisos;
    CheckBox tienePatio;

    TextField numeroPiso;
    TextField gastosComunes;

    Button botonActualizar;
    Button botonAgregar;
    Button botonEliminar;


    // CONSTRUCTOR

    public PropiedadView() {

        tituloFormulario = new Label("Formulario Propiedades");

        tipoPropiedad = new ComboBox<>();
        tipoPropiedad.getItems().addAll("Casa", "Departamento");
        tipoPropiedad.setValue("Casa");

        txf_id = new TextField();
        txf_id.setPromptText("ID");

        txf_direccion = new TextField();
        txf_direccion.setPromptText("Dirección");

        txf_arriendoBase = new TextField();
        txf_arriendoBase.setPromptText("Arriendo base");

        txf_metrosCuadrados = new TextField();
        txf_metrosCuadrados.setPromptText("Metros cuadrados");


        // ESPECIFICACIONES

        cantidadPisos = new TextField();
        cantidadPisos.setPromptText("Cantidad de pisos");

        tienePatio = new CheckBox();
        tienePatio.setText("Tiene patio");

        numeroPiso = new TextField();
        numeroPiso.setPromptText("Número de piso");

        gastosComunes = new TextField();
        gastosComunes.setPromptText("Gastos comunes");


        contenedor_especificaciones = new HBox(10);
        contenedor_especificaciones.getChildren().setAll(
            cantidadPisos, tienePatio
        );


        // COMBOBOX

        tipoPropiedad.setOnAction(event -> {

            if (tipoPropiedad.getValue().equals("Departamento")) {

                contenedor_especificaciones.getChildren().setAll(
                    numeroPiso, gastosComunes
                );

            } else {

                contenedor_especificaciones.getChildren().setAll(
                    cantidadPisos, tienePatio
                );
            }

        });


        // BOTON AGREGAR

        botonAgregar = new Button("Agregar propiedad");

        botonAgregar.setOnAction(event -> {

            int id = Integer.parseInt(txf_id.getText());
            String direccion = txf_direccion.getText();
            int arriendoBase = Integer.parseInt(txf_arriendoBase.getText());
            int metrosCuadrados = Integer.parseInt(txf_metrosCuadrados.getText());

            String tipo = tipoPropiedad.getValue();

            if (tipo.equals("Casa")) {

                int pisos = Integer.parseInt(cantidadPisos.getText());
                boolean patio = tienePatio.isSelected();

                Casa casa = new Casa(
                    id, direccion, arriendoBase,
                    metrosCuadrados, pisos, patio
                );

                controller.insertarPropiedad(casa);

            } else if (tipo.equals("Departamento")) {

                int piso = Integer.parseInt(numeroPiso.getText());
                int gastos = Integer.parseInt(gastosComunes.getText());

                Departamento departamento = new Departamento(
                    id, direccion, arriendoBase,
                    metrosCuadrados, piso, gastos
                );

                controller.insertarPropiedad(departamento);
            }

            tablaPropiedades.setItems(
                FXCollections.observableArrayList(
                    controller.listarPropiedades()
                )
            );

        });


        // BOTON ACTUALIZAR

        botonActualizar = new Button("Actualizar propiedad");

        botonActualizar.setOnAction(event -> {

            int id = Integer.parseInt(txf_id.getText());
            String direccion = txf_direccion.getText();
            int arriendoBase = Integer.parseInt(txf_arriendoBase.getText());
            int metrosCuadrados = Integer.parseInt(txf_metrosCuadrados.getText());

            String tipo = tipoPropiedad.getValue();

            if (tipo.equals("Casa")) {

                int pisos = Integer.parseInt(cantidadPisos.getText());
                boolean patio = tienePatio.isSelected();

                Casa casa = new Casa(
                    id, direccion, arriendoBase,
                    metrosCuadrados, pisos, patio
                );

                controller.actualizarPropiedad(casa);

            } else if (tipo.equals("Departamento")) {

                int piso = Integer.parseInt(numeroPiso.getText());
                int gastos = Integer.parseInt(gastosComunes.getText());

                Departamento departamento = new Departamento(
                    id, direccion, arriendoBase,
                    metrosCuadrados, piso, gastos
                );

                controller.actualizarPropiedad(departamento);
            }

            tablaPropiedades.setItems(
                FXCollections.observableArrayList(
                    controller.listarPropiedades()
                )
            );

        });


        // BOTON ELIMINAR

        botonEliminar = new Button("Eliminar propiedad");

        botonEliminar.setOnAction(event -> {

            int id = Integer.parseInt(txf_id.getText());

            controller.eliminarPropiedad(id);

            tablaPropiedades.setItems(
                FXCollections.observableArrayList(
                    controller.listarPropiedades()
                )
            );

        });


        // CONTENEDOR BOTONES

        contenedor_botones = new HBox(
            10, botonAgregar, botonActualizar, botonEliminar
        );


        // CONTENEDOR FORMULARIO

        contenedor_formulario = new HBox(10);

        contenedor_formulario.getChildren().addAll(
            txf_id,
            txf_direccion,
            txf_arriendoBase,
            txf_metrosCuadrados,
            tipoPropiedad
        );


        // TABLA

        tablaPropiedades = new TableView<>();

        TableColumn<Propiedad, Integer> colId =
            new TableColumn<>("ID");

        colId.setCellValueFactory(
            new PropertyValueFactory<>("id")
        );

        TableColumn<Propiedad, String> colTipo =
            new TableColumn<>("TIPO");

        colTipo.setCellValueFactory(
            new PropertyValueFactory<>("tipo")
        );

        TableColumn<Propiedad, String> colDireccion =
            new TableColumn<>("DIRECCION");

        colDireccion.setCellValueFactory(
            new PropertyValueFactory<>("direccion")
        );

        TableColumn<Propiedad, Integer> colArriendoBase =
            new TableColumn<>("ARRIENDO BASE");

        colArriendoBase.setCellValueFactory(
            new PropertyValueFactory<>("arriendoBase")
        );

        TableColumn<Propiedad, Integer> colMetrosCuadrados =
            new TableColumn<>("METROS CUADRADOS");

        colMetrosCuadrados.setCellValueFactory(
            new PropertyValueFactory<>("metrosCuadrados")
        );

        TableColumn<Propiedad, String> colDetalle =
            new TableColumn<>("DETALLE");

        colDetalle.setCellValueFactory(
            new PropertyValueFactory<>("detalle")
        );

        tablaPropiedades.getColumns().addAll(
            colId,
            colTipo,
            colDireccion,
            colArriendoBase,
            colMetrosCuadrados,
            colDetalle
        );


        // CARGAR DATOS

        tablaPropiedades.setItems(
            FXCollections.observableArrayList(
                controller.listarPropiedades()
            )
        );


        // CONTENEDOR PRINCIPAL

        contenedor_principal = new VBox(
            15,
            tituloFormulario,
            contenedor_formulario,
            contenedor_especificaciones,
            contenedor_botones,
            tablaPropiedades
        );

        contenedor_principal.setPadding(new Insets(20));

    }


    // OBTENER LA VISTA

    public VBox getVista() {

        return contenedor_principal;
    }

}
