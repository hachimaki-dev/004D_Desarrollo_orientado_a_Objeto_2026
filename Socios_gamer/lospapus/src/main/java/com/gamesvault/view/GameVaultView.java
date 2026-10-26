package com.gamesvault.view;

import com.gamesvault.model.Usuario;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GameVaultView {
    public Scene homeScene(){

        Label lbl_usuario_rut = new Label("Rut: ");
        TextField txf_usuario_rut = new TextField();
        txf_usuario_rut.setPromptText("ej: 11.111.111-1");
        Button btn_buscar_usuario = new Button("Buscar c:");
        

        HBox hbox_buscar_usuario = new HBox(10, lbl_usuario_rut, txf_usuario_rut, btn_buscar_usuario);

        Label lbl_usuario_data_rut = new Label("Rut: ");
        Label lbl_usuario_data_nombre = new Label("Nombre: ");
        Label lbl_usuario_data_email = new Label("Email: ");
        Label lbl_usuario_data_nivel_gamer = new Label("Nivel: ");

        VBox vbox_usuario_data = new VBox(5, lbl_usuario_data_rut, lbl_usuario_data_nombre, lbl_usuario_data_email, lbl_usuario_data_nivel_gamer);

        VBox vbox_home = new VBox(30, hbox_buscar_usuario, vbox_usuario_data);

        Scene home_scene = new Scene(vbox_home, 720, 480);

        btn_buscar_usuario.setOnAction(e -> {
            UsuarioController usuarioController = new UsuarioController();

            String rut  = txf_usuario_rut.getText();

            Usuario usuario_recibido = usuarioController.buscarUsuario( rut );

            lbl_usuario_data_rut.setText(usuario_recibido.getRut());
            lbl_usuario_data_nombre.setText(usuario_recibido.getNombre());
            lbl_usuario_data_email.setText(usuario_recibido.getEmail());
            lbl_usuario_data_nivel_gamer.setText(usuario_recibido.getNivel_gamer());
        });

    }
}