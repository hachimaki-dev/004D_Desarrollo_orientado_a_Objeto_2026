package com.diego0954_alt.view;

import java.lang.classfile.Label;

import com.diego0954_alt.model.Contenido;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StreamHubView extends Contenido {

        @Override
    public void start(Stage primaryStage) {
        Label titulo = new Label("bienvemido a streamhub");
        VBox layout = new  VBox(10);
        layout.getChildren().addListener();


    layout.getChildren().add(titulo);
    
 
    Scene scene = new Scene(layout, 400, 300);
    
  
    primaryStage.setTitle("StreamHub");
    primaryStage.setScene(scene);
    primaryStage.show();
}





    }

    
}