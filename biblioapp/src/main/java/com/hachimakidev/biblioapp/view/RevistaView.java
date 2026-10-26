package com.hachimakidev.biblioapp.view;

import com.hachimakidev.biblioapp.controller.RevistaController;
import com.hachimakidev.biblioapp.model.Revistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RevistaView {
    
    public Scene revistaScene(){

        Label lbl_titulo = new Label("Titulo: ");
        TextField txf_titulo = new TextField();
        txf_titulo.setPromptText("ej: Time");
        Button btn_search_revista = new Button("Buscar :)");

        HBox hbox_search_revista = new HBox(10, lbl_titulo, txf_titulo, btn_search_revista);

        Label lblRevistaDataTitulo = new Label("Titulo: ____________");
        Label lblRevistaPublicacion = new Label("Fecha de publicación: ____________");
        Label lblEditorial = new Label("Editorial: ____________");
        Label lblPeriodicidad = new Label("Periodicidad: ____________");
      

        VBox vboxRevistaData = new VBox(5, lblRevistaDataTitulo, lblRevistaPublicacion, lblEditorial, lblPeriodicidad);

        VBox vbox_home = new VBox(30, hbox_search_revista, vboxRevistaData);

        Scene revista_scene = new Scene(vbox_home, 720, 480);

        btn_search_revista.setOnAction( e -> {
            RevistaController revistacontroller = new RevistaController();

            String revista_txf = txf_titulo.getText();

            Revistas revista = revistacontroller.buscarPorTitulo(revista_txf);

            lblRevistaDataTitulo.setText("Titulo : " + revista.getTitulo());
            lblRevistaPublicacion.setText("Fecha de publicación : " + revista.get_fechapublicacion());
            lblEditorial.setText("Editorial : " + revista.get_editorial());
            lblPeriodicidad.setText( "Periodicidad : " + revista.getPeriodicidad() + "");

        } );

        return revista_scene;
    }







}
