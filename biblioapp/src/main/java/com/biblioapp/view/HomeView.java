package com.biblioapp.view;

import com.biblioapp.controller.UserController;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HomeView {
    public Scene homeScene(){

        Label lbl_user_rut = new Label("Rut: ");
        TextField txf_user_rut = new TextField();
        txf_user_rut.setPromptText("ej: 11.111.111-1");
        Button btn_search_user = new Button("Buscar c:");

        HBox hbox_search_user = new HBox(20, lbl_user_rut, txf_user_rut, btn_search_user);

        Label lbl_user_data_rut = new Label("Rut: ____________");
        Label lbl_user_data_nombre = new Label("Nombre: ____________");
        Label lbl_user_data_email = new Label("Email: ____________");
        Label lbl_user_data_edad = new Label("Edad: ____________");
        Label lbl_user_data_puede_pedir = new Label("¿Puede solicitar libros?: ____________");

        VBox vBox_user_data = new VBox(20, lbl_user_data_rut, lbl_user_data_nombre, lbl_user_data_email, lbl_user_data_edad, lbl_user_data_puede_pedir);
        
        VBox vBox_home = new VBox(20, hbox_search_user, vBox_user_data);

        Scene home_scene = new Scene(vBox_home, 720, 480);

        btn_search_user.setOnAction( e -> {
            UserController userController = new UserController();

            userController.test();
        });

        return home_scene;
    }
}
