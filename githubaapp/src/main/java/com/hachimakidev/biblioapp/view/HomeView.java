package com.hachimakidev.biblioapp.view;

import com.hachimakidev.biblioapp.controller.UserController;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HomeView {

    public Scene homeScene() {

        Label lbl_user_rut = new Label("Rut: ");
        TextField txf_user_rut = new TextField();
        txf_user_rut.setPromptText("ej: 11.111.111-1");
        Button btn_search_user = new Button("Buscar");

        // Usamos addAll para evitar problemas con los constructores del HBox
        HBox hbox_search_user = new HBox(10);
        hbox_search_user.getChildren().addAll(lbl_user_rut, txf_user_rut, btn_search_user);

        Label lbl_user_data_rut = new Label("Rut: __________");
        Label lbl_user_data_nombre = new Label("Nombre: __________");
        Label lbl_user_data_email = new Label("Email: __________");
        Label lbl_user_data_edad = new Label("Edad: __________");
        Label lbl_user_data_prestamo = new Label("¿Puede pedir libros?: __________");

        // Hacemos lo mismo con el VBox de datos
        VBox vbox_user_data = new VBox(5);
        vbox_user_data.getChildren().addAll(
            lbl_user_data_rut, 
            lbl_user_data_nombre, 
            lbl_user_data_email, 
            lbl_user_data_edad, 
            lbl_user_data_prestamo
        );

        // VBox principal de la vista
        VBox vbox_home = new VBox(30);
        vbox_home.getChildren().addAll(hbox_search_user, vbox_user_data);

        Scene home_scene = new Scene(vbox_home, 720, 480);

        btn_search_user.setOnAction(e ->{
            UserController userController = new UserController();

            userController.test();
        });

        return home_scene;
    }
}