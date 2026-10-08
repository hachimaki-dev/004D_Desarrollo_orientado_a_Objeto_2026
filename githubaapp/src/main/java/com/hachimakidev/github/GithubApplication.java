package com.hachimakidev.github;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GithubApplication extends  Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        
    Image logo_gh = new Image("https://uxwing.com/wp-content/themes/uxwing/download/brands-and-social-media/github-icon.png");
    ImageView imgview_logo_gh = new ImageView(logo_gh);
    imgview_logo_gh.setFitWidth(60);
    imgview_logo_gh.setFitHeight(60);

    Label lbl_text_bienvenida = new label("Sign in to Github");
    lbl_text_bienvenida.setStyle("-fx-font-size:20px;" +"-fx-font-weight: bold;");

    VBox logotipo = new VBox(10 ,imgview_logo_gh, lbl_text_bienvenida);

    logotipo.setAlignment(Pos.TOP_CENTER);
    logotipo.setPadding(new Insets(30));

    logotipo.setStyle("-fx-background-color: #ffffff");

    label lbl_user_name = new label("Username or Email addres");
    Textfield txf_user_name = new TextField();

    label lbl_password = new lbl_passwordField();
    PasswordField txf_password = new PasswordField();

    Vbox formulario_login = new Vbox(5, lbl_user_name, lbl_password, txf_password);

    vbox contenerdor_padre = new Vbox (logotipo,formulario_login);

    contenerdor_padre.setStyle("-fx-background-color: #ffffff");
    


    Scene inicio_de_sesion = new Scene(logotipo, 375, 667);

    stage.setScene(inicio_de_sesion);

    stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


}
