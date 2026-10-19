package com.tab.biblioapp;

import com.tab.biblioapp.view.Homeview;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class App extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        Homeview home_view = new Homeview();
        Scene home_scene = home_view.homeScene();
        stage.setScene(home_scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
