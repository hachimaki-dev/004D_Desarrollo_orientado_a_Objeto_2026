package com.hachimakidev.bibliotech;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BiblioTechApp extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("BiblioTech");
        stage.setScene(new Scene(new VBox(), 600, 300));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
