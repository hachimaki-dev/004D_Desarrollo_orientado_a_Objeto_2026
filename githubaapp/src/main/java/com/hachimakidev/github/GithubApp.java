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

        Image logo_gh = new Image("https://uxwing.com/wp-content/themes/uxwing/download/brands-and-social-media/github-icon.png"); //Espera una URL pero no se muestra

        ImageView imgview_logo_gh = new ImageView(logo_gh); //el imageview hace que se vea la imagen
        imgview_logo_gh.setFitWidth(60); //El setFitWidth es el ANCHO
        imgview_logo_gh.setFitHeight(60); //Para dimensionar la imagen el setFitHeight es el ALTO

        Label lbl_text_bienvenida = new Label("Sign in to Github"); //El texto que mostrara la pantalla al inicio
        lbl_text_bienvenida.setStyle("-fx-font-size: 20px;" + "-fx-font-weight: bold;"); //Para poner las letras mas grandes y en negrita

        VBox logotipo = new VBox(10, imgview_logo_gh, lbl_text_bienvenida); //El Vbox Espera un nodo

        logotipo.setAlignment(Pos.TOP_CENTER); //Esto sirve para centrar todo lo que sale en el Vbox, en este caso el logo y el texto de la bienvenida
        logotipo.setPadding(new Insets(30));

        logotipo.setStyle("-fx-background-color: #ffffff"); //Para cambiar el color del fondo


        Label lbl_user_name = new Label("Username or email address"); //Que se muestre ese texto

        TextField txt_user_name = new TextField(); //Que se pueda escribir en el texto que habiamos puesto arriba

        Label lbl_password = new Label("Password"); //Mostrar el texto de ingresar contraseña

        PasswordField txt_password = new PasswordField(); //Para que la contraseña se vea en puntitos

        VBox formulario_login = new VBox(5, lbl_user_name, txt_user_name, lbl_password, txt_password);

        VBox contenedor_padre = new VBox(logotipo, formulario_login); //Se crea un contenedor padre ya que una scene solo agunta un nodo

        contenedor_padre.setStyle("-fx-background-color: #ffffff"); //Para cambiar el color del fondo
        contenedor_padre.setPadding(new Insets(30));

        
        Scene inicio_de_sesion = new Scene(contenedor_padre, 375, 667); // A la escena se le pasa el Vbox

        stage.setScene(inicio_de_sesion); // Esto hace que se muestre la escena

        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
