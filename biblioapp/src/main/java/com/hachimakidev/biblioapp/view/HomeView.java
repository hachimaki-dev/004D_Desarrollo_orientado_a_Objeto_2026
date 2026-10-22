package com.hachimakidev.biblioapp.view;

import com.hachimakidev.biblioapp.controller.UserController;
import com.hachimakidev.biblioapp.model.User;

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

        HBox hbox_search_user = new HBox(10, lbl_user_rut, txf_user_rut, btn_search_user);

        Label lbl_user_data_rut = new Label("Rut: ____________");
        Label lbl_user_data_nombre = new Label("Nombre: ____________");
        Label lbl_user_data_email = new Label("Email: ____________");
        Label lbl_user_data_edad = new Label("Edad: ____________");
        Label lbl_user_data_puede_pedir = new Label("¿Puede solicitar libros?: ____________");

        VBox vbox_user_data = new VBox(5, lbl_user_data_rut, lbl_user_data_nombre, lbl_user_data_email, lbl_user_data_edad, lbl_user_data_puede_pedir);

        VBox vbox_home = new VBox(30, hbox_search_user, vbox_user_data);

        Scene home_scene = new Scene(vbox_home, 720, 480);

        btn_search_user.setOnAction( e -> {
            UserController userController = new UserController();

            String rut = new txf_user_rut.getText();

            User usuario = userController.buscarUsuario(rut);

            lbl_user_data_rut.setText(usuario.getRut());
            lbl_user_data_nombre.setText(usuario.getNombre());
            lbl_user_data_email.setText(usuario.getEmail());
            lbl_user_data_edad.setText(usuario.getEdad());
            

        } );

        return home_scene;
    }

}
