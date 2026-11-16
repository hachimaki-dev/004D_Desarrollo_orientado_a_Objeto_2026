package com.evelinvidal.javadb;

import java.sql.DriverManager;

import javafx.application.Application;

import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;



public class App extends Application{
  
  @Override
  public void start(Stage primaryStage) throws Exception {
    TextField txt_nombre = new TextField();
    txt_nombre.setPromptText("Escribe un nombre");
    Button btn_registrar = new Button("Hazme click para registrar c:!");
    //ACA VAMOS A CREAR TODA LA LOGICA DE NUESTRA APP
    //PRIMER PASO, crear la conexion, sino como inserto datos?
    //necesito 3 cosas, 1 donde me conecto, 2 con qn me conecto, 3 la password
    String origen_conexion = "jdbc:oracle:thin:@//localhost:1521/FREEPDB1"; //paso 1
    String usuario_db = "usuario_desarrollador"; //paso 2
    String password_usuario_db = "123456"; //paso 3

    btn_registrar.setOnAction(e -> {
      String nombre_escrito = txt_nombre.getText();
      try {
        DriverManager.getConnection(origen_conexion, usuario_db, password_usuario_db).isValid(2);
        String insertar_datos_sql = "INSERT INTO TEST(nombre) VALUES('" + txt_nombre.getText() + "')";
        try {
          DriverManager.getConnection(origen_conexion, usuario_db, password_usuario_db).prepareStatement(insertar_datos_sql).executeUpdate();
          System.out.println("Insertado el usuario " + txt_nombre.getText());
        } catch (Exception ex) {
          System.out.println("La consulta no se inserto");
        }
    } catch (Exception ex) {
      System.out.println("CONEXION INVALIDA");
    }
    });

    //ACA TERMINA TDA LA LOGICA DE NUESTRA APP
    VBox contenedor_botones = new VBox(10, txt_nombre,btn_registrar);
    Scene escena_principal = new Scene(contenedor_botones, 720, 400);

    primaryStage.setScene(escena_principal);
    primaryStage.show();
  }
  public static void main(String[] args) {
    launch(args);
  }
}