package com.amaro.javadb;

import java.sql.DriverManager;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField txf_nombre_usuario = new TextField();
        Button btn_registrar = new Button("Registrar");
        Button btn_actulizar = new Button("Actualizar");
        Button btn_eliminar = new Button("Eliminar");
        // Aca vamos a crear toda la lógica de nuestra App
        // Paso 1. Crear conxión
        // Cosas importantes: ¿Dónde y con quién me conecto y acceso?
        String origen_conexion = "jdbc:oracle:thin:@localhost:1521:ORCL";
        String usuario_db = "usuario_desarrollador";
        String passwd_usuario_db = "123456";

        btn_registrar.setOnAction(e -> {
            String nombre_capturado = txf_nombre_usuario.getText();
            try {
                DriverManager.getConnection(origen_conexion, usuario_db, passwd_usuario_db).isValid(2);
                String insertar_datos_sql = "INSERT INTO TEST(nombre) VALUES ('" + nombre_capturado +  "')";
                try {
                    DriverManager.getConnection(origen_conexion, usuario_db, passwd_usuario_db).prepareStatement(insertar_datos_sql).executeUpdate();
                    System.out.println("Datos insertados correctamente");
                } catch (Exception ex) {
                    System.out.println("No se insertó la consulta");
                }
            } catch (Exception ex) {
                System.out.println("No se pudo establecer la conexión");
            }
        });

        btn_actulizar.setOnAction(e -> {});

        btn_eliminar.setOnAction(e -> {});

        
        // Aca termina toda la lógica de nuestra App
        VBox contenedor_botones = new VBox(10, txf_nombre_usuario, btn_registrar, btn_actulizar, btn_eliminar);
        Scene escena_principal = new Scene(contenedor_botones, 720, 400);
        primaryStage.setScene(escena_principal);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
