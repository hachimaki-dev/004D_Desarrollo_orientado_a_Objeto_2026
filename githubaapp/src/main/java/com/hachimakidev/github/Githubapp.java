package com.hachimakidev.github;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Githubapp extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        Image logo_GH = new Image("https://uxwing.com/wp-content/themes/uxwing/download/brands-and-social-media/github-icon.png");

        ImageView imgview_logo_GH = new ImageView(logo_GH);
        i

        VBox formulario_login = new VBox(imgview_logo_GH);
        Scene inicio_de_sesion = new Scene(formulario_login,375,667);

        stage.setScene(inicio_de_sesion);

        stage.show();


    }
    public static void main(String[] args) {
        launch(args);
    }

}
