package com.hachimakidev.biblioapp.view;

import com.hachimakidev.biblioapp.controller.UserController;
import com.hachimakidev.biblioapp.model.User;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class searchRutView {
    
    public VBox homeScene(){

        Label lbl_user_rut = new Label("RUT:");
        lbl_user_rut.setStyle("-fx-font-weight: 700; -fx-font-size: 15px");

        TextField txf_user_rut = new TextField();
        txf_user_rut.setPromptText("ej: 11.111.111-1");

        Button btn_search_user = new Button("Buscar");
        btn_search_user.setStyle("-fx-background-color: rgb(248, 135, 5); -fx-font-weight: 700");

        HBox hbox_search_user = new HBox(10, lbl_user_rut, txf_user_rut, btn_search_user);

        Label lbl_user_data_rut = new Label("");
        Label lbl_user_data_nombre = new Label("");
        Label lbl_user_data_email = new Label("");
        Label lbl_user_data_edad = new Label("");
        Label lbl_user_data_puede_pedir = new Label("");

        VBox vbox_user_data = new VBox(5, lbl_user_data_rut, lbl_user_data_nombre, lbl_user_data_email, lbl_user_data_edad, lbl_user_data_puede_pedir);

        VBox vbox_home = new VBox(30, hbox_search_user, vbox_user_data);

        btn_search_user.setOnAction(e -> 
        {

            String rut = txf_user_rut.getText();

            UserController userController = new UserController();

            User user = userController.buscarUsuario(rut);

            if (user == null)
            {

            }
            else
            {
                lbl_user_data_rut.setText("Rut: " + user.getRut());
                lbl_user_data_edad.setText("Edad: " + user.getEdad());
                lbl_user_data_nombre.setText("Nombre: " + user.getNombre());
                lbl_user_data_email.setText("Email: " + user.getEmail());
                lbl_user_data_puede_pedir.setText("¿Puede solicitar libros?: " + user.isPuede_solicitar_prestamos());
            }
            
        }
                                   );

        return vbox_home;
    }

}
