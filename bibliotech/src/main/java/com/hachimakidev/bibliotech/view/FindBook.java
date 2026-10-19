package com.hachimakidev.bibliotech.view;
import com.hachimakidev.bibliotech.controller.LibroController;
import com.hachimakidev.bibliotech.model.Libro;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FindBook {

    public VBox bookData(){
        LibroController controller = new LibroController();

        Label lbl_nombre_libro = new Label("Nombre del Libro:");
        TextField txf_nombre_libro = new TextField();
        txf_nombre_libro.setPromptText("Ej: Montañas escumbrosas");
        Button btn_buscar = new Button("Buscar Libro");

        Label lbl_resultado = new Label();
        Label lbl_nombre = new Label("Nombre: -");
        Label lbl_autor = new Label("Autor: -");
        ImageView portada = new ImageView();


        btn_buscar.setOnAction(e ->{
            lbl_nombre.setText("Nombre: -");
            lbl_autor.setText("Autor: -");

            String libro_ingresado = txf_nombre_libro.getText();

            if (!controller.datosDisponibles()){
                lbl_resultado.setText("ERROR: No se pudieron cargar los datos!");
            }
            else if (libro_ingresado.isBlank()){
                lbl_resultado.setText("Escribe un Libro antes de buscar!");
            }
            else{
                Libro libro = controller.buscarLibro(libro_ingresado);

                if (libro != null){
                    lbl_resultado.setText("Libro encontrado.");
                    lbl_nombre.setText("Nombre: " + libro.getNombre());
                    lbl_autor.setText("Autor: " + libro.getAutor() );
                    portada.setImage(new Image(getClass().getResourceAsStream(libro.getImagen())));
                    portada.setFitWidth(200);
                    portada.setFitHeight(300);
                    
                }
                else{
                    lbl_resultado.setText("Libro no encontrado.");
                }
            }
        });

        HBox fila_busqueda = new HBox(10, lbl_nombre_libro, txf_nombre_libro, btn_buscar);
        VBox box = new VBox(10, fila_busqueda, lbl_resultado, lbl_nombre, lbl_autor, portada);
        box.setPadding(new Insets(20));

        return box;

    }
    
}