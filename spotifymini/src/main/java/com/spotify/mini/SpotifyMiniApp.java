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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SpotifyMiniApp extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Label titulo = new Label("Este es el titulo de mi app");
        Label lblArtista = new Label("Nombre del Artista: ");
        TextField txtNombreArtista = new TextField();
        txtNombreArtista.setPromptText("Ingrese el nombre del artista");

        Button btnAceptar = new Button();
        btnAceptar.setText("Ingresar Artista");

        Label lblalbum = new Label("Nombre Album: ");
        TextField txtnombreAlbum = new TextField();
        txtnombreAlbum.setPromptText("Ingrese el nombre del album");

        Button btnAceptarr = new Button();
        btnAceptarr.setText("Ingresar Album");

        Label lblFecha = new Label("Fecha Album: ");
        TextField txtFecha = new TextField();
        txtFecha.setPromptText("Ingrese la fecha del album");

        Button btnAceptarrr = new Button();
        btnAceptarrr.setText("Ingresar Fecha");

        Label lblGenero = new Label("Genero Album: ");
        TextField txtGenero = new TextField();
        txtGenero.setPromptText("Ingrese el Genero del album");

        Button btnAceptarrrr = new Button();
        btnAceptarrrr.setText("Ingresar Genero");

        GridPane formulario = new GridPane();
        formulario.setHgap(10);
        formulario.setVgap(10);
        formulario.add(lblArtista, 0, 0);
        formulario.add(txtNombreArtista, 0, 0);
        formulario.add(btnAceptar, 0, 0);

        VBox root = new VBox(10, formulario, titulo, lblArtista, txtNombreArtista, btnAceptar, lblalbum, txtnombreAlbum, btnAceptarr, lblFecha, txtFecha, btnAceptarrr, lblGenero, txtGenero, btnAceptarrrr);

        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 400 , 320);
        
        stage.setScene(scene);
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
