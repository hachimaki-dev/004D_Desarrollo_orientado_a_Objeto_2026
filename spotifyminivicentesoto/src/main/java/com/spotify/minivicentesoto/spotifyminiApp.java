package com.spotify.minivicentesoto;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class spotifyminiApp extends Application {

    @Override
    public void start(Stage stage) {
        Label titulo = new Label("Spotify mini");

        Label lblArtista = new Label("Nombre del artista: ");
        TextField txtNombreartista = new TextField();

        Button btnAceptar = new Button("Agregar cancion");
        btnAceptar.setId("btn-agregar");


        VBox root = new VBox(10,titulo,lblArtista,txtNombreartista,btnAceptar);

        //GridPane Formulario = new GridPane();
        //Formulario.setHgap(20);
        //Formulario.setVgap(20);

        //Formulario.add(lblArtista, 0,0);
        //Formulario.add(txtNombreartista, 0,0);
        //Formulario.add(btnAceptar, 0,0); 


        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 400, 320);

        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
