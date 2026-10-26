package com.hachimakidev.biblioapp.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class homeView 
{
    
    public VBox homeScenePrincipal()
    {

        Label lbl_principal = new Label("BIBLIOAPP");
        lbl_principal.setStyle("-fx-font-size: 70px; -fx-font-weight: 700; -fx-border-color: #000000; -fx-border-width: 4px; -fx-background-color: #aa1212; -fx-text-fill: rgb(0, 0, 0)");
        lbl_principal.setAlignment(Pos.CENTER);
        lbl_principal.setPadding(new Insets(40, 160, 40 ,160));

        Label lbl_opciones = new Label("Opciones:");
        lbl_opciones.setStyle("-fx-font-size: 12px; -fx-font-weight: 400; -fx-border-color: #000000; -fx-border-width: 2px; -fx-text-fill: #000000");
        lbl_opciones.setAlignment(Pos.CENTER_LEFT);
        lbl_opciones.setPadding(new Insets(20));

        Button btn_opcion_1 = new Button("Opción 1: ");
        btn_opcion_1.setStyle("-fx-background-color: #f88909; -fx-text-fill: rgb(0, 0, 0)");

        Label lbl_registro_usuarios = new Label("Registrar usuarios");
        lbl_registro_usuarios.setStyle("-fx-text-fill: rgb(0, 0, 0); -fx-font-weight: 400");

        HBox hb_opcion1 = new HBox(10, btn_opcion_1, lbl_registro_usuarios);
        hb_opcion1.setStyle("-fx-background-color: #d4c0c0");
        btn_opcion_1.setOnAction(e -> 
            {

            });

        Button btn_opcion_2 = new Button("Opción 2: ");
        btn_opcion_2.setStyle("-fx-background-color: #f88909; -fx-text-fill: rgb(0, 0, 0)");

        Label lbl_buscar_usuario_por_rut = new Label("Buscar usuario por RUT");
        lbl_buscar_usuario_por_rut.setStyle("-fx-text-fill: rgb(0, 0, 0); -fx-font-weight: 400");

        HBox hb_opcion2 = new HBox(10, btn_opcion_2, lbl_buscar_usuario_por_rut);
        hb_opcion2.setStyle("-fx-background-color: #d4c0c0");
        btn_opcion_2.setOnAction(e -> 
            {

                Scene escenaActual = btn_opcion_2.getScene();

                searchRutView searchrut = new searchRutView();

                escenaActual.setRoot(searchrut.homeScene());

            });
        Button btn_opcion_3 = new Button("Opción 3: ");
        btn_opcion_3.setStyle("-fx-background-color: #f88909; -fx-text-fill: rgb(0, 0, 0)");
        
        Label lbl_registro_libros = new Label("Registrar libro");
        lbl_registro_libros.setStyle("-fx-text-fill: rgb(0, 0, 0); -fx-font-weight: 400");
        
        HBox hb_opcion3 = new HBox(10, btn_opcion_3, lbl_registro_libros);
        hb_opcion3.setStyle("-fx-background-color: #d4c0c0");
        btn_opcion_3.setOnAction(e -> 
            {

            });

        VBox vb_BODY = new VBox(20);

        vb_BODY.getChildren().setAll(lbl_opciones, hb_opcion1, hb_opcion2, hb_opcion3);
        vb_BODY.setAlignment(Pos.CENTER_LEFT);
        vb_BODY.setStyle("-fx-background-color: #48e629");

        VBox vb_ALL = new VBox(20, lbl_principal, vb_BODY);

        vb_ALL.setAlignment(Pos.TOP_CENTER);
        vb_ALL.setPadding(new Insets(10, 10, 10 ,10));
        vb_ALL.setStyle("-fx-background-color: #f71cff");

        return vb_ALL;

    }

}
