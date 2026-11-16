package com.nanyasg.javadb;



import java.sql.DriverManager;

import java.sql.PreparedStatement;



import javafx.application.Application;

import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;



public class App extends Application{

  

  @Override

  public void start(Stage primaryStage) throws Exception {

    Button btn_registrar = new Button("Hazme click para registrar c:!");





    //Aca vamos a crear toda la logica de nuestra APP



    //Primer paso!

    //Crear la conexion, si no, como inserto datos? ☺

    //Necesito 3 cosas. 1 Donde me conecto? 2. Con quien me conecto? 3. El acceso (PASSOWORD)

    //Esto es lo 1

    String origen_conexion = "jdbc:oracle:thin:@localhost:1521:ORCL";

    //Esto es lo 2

    String usuario_db = "usuario_desarrollador";

    //Esto es lo ultimo, es decir, la password con el que me conecto

    String password_usuario_db = "123456";

    TextField txfnombre = new TextField();

    btn_registrar.setOnAction(e -> {
    String nombre_capturado = txfnombre.getText();


      try {

        DriverManager.getConnection(origen_conexion, usuario_db, password_usuario_db).isValid(2);

        System.out.println("Tengo gonexion");


        try {
        System.out.println("Inicio insercion " + nombre_capturado);

        String insertar_datos_sql = "INSERT INTO usuarios (nombre) VALUES ('"    + nombre_capturado     +    "')";


          DriverManager.getConnection(origen_conexion, usuario_db, password_usuario_db).prepareStatement(insertar_datos_sql).executeUpdate();

        

          System.out.println("Datos insertados correctamente");

        } catch (Exception ex) {

          System.out.println("La consulta no se inserto");



        }



      } catch (Exception exc) {

        System.out.println("No se pudo establecer la conexión");

      }

    });



    





    //Acá termina toda la lógica de nuestra APP ☺☻



    VBox contenedor_botones = new VBox(15, txfnombre, btn_registrar);



    Scene escena_principal = new Scene(contenedor_botones, 720, 400);



    primaryStage.setScene(escena_principal);

    primaryStage.show();

  }



  public static void main(String[] args) {

    launch(args);

  }



}


