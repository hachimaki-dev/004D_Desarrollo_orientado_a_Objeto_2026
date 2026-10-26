package com.hachimakidev.biblioapp.view;

import com.hachimakidev.biblioapp.controller.UserController;
import com.hachimakidev.biblioapp.model.User;
import com.hachimakidev.biblioapp.model.Material;
import com.hachimakidev.biblioapp.model.Libro;
import com.hachimakidev.biblioapp.model.Revista;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HomeView {

    public Scene homeScene() {

        Label lbl_user_rut = new Label("Rut:");
        TextField txf_user_rut = new TextField();
        txf_user_rut.setPromptText("ej: 11.111.111-1");
        Button btn_search_user = new Button("Buscar");

        HBox hbox_search_user = new HBox(10, lbl_user_rut, txf_user_rut, btn_search_user);

        Label lbl_user_data_rut = new Label("Rut: ____________");
        Label lbl_user_data_nombre = new Label("Nombre: ____________");
        Label lbl_user_data_email = new Label("Email: ____________");
        Label lbl_user_data_edad = new Label("Edad: ____________");
        Label lbl_user_data_puede_pedir = new Label("¿Puede solicitar libros?: ____________");

        VBox vbox_user_data = new VBox(
                5,
                lbl_user_data_rut,
                lbl_user_data_nombre,
                lbl_user_data_email,
                lbl_user_data_edad,
                lbl_user_data_puede_pedir
        );

        Label lbl_tipo_material = new Label("Tipo de material:");

        ComboBox<String> cmb_tipo_material = new ComboBox<>();
        cmb_tipo_material.getItems().addAll("Libro", "Revista");
        cmb_tipo_material.setValue("Libro");

        TextField txf_nombre = new TextField();
        txf_nombre.setPromptText("Nombre");

        TextField txf_titulo = new TextField();
        txf_titulo.setPromptText("Título");

        TextField txf_publicacion = new TextField();
        txf_publicacion.setPromptText("Año publicación");

        TextField txf_dato1 = new TextField();
        txf_dato1.setPromptText("Autor");

        TextField txf_dato2 = new TextField();
        txf_dato2.setPromptText("Páginas");

        Button btn_crear_material = new Button("Crear material");

        Label lbl_resultado_material = new Label("Resultado: ____________");

        VBox vbox_material = new VBox(
                10,
                lbl_tipo_material,
                cmb_tipo_material,
                txf_nombre,
                txf_titulo,
                txf_publicacion,
                txf_dato1,
                txf_dato2,
                btn_crear_material,
                lbl_resultado_material
        );

        VBox vbox_home = new VBox(
                30,
                hbox_search_user,
                vbox_user_data,
                vbox_material
        );

        btn_search_user.setOnAction(e -> {

            UserController userController = new UserController();

            String rut = txf_user_rut.getText();

            User usuario = userController.buscarUsuario(rut);

            if (usuario != null) {
                lbl_user_data_rut.setText("Rut: " + usuario.getRut());
                lbl_user_data_nombre.setText("Nombre: " + usuario.getNombre());
                lbl_user_data_email.setText("Email: " + usuario.getEmail());
                lbl_user_data_edad.setText("Edad: " + usuario.getEdad());
                lbl_user_data_puede_pedir.setText(
                        "¿Puede solicitar libros?: " + usuario.isPuede_solicitar_prestamos()
                );
            } else {
                lbl_user_data_rut.setText("Rut: No encontrado");
                lbl_user_data_nombre.setText("Nombre: ____________");
                lbl_user_data_email.setText("Email: ____________");
                lbl_user_data_edad.setText("Edad: ____________");
                lbl_user_data_puede_pedir.setText("¿Puede solicitar libros?: ____________");
            }
        });

        cmb_tipo_material.setOnAction(e -> {

            if (cmb_tipo_material.getValue().equals("Libro")) {
                txf_dato1.setPromptText("Autor");
                txf_dato2.setPromptText("Páginas");
            } else {
                txf_dato1.setPromptText("Editorial");
                txf_dato2.setPromptText("Periodicidad");
            }
        });

        btn_crear_material.setOnAction(e -> {

            try {

                String nombre = txf_nombre.getText();
                String titulo = txf_titulo.getText();
                int publicacion = Integer.parseInt(txf_publicacion.getText());

                Material material;

                if (cmb_tipo_material.getValue().equals("Libro")) {

                    String autor = txf_dato1.getText();
                    int paginas = Integer.parseInt(txf_dato2.getText());

                    material = new Libro(
                            nombre,
                            titulo,
                            publicacion,
                            autor,
                            paginas
                    );

                    Libro libro = (Libro) material;

                    lbl_resultado_material.setText(
                            "Libro: " + libro.getTitulo()
                            + " | Autor: " + libro.getAutor()
                            + " | Páginas: " + libro.getPaginas()
                    );

                } else {

                    String editorial = txf_dato1.getText();
                    String periodicidad = txf_dato2.getText();

                    material = new Revista(
                            nombre,
                            titulo,
                            publicacion,
                            editorial,
                            periodicidad
                    );

                    Revista revista = (Revista) material;

                    lbl_resultado_material.setText(
                            "Revista: " + revista.getTitulo()
                            + " | Editorial: " + revista.getEditorial()
                            + " | Periodicidad: " + revista.getPeriodicidad()
                    );
                }

            } catch (NumberFormatException ex) {

                lbl_resultado_material.setText(
                        "Error: publicación y páginas deben ser números."
                );
            }
        });

        return new Scene(vbox_home, 720, 700);
    }
}