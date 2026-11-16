package com.app;

import java.sql.Connection;
import java.sql.DriverManager;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btn_regitrar = new Button("click para registar");

        String origen_conexion = "jdbc:oracle:thin:@localhost:1521:ORCL";

        String usuario_db = "usuario_desarrollador";

        String password_usuariodb = "123456";

        VBox contenedor_botones = new VBox(btn_regitrar);

        try {
            DriverManager.getConnection(origen_conexion, usuario_db, password_usuariodb).isValid(3);

            String insertar_datos_sql = "INSERT INTO TEST(NOMBRE) VALUES ('PEPITO')";

            try {
                DriverManager.getConnection(origen_conexion, usuario_db, password_usuariodb).prepareStatement(insertar_datos_sql).executeUpdate();
                System.out.println("lo logro señor");
            } catch (Exception e) {
                System.out.println("LA CONSULTA NO SE INSERTO");
            }
        
        } catch (Exception e) {
            System.out.println("no te conectaste");
        }

         Scene escena_principal = new Scene(contenedor_botones, 700, 400);
        primaryStage.setScene(escena_principal);
        primaryStage.show();
        

        
    }
    public static void main(String[] args) {
    launch(args);
  }
}