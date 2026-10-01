package com.spotify.mini;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SpotifyApp extends Application {

    public void start(Stage escenario) throws Exception {

        Label lblNombreApp = new Label("SpotifyDuoc");
        lblNombreApp.srtStyle("-fx-text-fill")

        Button btnAgregarCancion = new Button("Aceptar");

        VBox contenedor_vertical = new VBox(15, lblNombreApp, btnAgregarCancion);

        contenedor_vertical.setPadding(new Insets(20));

        Scene scene = new Scene(contenedor_vertical, 500, 300);

        escenario.setScene(scene);
        escenario.show();

    }

    public static void main(String[] args) {
        launch(args);
    }


    
}
