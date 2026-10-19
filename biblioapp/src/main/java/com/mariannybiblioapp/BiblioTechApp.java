package com.mariannybiblioapp;

import com.mariannybiblioapp.view.HomeView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BiblioTechApp extends Application {
@Override
public void start(Stage stage) throws Exception {
    HomeView home_view = new HomeView();
    Scene home_scene = home_view.homeScene();
    stage.setScene(home_scene);
    stage.show();

}

    public static void main(String[] args) {
        launch(args);
    }
}
