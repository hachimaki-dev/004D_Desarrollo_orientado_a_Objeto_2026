package com.spotify.mini;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SpotifyMiniApp extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        Label titulo = new Label("Este es el título de mi app");
        Label lblArtista = new Label("Nombre del artista:");
        Label lblCancion = new Label("Nombre de la canción:");
        Label lblGenero = new Label("Género de la canción");
        Label lblAlbum = new Label("Nombre del album:");
        Label lblFechaLanzamiento = new Label("Fecha de lanzamiento:");
        TextField txtNombreArtista = new TextField();
        txtNombreArtista.setPromptText("Ingrese el nombre del artista");
        TextField txtNombreCancion = new TextField();
        txtNombreCancion.setPromptText("Ingrese el nombre de la canción");
        TextField txtGeneroCancion = new TextField();
        txtGeneroCancion.setPromptText("Ingrese el género de la canción");
        TextField txtNombreAlbum = new TextField();
        txtNombreAlbum.setPromptText("Ingrese el álbum de la canción");
        TextField txtFechaLanzamiento = new TextField();
        txtFechaLanzamiento.setPromptText("dd-mm-yyyy");
        Button btnArtista = new Button();
        btnArtista.setText("Ingresar artista");
        Button btnCancion = new Button();
        btnCancion.setText("Ingresar canción");
        Button btnGenero = new Button();
        btnGenero.setText("Ingresar género");
        Button btnAlbum = new Button();
        btnAlbum.setText("Ingresar álbum");
        Button btnFecha = new Button();
        btnFecha.setText("Ingresar fecha");
        VBox root = new VBox(5, titulo, lblArtista, txtNombreArtista, btnArtista, lblCancion, txtNombreCancion, btnCancion, lblGenero, txtGeneroCancion, btnGenero, lblAlbum, txtNombreAlbum, btnAlbum, lblFechaLanzamiento, txtFechaLanzamiento, btnFecha);
        root.setPadding(new Insets(20));
        Scene scene = new Scene(root, 1080, 720);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
