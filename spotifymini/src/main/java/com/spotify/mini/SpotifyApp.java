package com.spotify.mini;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SpotifyApp extends Application {
    
    @Override
    public void start(Stage escenario) throws Exception {
        
        Label lblNombreApp = new Label(" SpotifyDuoc ");
        lblNombreApp.setStyle("-fx-text-fill: #fff;");

        Button btnAgregarCancion = new Button("Aceptar");
        btnAgregarCancion.setStyle("-fx-background-color:rgb(11, 196, 67);" + "-fx-background-radius: 20px;" + "-fx-padding: 5 20;" + "-fx-text-fill: #fff;");

        VBox contenedor_vertical = new VBox(5, lblNombreApp, btnAgregarCancion);

        contenedor_vertical.setStyle("-fx-background-color: #222;");

        contenedor_vertical.setPadding(new Insets(20));
        
        Scene scene = new Scene(contenedor_vertical, 500, 300);
        

        escenario.setScene(scene);
        escenario.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
