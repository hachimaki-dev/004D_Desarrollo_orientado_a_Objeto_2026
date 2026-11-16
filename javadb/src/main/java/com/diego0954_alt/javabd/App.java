package com.diego0954_alt.javabd;

import java.sql.DriverManager;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App  extends Application{

    public void start(Stage primaryStage) throws
    Exception{

        TextField txf_nombre_usuario = new TextField();
        Button btn_resgistrar = new Button("hazme clck para registar :)");
        //crear
        //primer paso
        String origen_conexion = "jdbc:oracle:thin:@localhost:1521:ORCL";

        //segundo paso
        String usuario_db = "usuario_desarrollador";

        //tercer paso
        String password_usuario_db = "123456";

        btn_resgistrar.setOnAction(e -> {
            String nombre_capturado = txf_nombre_usuario.getText();
      try {

        DriverManager.getConnection(origen_conexion, usuario_db, password_usuario_db).isValid(2);
        String insertar_datos_sql = "INSERT INTO TEST(nombre) VALUES ('" + nombre_capturado +   "')";
        try {

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
    VBox contenedor_botones = new VBox(10, txf_nombre_usuario, btn_resgistrar);
    Scene escena_principal = new Scene(contenedor_botones, 720, 400);
    primaryStage.setScene(escena_principal);
    primaryStage.show();

  }
  public static void main(String[] args) {

    launch(args);
  }
}