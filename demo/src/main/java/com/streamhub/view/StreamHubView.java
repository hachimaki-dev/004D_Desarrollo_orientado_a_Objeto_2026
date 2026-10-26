package com.streamhub.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class StreamHubView 
{

    public Scene HomeScene()
    {

        Label lbl_user_rut = new Label ("RUT: ");
        lbl_user_rut.setStyle("-fx-text-fill:rgb(0, 0, 0); -fx-font-size: 15px; -fx-font-weight: 800");

        TextField txf_user_rut = new TextField();

        txf_user_rut.setPromptText (" 11.111.111-1");
        txf_user_rut.setAlignment(Pos.BOTTOM_CENTER);

        Button btn_search_user = new Button("Buscar");
        btn_search_user.setStyle("-fx-background-color:rgb(0, 255, 98); boton.setStyle(-fx-background-radius: 15px;");

        HBox hb_search_user = new HBox (20, lbl_user_rut, txf_user_rut, btn_search_user);

        Label lbl_rut = new Label("RUT: ");
        lbl_rut.setStyle("-fx-textfill:rgb(0, 0, 0); -fx-front-weight: 800");

        Label lbl_nombre = new Label("Nombre: ");
        lbl_nombre.setStyle("-fx-textfill:rgb(0, 0, 0); -fx-front-weight: 800");

        Label lbl_plan = new Label("Plan: ");
        lbl_plan.setStyle("-fx-textfill:rgb(0, 0, 0); -fx-front-weight: 800");

        Label lbl_email = new Label("Email: ");
        lbl_email.setStyle("-fx-textfill:rgb(0, 0, 0); -fx-front-weight: 800");

        VBox vb_BODY = new VBox(10);

        vb_BODY.getChildren().setAll(lbl_rut, lbl_nombre, lbl_plan, lbl_email);

        VBox vb_ALL = new VBox(20, hb_search_user, vb_BODY);

        Scene escena_final = new Scene(vb_ALL, 720, 480);

        return escena_final;

    }
    
}
