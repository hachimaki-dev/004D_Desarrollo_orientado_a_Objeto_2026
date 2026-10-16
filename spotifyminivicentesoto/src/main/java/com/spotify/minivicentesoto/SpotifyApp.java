package com.spotify.minivicentesoto;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SpotifyApp extends Application {

    @Override
    public void start(Stage escenario) throws Exception {
        Label lblnombreApp = new Label("Spotify Duoc");
        lblnombreApp.setStyle("-fx-text-fill: #fff;-fx-font-size: 28px;");
        lblnombreApp.setMaxWidth(Double.MAX_VALUE);
        lblnombreApp.setAlignment(Pos.CENTER);

        Label lblnombrebuscardor = new Label("Buscador");
        lblnombrebuscardor.setStyle("-fx-text-fill: #ffffff;" + "-fx-font-size: 15px");

        TextField txtArtista = new TextField();
        txtArtista.setPromptText("¿Que deseas escuchar?");
        txtArtista.setStyle("-fx-background-radius: 20px;" + "-fx-text-fill: #000000");
       

        Button btnAgregarCancion = new Button("Aceptar");
        btnAgregarCancion.setStyle("-fx-background-color:rgb(20, 163, 77);" + "-fx-background-radius: 20px;" + "-fx-padding: 5 20;" + "-fx-text-fill: #fff;");

        VBox contenedorVertical = new VBox(15, lblnombreApp,lblnombrebuscardor,txtArtista, btnAgregarCancion);

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