package com.spotify.mini;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Spotifyapp  extends  Application {

    @Override
    public void start(Stage escenario) throws Exception {

        Label lbl_nombreapp = new Label("SpotifyDuoc");
        lbl_nombreapp.setStyle("-fx-text-fill: #fff");
        Button  btnagregarcancion = new Button("aceptar");
        btnagregarcancion.setStyle("-fx-background-color:rgb(20 , 163 , 77)" + "-fx-background-radius: 20px;" + "-fx-padding: 5 20;" + );
        TextField txtartista = new TextField();
        
        VBox contenedor_vertical = new VBox(10 , lbl_nombreapp , txtartista , btnagregarcancion);
        contenedor_vertical.setPadding(new Insets(15 ));
        contenedor_vertical.setStyle("-fx-background-color: #222");

        Scene scene = new Scene(contenedor_vertical , 500  , 300);    

        escenario.setScene(scene);
        escenario.show();

    }

    public static void main(String[] args) {
        launch();
    }

}
