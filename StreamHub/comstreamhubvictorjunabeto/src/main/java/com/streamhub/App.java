package com.streamhub;

import com.streamhub.view.StreamHubView;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    private Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;

        StreamHubView home_view = new StreamHubView();
        stage.setTitle("BiblioTech");
        stage.setScene(home_view.streamHubScene());
        stage.show();


    }


    




    public static void main(String[] args) {
        launch(args);
    }}