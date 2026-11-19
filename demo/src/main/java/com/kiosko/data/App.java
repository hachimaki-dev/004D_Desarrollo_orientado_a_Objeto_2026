package com.kiosko.data;

import com.kiosko.data.View.viewPrincipal;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application
{

    private final viewPrincipal vp = new viewPrincipal();

    @Override
    public void start(Stage stage) throws Exception 
    {   

        Scene scene = new Scene(vp.vista());

        stage.setScene(scene);

        stage.show();

    }

    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
