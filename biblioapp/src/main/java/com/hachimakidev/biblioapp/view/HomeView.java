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

btn_search_user.setOnAction( e -> {
    UserController userController = new UserController();

    lbl_user_data_rut.setText("Rut: ____________");
    lbl_user_data_nombre.setText("Nombre: ____________");
    lbl_user_data_email.setText("Email: ____________");
    lbl_user_data_edad.setText("Edad: ____________");
    lbl_user_data_puede_pedir.setText("¿Puede solicitar libros?: ____________");

    String rut = txf_user_rut.getText().trim();

    if (rut.isBlank()) {
        lbl_user_data_rut.setText("Escribe un RUT antes de buscar.");
    } else {
        User usuario = userController.buscarUsuario(rut);

        if (usuario != null) {
            lbl_user_data_rut.setText("Rut: " + usuario.getRut());
            lbl_user_data_nombre.setText("Nombre: " + usuario.getNombre());
            lbl_user_data_email.setText("Email: " + usuario.getEmail());
            lbl_user_data_edad.setText("Edad: " + usuario.getEdad());
            lbl_user_data_puede_pedir.setText("¿Puede solicitar libros?: " + usuario.isPuede_solicitar_prestamos());
        } else {
            lbl_user_data_rut.setText("Usuario no encontrado");
        }
    }
} );

        VBox vbox_user_data = new VBox(5, lbl_user_data_rut, lbl_user_data_nombre, lbl_user_data_email, lbl_user_data_edad, lbl_user_data_puede_pedir);

        VBox vbox_home = new VBox(30, hbox_search_user, vbox_user_data);

        Scene home_scene = new Scene(vbox_home, 720, 480);

        return home_scene;
    }

}
