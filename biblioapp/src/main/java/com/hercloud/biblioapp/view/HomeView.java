package com.hercloud.biblioapp.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HomeView 
{
    public Scene homeScene()
    {
        Label lbl_user_rut = new Label("Rut: ");
        
        TextField txf_user_rut = new TextField();
        txf_user_rut.setPromptText("ej: 11.111.111-1");

        Button btm_user_search = new Button("Buscar");

        HBox hbox_search_user = new HBox(10, lbl_user_rut, txf_user_rut, btm_user_search);

        Label lbl_user_data_rut = new Label("Rut:_______ ");
        Label lbl_user_data_nombre = new Label("Nombre:_______ ");
        Label lbl_user_data_email = new Label("Email:_______ ");
        Label lbl_user_data_edad = new Label("Edad:________ ");
        Label lbl_user_data_puede_pedir = new Label("¿Puede solicitar un libr?:_________ ");

        VBox vbox_home = new VBox(5, lbl_user_data_rut, lbl_user_data_nombre, lbl_user_data_email, lbl_user_data_edad, lbl_user_data_puede_pedir);

        VBox vbox_home = new VBox();

    }
}



