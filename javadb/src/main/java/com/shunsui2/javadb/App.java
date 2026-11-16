package com.shunsui2.javadb;

import java.sql.DriverManager;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App  extends  Application{
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField txf_nombre = new TextField();
        
        Button btn_registrar = new Button("Registrar");
        

        // logica app

        // primer paso : crear conexion
        // nececito 3 cosas - 1 : donde me concecto - 2 : con quien me conecto -3 : el acceso (´password)
        // 1
        String origen_conexion = "jdbc:oracle:thin:@localhost:1521:ORCL";
        //2
        String usuario_db = "usuario_desarrollador" ;
        // 3
        String password_usuariadb = "123456";


        btn_registrar.setOnAction(e -> {
            String nombre_cacturado = txf_nombre.getText();
            try {

                DriverManager.getConnection(origen_conexion, usuario_db, password_usuariadb).isValid(2);
                String insertarDatos = "INSERT INTO TEST(nombre) VALUES ('" + nombre_cacturado + " ')";
                System.out.println("Conectado");

                try {
                    DriverManager.getConnection(origen_conexion, usuario_db, password_usuariadb).prepareStatement(insertarDatos).executeUpdate();
                } catch (Exception ex) {
                    System.out.println("La consulta no se inserto.");
                }

            } catch (Exception exc) {
                System.err.println("No se pudo establecer la conexion ");
            }
            
                    
        });



        
        

        // termino logica app





        VBox contenedor_botones = new VBox(10 , btn_registrar , txf_nombre);

        Scene scena_principal = new Scene(contenedor_botones , 1080 , 720);

        primaryStage.setScene(scena_principal);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
