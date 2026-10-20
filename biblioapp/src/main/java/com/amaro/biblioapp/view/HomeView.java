package com.amaro.biblioapp.view;

import com.amaro.biblioapp.controller.UserController;
import com.amaro.biblioapp.model.User;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HomeView {
    private User us;

    public Scene homeScene() {
        Label lbl_user_rut = new Label("Rut: ");
        TextField txf_user_rut = new TextField();
        txf_user_rut.setPromptText("Ej: 11.111.111-1");
        Button btn_search_user = new Button("Buscar");
        HBox hbox_search_user = new HBox(10, lbl_user_rut, txf_user_rut, btn_search_user);

        Label lbl_user_data_rut = new Label("Rut: ___________");
        Label lbl_user_data_nombre = new Label("Nombre: ___________");
        Label lbl_user_data_email = new Label("Email: ___________");
        Label lbl_user_data_edad = new Label("Edad: ___________");
        Label lbl_user_data_pedir = new Label("¿Puede pedir prestamo?: ___________");
        VBox vbox_user_data = new VBox(5, lbl_user_data_rut, lbl_user_data_nombre, lbl_user_data_email, lbl_user_data_edad, lbl_user_data_pedir);

        VBox vbox_home = new VBox(30, hbox_search_user, vbox_user_data);

        Scene home_scene = new Scene(vbox_home, 720, 480);
        btn_search_user.setOnAction(e -> {
            UserController userController = new UserController();
            String rut = txf_user_rut.getText();
            us = userController.searchUserByRut(rut);
            lbl_user_data_rut.setText(us.getRut());
            lbl_user_data_nombre.setText(us.getNombre());
            lbl_user_data_email.setText(us.getEmail());
            lbl_user_data_edad.setText(us.getEdad() + "");
            lbl_user_data_pedir.setText(us.isPuede_solicitar_prestamos() + "");
        });

        return home_scene;
    }
}
