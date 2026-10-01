package com.spotify.mini;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SpotifyApp extends Application{
    
    @Override
    public void start(Stage escenario) throws Exception {

        Label lblNombreapp = new Label("SpotifyDuoc");
        lblNombreapp.setStyle("-fx-text-fill: #fff;");


        Button btnAgregarCancion = new Button("Aceptar");
        btnAgregarCancion.setStyle("-fx-background-color rgb(33, 92, 41);" + "-fx-background-radius: 20px;"+ "-fx-padding: 5 20;");
        
        VBox contenedorVertical = new VBox(5,lblNombreapp,btnAgregarCancion);

        contenedorVertical.setStyle("-fx-background-color: #222;");
        contenedorVertical.setPadding(new Insets(100,20,30,50));

        Scene scene = new Scene(contenedorVertical,500,300);




        escenario.setScene(scene);
        escenario.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
