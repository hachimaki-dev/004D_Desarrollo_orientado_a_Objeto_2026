package com.hachimakidev.github;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GithubApp extends Application
{

    @Override
    public void start(Stage stage) throws Exception 
    {

        stage.setScene(InicioSesión());
        stage.show();
    }
    
    public Scene InicioSesión()
    {

        Image imageLogoGithub = new Image("https://uxwing.com/wp-content/themes/uxwing/download/brands-and-social-media/github-icon.png");
        
        ImageView iviewLogoGithub = new ImageView(imageLogoGithub);

        Label lblbSignup = new Label("Sign in to Github");
        lblbSignup.setStyle("-fx-font-size: 30px; -fx-text-fill:rgb(0, 0, 0); -fx-background-color:rgb(255, 255, 255)");

        VBox vboxEncabezado = new VBox(5, iviewLogoGithub, lblbSignup);

        Label lblUserOrEmail = new Label("Username or email adress");
        lblUserOrEmail.setStyle("-fx-font-size: 15px; -fx-text-fill:rgb(0, 0, 0); -fx-background-color:rgb(255, 255, 255)");

        Label lblPassword= new Label("Password");
        lblPassword.setStyle("-fx-font-size: 15px; -fx-text-fill:rgb(0, 0, 0); -fx-background-color:rgb(255, 255, 255)");

        Label lblOr= new Label("─────────────────────────────or─────────────────────────────");
        lblOr.setStyle("-fx-font-size: 15px; -fx-text-fill:rgb(0, 0, 0); -fx-background-color:rgb(255, 255, 255)");

        Label lblNewToGithub = new Label("New to Github?");
        lblNewToGithub.setStyle("-fx-font-size: 15px; -fx-text-fill:rgb(0, 0, 0); -fx-background-color:rgb(255, 255, 255)");

        Scene inicioSesionSC = new Scene(vboxEncabezado);

        return inicioSesionSC;
    }

    public static void main(String[] args) 
    {
        launch(args);    
    }

}
