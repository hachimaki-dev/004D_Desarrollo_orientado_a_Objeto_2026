package com.hachimakidev.techstore.view;

import com.hachimakidev.techstore.model.Dispositivo;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CatalogoView {

    public VBox catalogo() {
        // TODO 1: Instanciar DispositivoController para pedirle la lista de dispositivos y registrar nuevos equipos.

        Label lbl_titulo = new Label("TechStore — Catálogo de Notebooks y Smartphones");
        lbl_titulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // TODO 2: Reemplazar este contenedor temporal por un TableView<Dispositivo>
        //   - Crear columnas con PropertyValueFactory para: "id", "tipo", "marca", "modelo", "precio", "especificacion", "disponible"
        //   - Poblar la tabla usando FXCollections.observableArrayList(...) con la lista del controlador
        TableView<Dispositivo> tableVie;
        VBox contenedor_tabla = new VBox(10, lbl_placeholder_tabla);
        contenedor_tabla.setPadding(new Insets(20));
        contenedor_tabla.setStyle("-fx-border-color: #cbd5e1; -fx-border-radius: 6; -fx-background-color: #f8fafc;");

        // TODO 3: Construir el formulario en este contenedor para agregar un nuevo Notebook o Smartphone
        //   - Incluir controles (TextField / ComboBox) para ingresar los datos del nuevo dispositivo
        //   - Incluir un Button "Agregar Dispositivo" cuyo setOnAction cree el objeto, lo envíe al controlador y actualice la TableView
        Label lbl_placeholder_form = new Label("[ TODO: Construir aquí el formulario para agregar un nuevo Dispositivo a la TableView ]");
        HBox fila_formulario = new HBox(10, lbl_placeholder_form);
        VBox contenedor_formulario = new VBox(10, fila_formulario);
        contenedor_formulario.setPadding(new Insets(16));
        contenedor_formulario.setStyle("-fx-border-color: #cbd5e1; -fx-border-radius: 6; -fx-background-color: #ffffff;");

        VBox layout_principal = new VBox(16, lbl_titulo, contenedor_tabla, contenedor_formulario);
        layout_principal.setPadding(new Insets(20));

        return layout_principal;
    }
}

