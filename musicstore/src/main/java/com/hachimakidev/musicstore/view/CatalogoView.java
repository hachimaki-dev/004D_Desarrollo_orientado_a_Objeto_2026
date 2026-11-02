package com.hachimakidev.musicstore.view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CatalogoView {

    public VBox catalogo() {
        Label lbl_titulo = new Label("MusicStore — Catálogo de Guitarras y Teclados");
        lbl_titulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label lbl_placeholder_tabla = new Label("[ Espacio para la tabla de instrumentos ]");
        VBox contenedor_tabla = new VBox(10, lbl_placeholder_tabla);
        contenedor_tabla.setPadding(new Insets(20));
        contenedor_tabla.setStyle("-fx-border-color: #cbd5e1; -fx-border-radius: 6; -fx-background-color: #f8fafc;");

        Label lbl_placeholder_form = new Label("[ Espacio para el formulario de registro ]");
        HBox fila_formulario = new HBox(10, lbl_placeholder_form);
        VBox contenedor_formulario = new VBox(10, fila_formulario);
        contenedor_formulario.setPadding(new Insets(16));
        contenedor_formulario.setStyle("-fx-border-color: #cbd5e1; -fx-border-radius: 6; -fx-background-color: #ffffff;");

        VBox layout_principal = new VBox(16, lbl_titulo, contenedor_tabla, contenedor_formulario);
        layout_principal.setPadding(new Insets(20));

        return layout_principal;
    }
}
