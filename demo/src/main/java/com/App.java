package com;

import com.view.UsuarioView;

import javafx.application.Application;
import javafx.stage.Stage;


public class App extends Application 
{

    @Override
    public void start(Stage stage) {
        UsuarioView vista = new UsuarioView();
        stage.setTitle("Gestión de Usuarios — Oracle JDBC + MVC + DAO");
        stage.setScene(vista.crearEscena());
        stage.show();
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
}