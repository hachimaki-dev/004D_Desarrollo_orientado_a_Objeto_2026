package com.monrousito14.javadb;

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

        TextField tfInserteNombre = new TextField();
        tfInserteNombre.setPromptText("Escribe un nombre");

        Button btn_registrar = new Button("Hazme click para registrar!");

        //logica de app - inicio

        //Paso 1, crear conexion con DB
        String origen_conexion = "jdbc:oracle:thin:@localhost:1521:ORCL";

        String usuario_db = "usuario_desarrollador";

        String password_usuario_db = "123456";

        btn_registrar.setOnAction(e -> {
            String nombreInsertado = tfInserteNombre.getText().trim();

            if (nombreInsertado.isEmpty()) {
                System.out.println("Ingrese un nombre antes de registrar");
                return;
            }

            try {
            DriverManager.getConnection(origen_conexion, usuario_db, password_usuario_db).isValid(2);

            String insertar_datos_sql = "INSERT INTO TEST(nombre) VALUES ('" + nombreInsertado +"')";

                try {
                DriverManager.getConnection(origen_conexion, usuario_db, password_usuario_db).prepareStatement(insertar_datos_sql).executeUpdate();
                System.out.println("Datos insertados correctamente");

                }
                catch (Exception ex) {
                    System.out.println("La consulta no se inserto");
                }
            
            } catch (Exception r) {
            System.out.println("No se pudo establecer la conexion");
            }
        });

       

        //logica de app - fin

        VBox contenedor_botones = new VBox(10, tfInserteNombre, btn_registrar);

        Scene escena_principal = new Scene(contenedor_botones, 720, 400);

        primaryStage.setScene(escena_principal);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
