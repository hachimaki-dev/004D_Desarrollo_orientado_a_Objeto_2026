package com.caso2_franco_dietert.view;

import javafx.scene.Scene;
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
import com.caso2_franco_dietert.model.Propiedad;

import javafx.geometry.Insets;

public class PropiedadView {

    PropiedadController controller = new PropiedadController();
    TableView <Propiedad> tablaPropiedades;

    Label tituloFormulario;
    ComboBox <String> tipoPropiedad;

    TextField txf_id;
    TextField txf_direccion;
    TextField txf_arriendoBase;
    TextField txf_metrosCuadrados;

    HBox contenedor_formulario;
    HBox contenedor_especificaciones;

    VBox contenedor_principal;

    TextField cantidadPisos;

    CheckBox tienePatio;

    TextField numeroPiso;

    TextField gastosComunes;

//-------------------------------------------------------------------------------------------------------------------------------

    public PropiedadView () {

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

    cantidadPisos = new TextField();
    cantidadPisos.setPromptText("Cantidad pisos");

    tienePatio = new CheckBox();
    tienePatio.setText("Tiene patio");

    numeroPiso = new TextField();
    numeroPiso.setPromptText("Numero de piso");

    gastosComunes = new TextField();
    gastosComunes.setPromptText("Gastos comunes");

    contenedor_especificaciones = new HBox (10);
    contenedor_especificaciones.getChildren().setAll(cantidadPisos, tienePatio);

    contenedor_formulario = new HBox(10);
    contenedor_formulario.getChildren().addAll(txf_id, txf_direccion, txf_arriendoBase, txf_metrosCuadrados, tipoPropiedad);

//-----------------------------------------------------------------------------------------------------------------------------------
        // tabla

    tablaPropiedades = new TableView<>();

    TableColumn <Propiedad, Integer> colId = new TableColumn<>("ID");
    colId.setCellValueFactory(new PropertyValueFactory<>("id"));

    TableColumn <Propiedad, String> colTipo = new TableColumn<>("TIPO");
    colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));

    TableColumn <Propiedad, String> colDireccion = new TableColumn<>("DIRECCION");
    colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));

    TableColumn <Propiedad, Integer> colArriendoBase = new TableColumn<>("ARRIENDO BASE");
    colArriendoBase.setCellValueFactory(new PropertyValueFactory<>("arriendoBase"));

    TableColumn <Propiedad, Integer> colMetrosCuadrados = new TableColumn<>("METROS CUADRADOS");
    colMetrosCuadrados.setCellValueFactory(new PropertyValueFactory<>("metrosCuadrados"));

    tablaPropiedades.getColumns().addAll(colId, colTipo, colDireccion, colArriendoBase, colMetrosCuadrados);
//-----------------------------------------------------------------------------------------------------------------------------------

    contenedor_principal = new VBox(15, tituloFormulario, contenedor_formulario, contenedor_especificaciones, tablaPropiedades);
    contenedor_principal.setPadding(new Insets(20));
}

}
