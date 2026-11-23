package com.tab.kiosco;

import com.tab.kiosco.view.ProductoView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        ProductoView productoView = new ProductoView();
        Scene producto_scene = productoView.productoScene();
        stage.setScene(producto_scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
