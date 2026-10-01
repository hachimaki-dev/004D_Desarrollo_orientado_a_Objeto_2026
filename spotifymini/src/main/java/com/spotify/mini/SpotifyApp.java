package com.spotify.mini;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SpotifyApp extends Application{
    
    public void start(Stage escenario) throws Exception{

        Label lblnombreApp = new Label("Spotify Duoc");
        lblnombreApp.setStyle("-fx-tex-fill: #fff");

        Button btnAgregarCancion = new Button("Aceptar"); 
        btnAgregarCancion.setStyle("-fx-backgraund-color: rgb(20, 163, 77);" + "-fx-backgroud-radius: 20px");

        VBox contenerdor_vertical = new VBox(15, lblnombreApp, btnAgregarCancion);

        contenerdor_vertical.setPadding(new  Insets(100, 20, 30, 50));

        Scene scene = new Scene(lblnombreApp, 500, 300);

        escenario.setScene(scene);
        escenario.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
