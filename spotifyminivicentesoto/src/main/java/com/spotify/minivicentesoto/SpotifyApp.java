package com.spotify.minivicentesoto;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SpotifyApp extends Application {

    @Override
    public void start(Stage escenario) throws Exception {
        Label lblnombreApp = new Label("Spotify duoc");
        lblnombreApp.setStyle("-fx-text-fill: #fff");

        TextField txtArtista = new TextField();
        txtArtista.setStyle("-fx-background-radius: 20px;");

        Button btnAgregarCancion = new Button("Aceptar");
        btnAgregarCancion.setStyle("-fx-background-color:rgb(20, 163, 77);" + "-fx-background-radius: 20px;" + "-fx-padding: 5 20;" + "-fx-text-fill: #fff;");

        VBox contenedorVertical = new VBox(15, lblnombreApp, txtArtista, btnAgregarCancion);

        contenedorVertical.setStyle("-fx-background-color: #222;");    

        contenedorVertical.setPadding(new Insets(20));

        Scene scene = new Scene(contenedorVertical, 500, 300);
        
        escenario.setScene(scene);
        escenario.show();

        
    }

    public static void main(String[] args) {
        launch(args);
    }


        
    


    
    
    

} 