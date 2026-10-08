package com.hachimakidev.github;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GithubApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {

        Image logo_gh = new Image("https://uxwing.com/wp-content/themes/uxwing/download/brands-and-social-media/github-icon.png");

        ImageView imgView_logo_gh = new ImageView(logo_gh);
        imgView_logo_gh.setFitWidth(60);
        imgView_logo_gh.setFitHeight(60);

        Label lbl_txt_bienvenida = new Label("Sign in to GitHub");
        lbl_txt_bienvenida.setStyle("-fx-font-size: 20px;" + "-fx-font-weight: bold;");

        VBox logotipo = new VBox(10, imgView_logo_gh, lbl_txt_bienvenida);

        logotipo.setAlignment(Pos.TOP_CENTER);
        logotipo.setPadding(new Insets(20));

        logotipo.setStyle("-fx-background-color: #ffffff");


        Label lbl_user_name = new Label("Username or email address");

        TextField txt_user_name = new TextField();

        Label lbl_password = new Label();

        PasswordField txt_password = new PasswordField();

        VBox formulario_login = new VBox(5, lbl_user_name, txt_user_name, lbl_password, txt_password);
        VBox contenedor_padre = new VBox(logotipo, formulario_login);
        
        contenedor_padre.setStyle("-fx-background-color: #ffffff");


        Scene inicio_de_sesion = new Scene(contenedor_padre, 375, 667);
        
        stage.setScene(inicio_de_sesion);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
