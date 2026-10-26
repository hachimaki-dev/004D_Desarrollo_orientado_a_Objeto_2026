package com.video.juegos;

import com.video.juegos.view.GameVaultView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameHub extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        GameVaultView game_vault_view = new GameVaultView();
        Scene game_vault_scene = game_vault_view.gameVaultScene();
        stage.setScene(game_vault_scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
