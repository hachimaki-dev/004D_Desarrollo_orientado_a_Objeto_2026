package com.hachimakidev.biblioapp;

import com.hachimakidev.biblioapp.view.HomeView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        HomeView home_view = new HomeView();
        Scene homeScene = home_view.homeScene();
        stage.setScene(homeScene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
