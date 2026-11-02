package com.hachimakidev.musicstore;

import com.hachimakidev.musicstore.view.HomeView;

import javafx.application.Application;
import javafx.stage.Stage;

public class MusicStoreApp extends Application {

    @Override
    public void start(Stage stage) {
        HomeView home_view = new HomeView();

        stage.setTitle("MusicStore — Inventario de Instrumentos");
        stage.setScene(home_view.homeScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

