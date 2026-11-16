package com.betobullisio19.javadb;

import java.sql.DriverManager;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override 
    public void start(Stage primaryStage) throws Exception{
        Button btn_registrar = new Button("registrar");

        //acavamos a crear toda la logica de nuesta app
        //primer paso = crear conex
        //1.donde me concto
        //2.conque me conectio
        //3.el acceso(passwrd)

        //paso1
        String origen_conexion = "jdbc:oracle:thin:@localhost:1521:ORCL";
        //paso2
        String usuariodb = "usuario_desarrollador";
        //paso3
        String password_usuario_db = "123456";

        btn_registrar.setOnAction(e ->{;

            String nomrbe = txf_nombre_capturado.getText();

            try {
                DriverManager.getConnection(origen_conexion,usuariodb,password_usuario_db).isValid(2);

                String insertar_datos_sql = "INSERT INTO TEST(nombre) VALUES ('" + txf_nombre_capturado + "')";
                
                try {
                    DriverManager.getConnection(origen_conexion,usuariodb,password_usuario_db).prepareStatement(insertar_datos_sql).executeUpdate();
                } catch (Exception ex) {
                    System.out.println("la consulta c la insertaron al brayan");
                }
            } catch (Exception exc) {
                System.out.println("no se puede hacer la conxcion por weco");
            }
        });

        TextField txf_nombre_capturado = new TextField();







        //aca termina la logica de nuesta app











        VBox contenedor_botones = new VBox (10, btn_registrar);

        Scene scena_principal = new Scene(contenedor_botones , 720, 400);

        primaryStage.setScene(scena_principal);
        primaryStage.show();

    }
    
    public static void main(String [] args){
        launch(args);
    };

}
