package com.hachimakidev.github;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GithubApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // TODO Auto-generated method stub



        ImageView logo_gh = new ImageView("https://uxwing.com/wp-content/themes/uxwing/download/brands-and-social-media/github-icon.png");
        logo_gh.setFitWidth(50);
        logo_gh.setFitHeight(50);
        Label t_bienvenida = new Label("Sign in to GitHub");
        Label lbl_username = new Label("Username or Email addres");
        TextField user_name = new TextField();
        Label password = new Label("Password:");
        TextField user_password = new TextField();
        VBox formulario_login = new VBox(10, logo_gh, t_bienvenida, lbl_username, user_name, user_password);
        formulario_login.setAlignment(Pos.CENTER);
    

        Scene inicio_sesion = new Scene(formulario_login, 375, 667);
        stage.setScene(inicio_sesion);
        stage.show();
        
    }

    




    public static void main(String[]args){
        launch(args);
    }
}
