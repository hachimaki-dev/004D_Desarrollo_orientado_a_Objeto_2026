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
        
        Image logo_gh = new Image("https://images.seeklogo.com/logo-png/30/2/github-logo-png_seeklogo-304612.png");

        ImageView imgView_logo_gh = new ImageView(logo_gh);
        imgView_logo_gh.setFitWidth(60);
        imgView_logo_gh.setFitHeight(60);

        Label lblInicioSesion = new Label("Sign in to GitHub");

        lblInicioSesion.setStyle("-fx-font-size: 20px;" + "-fx-font-weight: bold;");

        VBox banner = new VBox(imgView_logo_gh, lblInicioSesion);

        banner.setAlignment(Pos.TOP_CENTER);


        Label lbl_user_name = new Label("Username or email addres");
        
        TextField txf_user_name = new TextField();

        Label lbl_password = new Label("Password");

        TextField txf_password = new TextField();

        Button btn_sign_in = new Button("Sign in");
        btn_sign_in.setMaxWidth(Double.MAX_VALUE);
        btn_sign_in.setStyle("-fx-background-color:#0a8940;" + "-fx-text-fill: #fff;" + "-fx-font-weight: bold;");

        btn_sign_in.setOnAction( e -> {
            System.out.println("Wena wena");
        } );

        VBox formulario_login = new VBox(10,lbl_user_name, txf_user_name, lbl_password, txf_password, btn_sign_in);

        VBox interfaz = new VBox(5, banner, formulario_login);

        interfaz.setPadding(new Insets(20));

        interfaz.setStyle("-fx-background-color: #fff;");

        Scene login_scene = new Scene(interfaz, 375, 667);
        
        stage.setScene(login_scene);

        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


}
