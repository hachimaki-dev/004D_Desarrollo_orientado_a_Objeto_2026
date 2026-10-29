package com.video.juegos;

import com.video.juegos.view.GameVaultView;
import com.video.juegos.view.HomeView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameVault extends Application {
    @Override
    public void start(Stage stage) {
        HomeView homeView = new HomeView();
        GameVaultView gameVaultView = new GameVaultView();

        BorderPane contenedor = new BorderPane();
        contenedor.setTop(homeView.contenedorBusquedaUsuario());
        contenedor.setCenter(gameVaultView.contenedorGameVault());
        stage.setScene(new Scene(contenedor, 1000, 650));

        /* 
        // Versión sin BorderPane, solo contenedor dentro de otro
        VBox contenedorUsuario = homeView.contenedorBusquedaUsuario();
        VBox contenedorInventario = gameVaultView.contenedorGameVault();
        VBox contenedorPrincipal = new VBox(15, contenedorUsuario, contenedorInventario);
        Scene escena = new Scene(contenedorPrincipal, 1000, 650);
        stage.setScene(escena);
        */

        stage.setTitle("GameVault");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
