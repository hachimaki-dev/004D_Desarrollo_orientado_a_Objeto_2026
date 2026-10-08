package com.spotify.mini;


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
    imgview_logo_gh.setFitWidth(50);
    imgview_logo_gh.setFitHeight(50);

    Label titulo_login = new Label("Sign in to Githud ");
    titulo_login.setStyle("-fx-font-size: 15px;" + "fx-font-weight: bold;");

    VBox logotipo = new VBox(15 , imgview_logo_gh , titulo_login );
    logotipo.setAlignment(Pos.TOP_CENTER);
    logotipo.setPadding(new Insets(30));
    
    logotipo.setStyle("fx--background-color: #fff");



    Label lbl_user_name = new Label("Usermane or email address");

    TextField txf_user_bame = new TextField();

    Label lbl_password = new Label("Password");

    PasswordField txf_password = new PasswordField();

    VBox formulario_login = new VBox(5 , lbl_user_name , txf_user_bame , lbl_password , txf_password);

    VBox contenerdor_padre = new VBox(logotipo , formulario_login);
    contenerdor_padre.setStyle("fx--background-color: #fff");
    

    Scene inicio_de_sesion = new Scene(contenerdor_padre, 375, 667);

    stage.setScene(inicio_de_sesion);
    stage.show();

    

  }



  public static void main(String[] args) {

    launch(args);

  }

  

}










