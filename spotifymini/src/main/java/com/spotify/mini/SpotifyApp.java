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
        
        Label lblNombreApp = new Label("♪ SpotifyDuoc ♪♫");
        lblNombreApp.setStyle("-fx-text-fill: #fff");

        TextField txtArtista = new TextField();
        txtArtista.setStyle("-fx-background-radius: 20px");

        Button btnAgregarCancion = new Button("Aceptar");
        btnAgregarCancion.setStyle("-fx-background-color:rgb(20, 202, 35);" + "-fx-background-radius: 20px;" + "-fx-padding: 5 20;" + "-fx-text-fill: #ffffff;");
        
        //HBox contenedorHorizontal = new HBox(5,lblNombreApp, btnAgregarCancion);
        VBox contenedorVertical =  new VBox(15,lblNombreApp, txtArtista, btnAgregarCancion);
        contenedorVertical.setStyle("-fx-background-color: #222;");
        contenedorVertical.setPadding(new Insets(20));//se puede poner en todas las direcciones

        Scene scene = new Scene(contenedorVertical, 500, 300);
        escenario.setScene(scene);
        escenario.setTitle("♪♫ SpotifyDuoc ♪♫");//titulo ventana
        escenario.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
