package com.spotify.mini;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SpotifyMiniApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Label titulo = new Label("Spotify Mini");

        Label lblArtista = new Label("Nombre del artista: "); //Para titulos, subtitulos

        TextField txtNombreArtista = new TextField(); //Para escribir

        Button btnAceptar = new Button(); //Para agregar boton a la aplicacion
        btnAceptar.setText("Ingresar Artista"); //Para ingresar el nombre del artista con el boton

        Label lblCancion = new Label("Nombre de la cancion: ");
        TextField txtNombreDeLaCancion = new TextField();
        Button btnCancion = new Button();
        btnAceptar.setText("Ingresar nombre de la cancion: ");
    
        
        VBox root = new VBox(10, titulo, lblArtista, lblCancion, txtNombreDeLaCancion, txtNombreArtista, btnAceptar, btnCancion); //Hbox para linea horizontal y Vbox para linea vertical, Sirve para imprimir por asi decirlo y te aparezca todo lo que hiciste antes en la aplicacion
        
        
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 400, 320);

        stage.setScene(scene);
        stage.show();

        
        
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
