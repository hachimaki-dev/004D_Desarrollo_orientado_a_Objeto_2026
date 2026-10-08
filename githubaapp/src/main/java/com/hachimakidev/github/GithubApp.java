package com.hachimakidev.github;

import javafx.scene.image.ImageView;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GithubApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        
        Image logo_gb = new Image("https://uxwing.com/wp-content/themes/uxwing/download/brands-and-social-media/github-icon.png");

        ImageView ignview_logo_gh = new ImageView(logo_gb);
        ignview_logo_gh.setFitHeight(60);
        ignview_logo_gh.setFitWidth(60);

        Label lbl_text_bienvenida = new Label("Sign in to Github");
        lbl_text_bienvenida.setStyle("-fx-font-size: 20px;" +"-fx-font-weight: bold;");

        Label lbl_user_name = new Label("Username or email adredds");

        Label lbl_password = new Label("Password");

        PasswordField txf_password = new PasswordField();

        VBox formulario_login = new VBox(5,lbl_user_name,txf)


        VBox logotipo = new VBox(10,ignview_logo_gh,lbl_text_bienvenida);

        logotipo.setAlignment(Pos.TOP_CENTER);
        logotipo.setPadding(new Insets(30));

        logotipo.setStyle("-fx-background-color: #fff");

        Scene inicio_de_sesion = new Scene(logotipo, 375,667);
        
        stage.setScene(inicio_de_sesion);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    
}
