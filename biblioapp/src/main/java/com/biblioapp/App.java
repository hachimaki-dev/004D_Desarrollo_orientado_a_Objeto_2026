package com.biblioapp;

import com.biblioapp.view.HomeView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        HomeView Hview = new HomeView();
        Scene home_Scene = Hview.homeScene();
        stage.setScene(home_Scene);
        stage.show();
        
    }
    public static void main(String[] args) {
        launch(args);
    }
}
