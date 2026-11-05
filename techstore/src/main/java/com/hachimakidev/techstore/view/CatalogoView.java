package com.hachimakidev.techstore.view;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import com.hachimakidev.techstore.controller.DispositivoController;
import com.hachimakidev.techstore.model.Dispositivo;
import com.hachimakidev.techstore.model.Notebook;
import com.hachimakidev.techstore.model.Smartphone;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class CatalogoView {

    public VBox catalogo() {
        // TODO 1: Instanciar DispositivoController para pedirle la lista de dispositivos y registrar nuevos equipos.

        DispositivoController controller = new DispositivoController();

        Label lbl_titulo = new Label("TechStore — Catálogo de Notebooks y Smartphones");
        lbl_titulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // TODO 2: Reemplazar este contenedor temporal por un TableView<Dispositivo>
        //   - Crear columnas con PropertyValueFactory para: "id", "tipo", "marca", "modelo", "precio", "especificacion", "disponible"
        //   - Poblar la tabla usando FXCollections.observableArrayList(...) con la lista del controlador








        TableView <Dispositivo> tablaDispositivos = new TableView<>();

        tablaDispositivos.setItems(FXCollections.observableArrayList(controller.obtenerDispositivos()));

        TableColumn <Dispositivo, Integer> columnaID = new TableColumn<>("ID");

        columnaID.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn <Dispositivo, String> columnaTipo = new TableColumn<>("Tipo");

        columnaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));

        TableColumn <Dispositivo, String> columnaMarca = new TableColumn<>("Marca");

        columnaMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));

        TableColumn <Dispositivo, String> columnaModelo = new TableColumn<>("Modelo");

        columnaModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));

        TableColumn <Dispositivo, Integer> columnaPrecio = new TableColumn<>("Precio");

        columnaPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        TableColumn <Dispositivo, String> columnaEspecificacion = new TableColumn<>("Especificacion");

        columnaEspecificacion.setCellValueFactory(new PropertyValueFactory<>("especificacion"));

        TableColumn <Dispositivo, Boolean> columnaDisponible = new TableColumn<>("Disponible");

        columnaDisponible.setCellValueFactory(new PropertyValueFactory<>("disponible"));

        tablaDispositivos.getColumns().addAll(columnaID, columnaTipo, columnaMarca, columnaModelo, columnaPrecio, columnaEspecificacion, columnaDisponible);

        VBox contenedor_tabla = new VBox(10, tablaDispositivos);


        







        contenedor_tabla.setPadding(new Insets(20));
        contenedor_tabla.setStyle("-fx-border-color: #cbd5e1; -fx-border-radius: 6; -fx-background-color: #f8fafc;");





        // TODO 3: Construir el formulario en este contenedor para agregar un nuevo Notebook o Smartphone
        //   - Incluir controles (TextField / ComboBox) para ingresar los datos del nuevo dispositivo
        //   - Incluir un Button "Agregar Dispositivo" cuyo setOnAction cree el objeto, lo envíe al controlador y actualice la TableView




        Label lbl_titulo_de_agregar = new Label("Agregar nuevo Dispositivo al inventario: ");
         HBox h1 = new HBox(10, lbl_titulo_de_agregar);



        ComboBox <String> combo_opciones = new ComboBox<>();
        combo_opciones.getItems().addAll("Notebook", "Smartphone");
        combo_opciones.setValue("Notebook");

        TextField Marca_txf = new TextField();
        Marca_txf.setPromptText("Marca");
        TextField Precio_txf = new TextField();
        Precio_txf.setPromptText("Precio");
        TextField Modelo_txf = new TextField();
        Modelo_txf.setPromptText("Modelo");
        HBox h2 = new HBox(10, combo_opciones, Marca_txf, Precio_txf, Modelo_txf);


        TextField Ram_txf = new TextField();
        Ram_txf.setPromptText("RAM");
        TextField Procesador_txf = new TextField();
        Procesador_txf.setPromptText("Procesador");

        combo_opciones.setOnAction(sePresionoSmartphone -> {

            String opcionSeleccionada = combo_opciones.getValue();

            if (opcionSeleccionada.equals("Smartphone")) {

                    Ram_txf.setPromptText("Almacenamiento (GB)");

                    Procesador_txf.setPromptText("Cámara (MP)");
               
            } else {

                Ram_txf.setPromptText("RAM");
       
                Procesador_txf.setPromptText("Procesador");
                
            }
        });

        Button Agregar_dispositivo_boton = new Button("Agregar Dispositivo");

        Agregar_dispositivo_boton.setOnAction (presionaron_el_boton -> { 

            String guardarComboOpciones = combo_opciones.getValue();
            String guardarMarca = Marca_txf.getText();
            String guardarPrecio = Precio_txf.getText();
            String guardarModelo = Modelo_txf.getText();
            String guardarRam = Ram_txf.getText();
            String guardarProcesador = Procesador_txf.getText();

            int precio = Integer.parseInt(guardarPrecio);

            int ID = controller.obtenerDispositivos().size() + 1;

            if (guardarComboOpciones.equals("Notebook")){

                int RAM = Integer.parseInt(guardarRam);

              Notebook N1 = new Notebook (ID, guardarMarca, guardarModelo, precio, true, RAM, guardarProcesador);

              controller.agregarDispositivo(N1);

              tablaDispositivos.getItems().setAll(controller.obtenerDispositivos());

            } else if (guardarComboOpciones.equals("Smartphone")) {

                int almacenamiento = Integer.parseInt(guardarRam);
                int camara = Integer.parseInt(guardarProcesador);

                Smartphone S1 = new Smartphone(ID, guardarMarca, guardarModelo, precio, true, almacenamiento, camara);

                controller.agregarDispositivo(S1);

                tablaDispositivos.getItems().setAll(controller.obtenerDispositivos());
            }
        });


        HBox h3 = new HBox(10, Ram_txf, Procesador_txf, Agregar_dispositivo_boton);

        VBox contenedor_formulario = new VBox(10, h1, h2, h3);













        contenedor_formulario.setPadding(new Insets(16));
        contenedor_formulario.setStyle("-fx-border-color: #cbd5e1; -fx-border-radius: 6; -fx-background-color: #ffffff;");

        VBox layout_principal = new VBox(16, lbl_titulo, contenedor_tabla, contenedor_formulario);
        layout_principal.setPadding(new Insets(20));

        return layout_principal;
    }
}

