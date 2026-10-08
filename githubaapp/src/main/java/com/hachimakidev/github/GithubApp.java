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

        ImageView imgview_logo_gh = new ImageView(logo_gh);
        imgview_logo_gh.setFitWidth(60);
        imgview_logo_gh.setFitHeight(60);

        Label lbl_texto_bienvenida = new Label("Sign in to Github");
        lbl_texto_bienvenida.setStyle("-fx-font-size: 20px;" + "-fx-font-weight: bold;");

        VBox logotipo = new VBox(10, imgview_logo_gh, lbl_texto_bienvenida);
        logotipo.setAlignment(Pos.TOP_CENTER);
        logotipo.setPadding(new Insets(30));


        Label lbl_username = new Label("Username or Email address: ");

        TextField txf_username = new TextField();

        Label lbl_password = new Label("Password: ");

        PasswordField txf_password = new PasswordField(); 

        VBox formulario_login = new VBox(5, lbl_username, txf_username, lbl_password, txf_password);

        VBox contenedor_padre = new VBox(logotipo, formulario_login);
        contenedor_padre.setStyle("-fx-background-color: #fff");
        contenedor_padre.setPadding(new Insets(20));

        Scene inicio_de_sesion = new Scene(contenedor_padre, 365, 667);

        stage.setScene(inicio_de_sesion);

        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
