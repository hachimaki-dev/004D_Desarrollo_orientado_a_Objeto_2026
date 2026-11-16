package com.agcamila01.javadb;

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
        TextField txfNombre = new TextField();
        Button btnRegistrar = new Button("Hazme clic para registrar c:!");
        Button btnMostrar = new Button("Mostar tabla en consola");

        /* INICIO LÓGICA */

        // Paso 1: crear la conexion -> donde me conecto, con quien me conecto, acceso (password)
        String origenConexion = "jdbc:oracle:thin:@localhost:1521:ORCL";
        String usuarioDB = "usuario_desarrollador";
        String passwordUsuarioDB = "123456";

        
        btnRegistrar.setOnAction(evento -> {
            String nombreCapturado = txfNombre.getText();
            try {
                DriverManager.getConnection(origenConexion, usuarioDB, passwordUsuarioDB).isValid(2);
                String insertarDatosSQL = "INSERT INTO TEST (nombre) VALUES ('" + nombreCapturado + "')";
                try {
                    DriverManager.getConnection(origenConexion, usuarioDB, passwordUsuarioDB).prepareStatement(insertarDatosSQL).executeUpdate();
                    System.out.println("Datos insertados correctamente");
                } catch (Exception e) {
                    System.out.println("La consulta no se insertó");
                }
            } catch (Exception e) {
                System.out.println("No se pudo establecer la conexion");
            }
        });

        btnMostrar.setOnAction(evento -> {
            try {
                DriverManager.getConnection(origenConexion, usuarioDB, passwordUsuarioDB).isValid(2);
                String mostrarDatosSQL = "SELECT id, nombre FROM TEST ORDER BY id ASC";
                try {
                    DriverManager.getConnection(origenConexion, usuarioDB, passwordUsuarioDB).prepareStatement(mostrarDatosSQL).executeUpdate();
                    
                } catch (Exception e) {
                    System.out.println("No hay datos");
                }
            } catch (Exception e) {
                System.out.println("No se pudo establecer la conexion");
            }
        });

       

        /* FIN LÓGICA */

        VBox contenedorBotones = new VBox(10, txfNombre, btnRegistrar, btnMostrar);
        Scene escenaPrincipal = new Scene(contenedorBotones, 720, 480);
        primaryStage.setScene(escenaPrincipal);
        primaryStage.setTitle("Java DB");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
