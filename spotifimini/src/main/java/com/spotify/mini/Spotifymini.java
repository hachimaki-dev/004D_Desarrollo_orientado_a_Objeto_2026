package com.spotify.mini;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Spotifymini extends Application {

    @Override
    public void start(Stage stage) throws Exception {


        Label titulo = new Label("S P O T I F Y   M I N I");

        // A R T I S T A 
        Label lblArtista = new Label("Nombre del artista: "); 

        TextField txt_Nombre_artista = new TextField();
        txt_Nombre_artista.setPromptText("ingresar Nombre del artista ");

        Button btnAceptar  = new Button();
        btnAceptar.setText("Ingresar artista ");

        // C a n c i o n  
        Label lblcancion = new Label("Nombre de la Cancion : "); 

        TextField txt_nombre_cancion = new TextField();
        txt_nombre_cancion.setPromptText("Ingresar nombre de la cancion ");

        Button btnAceptar_cancion  = new Button();
        btnAceptar_cancion.setText("Ingresar cancion ");

        // G e n e r o 

        Label lblGenero = new Label("Genero de la cancion : "); 

        TextField txt_Nombre_genero = new TextField();
        txt_Nombre_genero.setPromptText("ingresar el genero de la cancion ");

        Button btnAceptar_genero = new Button();
        btnAceptar_genero.setText("Ingresar genero ");



        

        VBox root = new VBox(10 , titulo , lblArtista , txt_Nombre_artista , btnAceptar , lblcancion ,  txt_nombre_cancion , btnAceptar_cancion , lblGenero , txt_Nombre_genero , btnAceptar_genero );
        

        root.setPadding(new Insets(20));
        Scene scene = new Scene(root , 1080, 720);

        stage.setScene(scene);
        stage.show();

        
    }
    
    public static void main(String[] args) {
            launch(args);
        }

}
