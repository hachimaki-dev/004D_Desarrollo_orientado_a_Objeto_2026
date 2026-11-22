package com.agcamila01.hogarya;

import com.agcamila01.hogarya.view.PropiedadView;

import javafx.application.Application;
import javafx.stage.Stage;

public class HogarYaApp extends Application {
    
    @Override 
    public void start(Stage stage) {
        PropiedadView vista = new PropiedadView();
        stage.setTitle("HogarYA");
        stage.setScene(vista.escenaCompleta());
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
