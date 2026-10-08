package com.hachimakidev.github;



import javafx.application.Application;

import javafx.scene.Scene;

import javafx.scene.image.Image;

import javafx.scene.image.ImageView;

import javafx.scene.layout.VBox;

import javafx.stage.Stage;



public class GithubApp extends Application {

  @Override
  public void start(Stage stage) throws Exception {

    Image logo_gh = new Image("https://uxwing.com/wp-content/themes/uxwing/download/brands-and-social-media/github-icon.png");

    ImageView imgview_logo_gh = new ImageView(logo_gh);

    VBox formulario_login = new VBox(imgview_logo_gh);

    Scene inicio_de_sesion = new Scene(formulario_login, 375, 667);

    stage.setScene(inicio_de_sesion);

    stage.show();
  }
  public static void main(String[] args) {
    launch(args);
  }
}

