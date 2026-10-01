package com.spotify.mini;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SpotifyMiniApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {

        Label titulo = new Label("Este es el titulo de mi app");

        Label lblArtista = new Label("Nombre del artista: ");

        TextField txtNombreArtista = new TextField();
        txtNombreArtista.setPromptText("Ingrese el nombre del artista");

        Button btnAceptar = new Button();
        btnAceptar.setText("Ingresar Artista");


        //GridPane formulario = new GridPane();
        //formulario.setHgap(20);
        //formulario.setVgap(20);
//
        //formulario.add(lblArtista, 0, 0);
        //formulario.add(txtNombreArtista, 1, 0);
        //formulario.add(btnAceptar, 2, 0);

        VBox root = new VBox(10, titulo, lblArtista, txtNombreArtista, btnAceptar);


        //root.setPadding(new Insets(120, 60, 20,5));
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 400,320);  
        stage.setScene(scene);
        stage.show();

    }

     public static void main(String[] args) {
        launch(args);
    }

}
