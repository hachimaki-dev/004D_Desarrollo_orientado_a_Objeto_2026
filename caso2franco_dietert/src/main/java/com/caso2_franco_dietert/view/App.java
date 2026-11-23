package com.caso2_franco_dietert.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
    
    VBox layout = new VBox(15);
    layout.setPadding(new Insets(20));

    Scene scene = new Scene(layout, 1000, 650);

    stage.setTitle("Gestión de Propiedades");
    stage.setScene(scene);
    stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
