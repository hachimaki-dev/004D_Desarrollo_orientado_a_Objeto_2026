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

public class SpotifyApp extends Application{
    
    @Override
    public void start(Stage escenario) throws Exception {

        
        Label lblNombreApp = new Label("Spotify ☺");
        lblNombreApp.setStyle("-fx-text-fill: #fff");

        TextField txtArtista = new TextField();
        TextField.setStyle("-fx-text-fill: #fff");

        Button btnAgregarCancion = new Button("aceptar");
        btnAgregarCancion.setStyle("-fx-background-color:rgb(14, 207, 14);" + "-fx-backgrond-radius: 20px;" + "-fx-padding: 5 20;" + "-fx-text-fill: #fff;");


        VBox contenedor_Vertical = new VBox(15, lblNombreApp, txtArtista,btnAgregarCancion);

        contenedor_Vertical.setPadding(new Insets(20));
        contenedor_Vertical.setStyle("-fx-background-color: #222;");

        Scene scene = new Scene(contenedor_Vertical, 500, 300);

        escenario.setScene(scene);
        escenario.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
