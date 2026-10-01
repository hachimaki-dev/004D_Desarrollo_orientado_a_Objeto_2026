package com.spotify.mini;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Spotifymini extends Application{
    @Override
    public void start(Stage escenario) throws Exception {

        Label lblTituloApp = new Label("Spotify pirata ☺");
        lblTituloApp.setStyle("-fx-text-fill: #fff");

        TextField txt = new TextField();
        txt.setStyle("-fx-background-radius: 20px");

        Button botonAgregarCancion = new Button("aceptar");
        botonAgregarCancion.setStyle("-fx-background-color:rgb(102, 38, 161);" + "-fx-background-radius: 20px;"+"-fx-paddinfg: 5 20;");

        VBox contenedorVertical = new VBox(5, lblTituloApp, botonAgregarCancion, txt);

        contenedorVertical.setStyle("-fx-background-color: #222");

        contenedorVertical.setPadding(new Insets(20));
        
        Scene scene = new Scene(contenedorVertical, 500, 300);

        escenario.setScene(scene);
        escenario.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
