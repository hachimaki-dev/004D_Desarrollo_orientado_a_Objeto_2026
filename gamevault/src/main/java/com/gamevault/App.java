package com.gamevault;

import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    @Override 
    public void start(Stage stage){
        stage.setTitle("GameVault");
        stage.setScene(new Scene(new VBox(),600,300));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
