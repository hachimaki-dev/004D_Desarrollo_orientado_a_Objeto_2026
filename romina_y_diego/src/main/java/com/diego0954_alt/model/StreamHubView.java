
package com.diego0954_alt.view;

import javafx.application.Application; // 
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StreamHubView extends Application { 
    @Override
    public void start(Stage primaryStage) {
        Label titulo = new Label("bienvenido a streamhub");
        VBox layout = new VBox(10);
       
        layout.getChildren().add(titulo);
        
        Scene scene = new Scene(layout, 400, 300);
        
        primaryStage.setTitle("StreamHub");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}