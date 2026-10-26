package com.streamhub;

import com.streamhub.view.StreamHubView;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application
{

    @Override
    public void start(Stage stage) throws Exception 
    {
        StreamHubView VISTA = new StreamHubView();

        stage.setScene(VISTA.HomeScene());

        stage.show();

    }
    
    public static void main(String[] args) 
    {
        launch(args);
    }
}
