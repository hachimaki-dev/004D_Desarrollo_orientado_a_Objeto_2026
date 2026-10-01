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
    public void start (Stage escenario) throws Exception {
        Label lblNombreApp = new Label("Spotify Duoc");
        lblNombreApp.setStyle("-fx-text-fill: #fff");
        Button btnAgregarCancion = new Button("Aceptar");
        btnAgregarCancion.setStyle("-fx-background-color:rgb(0, 126, 27);" + "-fx-background-radius: 20px;" + "-fx-padding: 5 20;" + "-fx-text-fill: #fff;");
        VBox contVer = new VBox(15, lblNombreApp, btnAgregarCancion);
        contVer.setStyle("-fx-background-color: #222;");
        contVer.setPadding(new Insets(100, 20, 30, 50));
        Scene scene = new Scene(contVer, 500, 300);
        escenario.setScene(scene);
        escenario.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
