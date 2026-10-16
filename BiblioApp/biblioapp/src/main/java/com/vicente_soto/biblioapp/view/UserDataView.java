package com.vicente_soto.biblioapp.view;

import com.vicente_soto.biblioapp.controller.UserController;
import com.vicente_soto.biblioapp.model.User;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class UserDataView {

    public VBox userData() {

        UserController controller = new UserController();

        Label lbl_user_rut = new Label("RUT del usuario:");
        TextField txf_user_rut = new TextField();
        txf_user_rut.setPromptText("Ej: 12345678-9");
        Button btn_buscar = new Button("Buscar");

        Label lbl_resultado = new Label();
        Label lbl_rut = new Label("RUT: —");
        Label lbl_nombre = new Label("Nombre: —");
        Label lbl_correo = new Label("Correo: —");

        btn_buscar.setOnAction(evento -> {
            lbl_rut.setText("RUT: —");
            lbl_nombre.setText("Nombre: —");
            lbl_correo.setText("Correo: —");

            String rut_ingresado = txf_user_rut.getText();

            if (!controller.datosDisponibles()) {
                lbl_resultado.setText("Error: no se pudieron cargar los datos de usuarios.");
            } else if (rut_ingresado.isBlank()) {
                lbl_resultado.setText("Escribe un RUT antes de buscar.");
            } else {
                User usuario = controller.buscarUsuario(rut_ingresado);

                if (usuario != null) {
                    lbl_resultado.setText("Usuario encontrado.");
                    lbl_rut.setText("RUT: " + usuario.getRut());
                    lbl_nombre.setText("Nombre: " + usuario.getNombre());
                    lbl_correo.setText("Correo: " + usuario.getCorreo());
                } else {
                    lbl_resultado.setText("Usuario no encontrado.");
                }
            }
        });

        HBox fila_busqueda = new HBox(10, lbl_user_rut, txf_user_rut, btn_buscar);
        VBox box = new VBox(10, fila_busqueda, lbl_resultado, lbl_rut, lbl_nombre, lbl_correo);
        box.setPadding(new Insets(20));

        return box;
    }
}