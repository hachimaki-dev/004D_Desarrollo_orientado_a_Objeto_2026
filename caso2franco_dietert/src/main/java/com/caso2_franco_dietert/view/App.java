package com.caso2_franco_dietert.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
    
    PropiedadView vista = new PropiedadView();

    Scene scene = new Scene(vista.getVista(), 1200, 750);

    stage.setTitle("Gestión de Propiedades");
    stage.setScene(scene);
    stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
