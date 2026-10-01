package com.spotify.mini;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SpotifyMiniApp extends Application{

    @Override
    public void start(Stage scenario) throws Exception {
        Label lblNombreApp = new Label("♥ Spotify Duoc ♥");
        lblNombreApp.setStyle("-fx-text-fill: #fff;");

        TextField txtArtista = new TextField();
        txtArtista.setStyle("-fx-background-radius: 20px;");

        Button btnAgregarCancion = new Button("Aceptar");
        btnAgregarCancion.setStyle("-fx-background-color: rgb(20, 202, 35);" + "-fx-background-radius: 20px;" + "-fx-padding: 5 20;" + "-fx-text-fill: #fff;");
        
        VBox contenedor_vertical = new VBox(15,lblNombreApp, txtArtista, btnAgregarCancion);
        
        contenedor_vertical.setStyle("-fx-Background-color: #222;");

        contenedor_vertical.setPadding(new Insets(20));

        Scene scene = new Scene(contenedor_vertical, 500, 300);



        scenario.setScene(scene);
        scenario.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
