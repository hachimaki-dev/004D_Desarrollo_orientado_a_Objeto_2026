package com.blasphemycmd.javadb;

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
    TextField txf_usuario_a_eliminar = new TextField();
    Button btn_eliminar_usuario = new Button();
    TextField txf_nombre_usuario = new TextField();
    Button btn_registrar = new Button("Hazme click para registrar c:!");
    //comienza la logica
    //donde me conecto
    String origen_conexion = "jdbc:oracle:thin:@localhost:1521:ORCL";
    //como me conecto
    String usuario_db = "usuario_desarrollador";
    //password
    String password_usuario_db = "123456";
    
        btn_eliminar_usuario.setOnAction(e ->{
            String nombre_seleccionado = txf_usuario_a_eliminar.getText();
            try {
                String 
            } catch (Exception e) {
                // TODO: handle exception
            }
        });
        



        btn_registrar.setOnAction(e ->{
            String nombre_capturado = txf_nombre_usuario.getText();
         try {
            DriverManager.getConnection(origen_conexion,usuario_db,password_usuario_db).isValid(2);
            
            String insertar_datos_sql = "INSERT INTO TEST(nombre) VALUES ('"+ nombre_capturado+ "')";
            try {
                DriverManager.getConnection(origen_conexion,usuario_db,password_usuario_db).prepareStatement(insertar_datos_sql).executeUpdate();
                System.out.println("se logro");
            } catch (Exception ex) {
                System.out.println("cf");
            }
        } catch (Exception ex) {
            System.out.println("Fallo");
        }
        });
  



    //termina la logica


    VBox contenedor_botones = new VBox(btn_registrar,txf_nombre_usuario);



    Scene escena_principal = new Scene(contenedor_botones, 720, 400);



    primaryStage.setScene(escena_principal);

    primaryStage.show();


  }
   public static void main(String[] args) {

    launch(args);
}
}
