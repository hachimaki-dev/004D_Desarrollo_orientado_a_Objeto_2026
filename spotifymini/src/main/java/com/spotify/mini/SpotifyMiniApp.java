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

public class SpotifyMiniApp extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        Label titulo = new Label("Este es el titulo de mi app");
        Label lblArtista = new Label("Nombre del artista: ");//convencion para label
        Label lblCancion = new Label(("Título: "));
        Label lblAlbum = new Label("Album: ");
        Label lblGeneroAlbum = new Label("Genero del Álbum: ");
        Label lblFechaAlbum = new Label("Fecha del Album: ");

        TextField txtNombreArtista = new TextField();
        txtNombreArtista.setPromptText("Ingrese nombre del artista");
        TextField txtNombreCancion = new TextField();
        txtNombreCancion.setPromptText("Ingrese título de la canción: ");

        Button btnAceptar = new Button();
        btnAceptar.setText("Ingresar Artista");
        Button btnAceptarTitulo = new Button();
        btnAceptarTitulo.setText("Ingresar título");


        VBox root = new VBox(10, titulo, lblArtista, txtNombreArtista, btnAceptar, lblCancion, txtNombreCancion, btnAceptarTitulo);
        //HBox root = new HBox(titulo, lblArtista);

        //root.setPadding(new Insets(120,60,20,5));
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 1080,720);

        stage.setTitle("Spotify Mini");//titulo de la ventana
        stage.setScene(scene);
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }

    //tarea cancion
}
