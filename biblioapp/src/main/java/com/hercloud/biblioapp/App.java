package com.hercloud.biblioapp;

import com.hercloud.biblioapp.view.HomeView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application
{
    @Override
    public void start(Stage stage) throws Exception 
    {   
        HomeView home_view = new HomeView();
        Scene home_scene = new Scene(null);
        stage.setScene(null);
        stage.show();
    }   
    
    public static void main(String[] args) 
    {
        
    }
}
