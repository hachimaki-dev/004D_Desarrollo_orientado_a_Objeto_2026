package com.blasphemycmd.bibliotech;

import com.blasphemycmd.bibliotech.view.HomeView;

import javafx.application.Application;

import javafx.stage.Stage;

public class BiblioTechApp extends Application {
    @Override
    public void start(Stage stage) {

        HomeView home_view = new HomeView();

        stage.setTitle("BiblioTech");
        stage.setScene(home_view.homeScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
