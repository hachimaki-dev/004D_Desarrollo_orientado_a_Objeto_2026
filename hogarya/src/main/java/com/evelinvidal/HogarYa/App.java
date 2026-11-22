package com.evelinvidal.HogarYa;

import com.evelinvidal.Vista.PropiedadView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        PropiedadView root = new PropiedadView();
        Scene scene = new Scene(root, 950, 600);
        stage.setTitle("Inmobiliaria HogarYA - Gestión de Arriendos");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}