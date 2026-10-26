package com.hachimakidev.biblioapp;

import com.hachimakidev.biblioapp.view.homeView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application
{
    
    @Override
    public void start(Stage stage) throws Exception 
    {   
        homeView homeview = new homeView();

        VBox VBhomeview = homeview.homeScenePrincipal();

        Scene scene = new Scene(VBhomeview, 760, 480);

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) 
    {
        launch(args);
    }

}
