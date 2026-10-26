package com.hachimakidev.biblioapp.view;

import com.hachimakidev.biblioapp.controller.LibroController;
import com.hachimakidev.biblioapp.model.Libros;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LibroView {
    
    public Scene libroScene(){

        Label lbl_titulo_lbl = new Label("Titulo: ");
        TextField txf_libro = new TextField();
        txf_libro.setPromptText("ej: matias maraca ");
        Button btn_search_libro = new Button("Buscar :)");

        HBox hbox_search_user = new HBox(10, lbl_titulo_lbl, txf_libro, btn_search_libro);

        Label lbl_titulo = new Label("Titulo: ____________");
        Label lbl_fechapublicacion = new Label("Fecha de Publicacion : ____________");
        Label lbl_autor = new Label("Autor: ____________");
        Label lbl_numero_de_paginas = new Label("Numero de Paginas : ____________");

        VBox vbox_user_data = new VBox(5, lbl_titulo, lbl_fechapublicacion, lbl_autor, lbl_numero_de_paginas );

        VBox vbox_home = new VBox(30, hbox_search_user, vbox_user_data);

        Scene libro_scene = new Scene(vbox_home, 720, 480);

        btn_search_libro.setOnAction( e -> {
            LibroController libroController = new LibroController();

            String libro_txt = txf_libro.getText();

            Libros libro = libroController.buscarPorTitulo(libro_txt);

            lbl_titulo.setText("Titulo : " + libro.getTitulo());
            lbl_fechapublicacion.setText("Fecha de PUblicacion  : " + libro.get_fechapublicacion());
            lbl_autor.setText("Autor : " + libro.getAutor());
            lbl_numero_de_paginas.setText( "Numero de paginas : " + libro.getNumeroPaginas() + "");

        } );

        return libro_scene;
    }







}
