package com.video.juegos.view;

import com.video.juegos.model.Usuario;
import com.video.juegos.controller.UserController;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HomeView {
    
    public Scene homeScene(){
        return new Scene(contenedorBusquedaUsuario(), 720, 480);
    }

    private VBox buscadorUsuario() {

        Label lbl_panel_superior = new Label("CONSULTA DE SOCIO GAMER");
        Label lbl_user_rut = new Label("RUT:");

        TextField txf_user_rut = new TextField();
        txf_user_rut.setPromptText("Ej: 11.111.111-1");

        Button btn_search_user = new Button("Buscar socio");

        HBox hbox_search_user = new HBox(10, lbl_user_rut, txf_user_rut, btn_search_user);

        Label lbl_user_data_rut = new Label("RUT: _____________");
        Label lbl_user_data_nombre = new Label("Nombre: _____________");
        Label lbl_user_data_nivel = new Label("Nivel Gamer: _____________");
        Label lbl_user_data_email = new Label("Email: _____________");

        Label lbl_mensaje = new Label();

        HBox hbox_user_data = new HBox(5, lbl_user_data_rut, lbl_user_data_nombre, lbl_user_data_nivel, lbl_user_data_email);

        VBox vbox_panel_superior = new VBox(10, lbl_panel_superior, hbox_search_user, hbox_user_data, lbl_mensaje);

        btn_search_user.setOnAction(e -> {

            String rut = txf_user_rut.getText().trim();

            if (rut.isEmpty()) {
                lbl_user_data_rut.setText("RUT: _____________");
                lbl_user_data_nombre.setText("Nombre: _____________");
                lbl_user_data_nivel.setText("Nivel Gamer: _____________");
                lbl_user_data_email.setText("Email: _____________");

                lbl_mensaje.setText("Ingrese un RUT para buscar.");
                return;
            }

            UserController userController = new UserController();
            Usuario usuario = userController.buscarUsuario(rut);

            if (usuario == null) { //Para evitar error si el rut esta vacio/nulo
                lbl_user_data_rut.setText("RUT: _____________");
                lbl_user_data_nombre.setText("Nombre: _____________");
                lbl_user_data_nivel.setText("Nivel Gamer: _____________");
                lbl_user_data_email.setText("Email: _____________");

                lbl_mensaje.setText("No se encontró un usuario con ese RUT.");
                return;
            }

            lbl_user_data_rut.setText("RUT: " + usuario.getRut());
            lbl_user_data_nombre.setText("Nombre: " + usuario.getNombre());
            lbl_user_data_nivel.setText("Nivel Gamer: " + usuario.getNivelGamer());
            lbl_user_data_email.setText("Email: " + usuario.getEmail());

            lbl_mensaje.setText("Usuario encontrado.");
        });


        txf_user_rut.setOnAction(e -> btn_search_user.fire());//buscar con enter

        return vbox_panel_superior;
    }

    public VBox contenedorBusquedaUsuario() {
        VBox contenedorUsuario = new VBox(10, buscadorUsuario());
        contenedorUsuario.setPadding(new Insets(20));
        return contenedorUsuario;
    }

    
}
