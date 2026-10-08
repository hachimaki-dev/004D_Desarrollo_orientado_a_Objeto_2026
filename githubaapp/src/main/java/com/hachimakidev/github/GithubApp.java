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

public class GithubApp extends Application{

    @Override
    public void start(Stage stage) throws Exception {

        Image logo_gh = new Image("https://uxwing.com/wp-content/themes/uxwing/download/brands-and-social-media/github-icon.png");

        ImageView imagen_logo_gh = new ImageView(logo_gh);
        imagen_logo_gh.setFitWidth(60);
        imagen_logo_gh.setFitHeight(60);

        Label lbl_texto_bienvenida = new Label("sign to hola");
        lbl_texto_bienvenida.setStyle("-fx-font-size: 20px;" + "-fx-font-weight: bold;");

        VBox logotipo = new VBox(10, imagen_logo_gh, lbl_texto_bienvenida);

        logotipo.setAlignment(Pos.BASELINE_CENTER);
        logotipo.setPadding(new Insets(30));

        logotipo.setStyle("-fx-background-color: #fff");

        Label lbl_user_name = new Label("user o mail");

        TextField txf_user_name = new TextField();

        PasswordField txf_password = new PasswordField();

        VBox formulario_login = new VBox(5, lbl_user_name, txf_user_name, txf_password);

        VBox contenedor_padre = new VBox(logotipo, formulario_login);

        logotipo.setStyle("-fx-background-color: #fff");

        Scene inicio_de_secion = new Scene(logotipo, 375, 667);

        stage.setScene(inicio_de_secion);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    


}
