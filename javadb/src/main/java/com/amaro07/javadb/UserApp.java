package com.amaro07.javadb;

import com.amaro07.javadb.view.UsuarioView;

import javafx.application.Application;
import javafx.stage.Stage;

public class UserApp extends Application {
    @Override
    public void start(Stage stage) {
        UsuarioView vista = new UsuarioView();
        stage.setTitle("Gestión de Usuarios — Oracle JDBC + MVC + DAO");
        stage.setScene(vista.crearEscena());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
