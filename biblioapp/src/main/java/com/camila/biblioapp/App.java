package com.camila.biblioapp;

import com.camila.biblioapp.view.HomeView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        HomeView home_view = new HomeView();
        Scene home_scene = home_view.homScene();
        stage.setScene(home_scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
