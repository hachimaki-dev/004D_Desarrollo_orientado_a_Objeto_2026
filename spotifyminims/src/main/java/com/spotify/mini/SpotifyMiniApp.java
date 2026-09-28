package com.spotify.mini;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import txtTituloCancion.setPromptText;

public class SpotifyMiniApp extends Application {

@Override
public void start(Stage stage) throws Exception {
    Label titulo = new Label("Este es el titulo de mi app");

    Label lblArtista = new Label("Nombre del artista: ");
    TextField txtNombreArtista = new TextField();
    txtNombreArtista.setPromptText("Ingresar artista");

    Label lblCancion = new Label("Titulo de la canción");
    TextField txtTituloCancion = new TextField();
    txtTituloCancion.setPromptText("Ingresar canción");

    Button btnAceptar = new Button();
    btnAceptar.setText("Ingresar Artista");

    GridPane formulario = new GridPane();
    formulario.setVgap(20);
    formulario.add(lblArtista, 0, 0);
    formulario.add(txtNombreArtista, 1, 0);
    formulario.add(btnAceptar, 2, 0);
    VBox root = new VBox(10, titulo, lblArtista, txtNombreArtista, btnAceptar);

    // root.setPadding(new Insets(120, 50, 30, 40));
    root.setPadding(new Insets(20));

    Scene scene = new Scene(root, 600, 400);

    stage.setScene(scene);
    stage.show();
}
    public static void main(String[] args) {
        launch(args);
    }
}

