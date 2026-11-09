package com.view;

import com.controller.UsuarioController;
import com.model.Usuario;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class UsuarioView {

    private UsuarioController controller;
    private TableView<Usuario> tablaUsuarios;

    private TextField txtUsername;
    private TextField txtCorreo;
    private PasswordField txtPassword;
    private ComboBox<String> cmbRol;
    private Label lblEstado;

    // Guarda el ID de la fila seleccionada en la tabla (-1 indica que no hay selección)
    private int idSeleccionado = -1;

    public UsuarioView() {
        this.controller = new UsuarioController();
    }

    public Scene crearEscena() {
        VBox panelFormulario = crearPanelFormulario();
        VBox panelTabla = crearPanelTabla();

        // Permite que el panel de la tabla se estire ocupando todo el espacio derecho
        HBox.setHgrow(panelTabla, Priority.ALWAYS);

        HBox raiz = new HBox(20, panelFormulario, panelTabla);
        raiz.setPadding(new Insets(20));

        // Apenas se construye la ventana, cargamos las filas desde Oracle
        cargarDatosEnTabla();

        return new Scene(raiz, 920, 500);
    }
    private VBox crearPanelFormulario() {
        Label lblTitulo = new Label("Gestión de Cuentas");
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        txtUsername = new TextField();
        txtUsername.setPromptText("Ej: carlitos_dev");

        txtCorreo = new TextField();
        txtCorreo.setPromptText("Ej: carlitos@duoc.cl");

        txtPassword = new PasswordField();
        txtPassword.setPromptText("Contraseña");

        cmbRol = new ComboBox<>();
        cmbRol.getItems().addAll("ESTUDIANTE", "DOCENTE", "ADMIN");
        cmbRol.setPromptText("Seleccione un rol");
        cmbRol.setMaxWidth(Double.MAX_VALUE);

        Button btnGuardar = new Button("Guardar");
        Button btnActualizar = new Button("Actualizar");
        Button btnEliminar = new Button("Eliminar");
        Button btnLimpiar = new Button("Limpiar");

        btnGuardar.setOnAction(e -> accionGuardar());
        btnActualizar.setOnAction(e -> accionActualizar());
        btnEliminar.setOnAction(e -> accionEliminar());
        btnLimpiar.setOnAction(e -> limpiarFormulario());

        HBox filaBotones = new HBox(8, btnGuardar, btnActualizar, btnEliminar, btnLimpiar);

        lblEstado = new Label("Listo. Conectado a Oracle.");

        VBox panel = new VBox(10,
                lblTitulo,
                new Label("Username:"), txtUsername,
                new Label("Correo:"), txtCorreo,
                new Label("Contraseña:"), txtPassword,
                new Label("Rol:"), cmbRol,
                filaBotones,
                lblEstado
        );
        panel.setPrefWidth(320);
        return panel;
    }

    private VBox crearPanelTabla() 
    {
        Label lblSubtitulo = new Label("Registros en Oracle Database");
        lblSubtitulo.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        tablaUsuarios = new TableView<>();

        TableColumn<Usuario, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colId.setPrefWidth(60);

        TableColumn<Usuario, String> colUser = new TableColumn<>("Username");
        colUser.setCellValueFactory(new PropertyValueFactory<>("username"));
        colUser.setPrefWidth(140);

        TableColumn<Usuario, String> colCorreo = new TableColumn<>("Correo");
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colCorreo.setPrefWidth(200);

        TableColumn<Usuario, String> colRol = new TableColumn<>("Rol");
        colRol.setCellValueFactory(new PropertyValueFactory<>("rol"));
        colRol.setPrefWidth(120);

        tablaUsuarios.getColumns().add(colId);
        tablaUsuarios.getColumns().add(colUser);
        tablaUsuarios.getColumns().add(colCorreo);
        tablaUsuarios.getColumns().add(colRol);

        // Escuchador: cuando el usuario hace clic en una fila, copiamos sus datos al formulario
        tablaUsuarios.getSelectionModel().selectedItemProperty().addListener((obs, anterior, seleccionado) -> {
            if (seleccionado != null) {
                idSeleccionado = seleccionado.getID();
                txtUsername.setText(seleccionado.getUsername());
                txtCorreo.setText(seleccionado.getCorreo());
                txtPassword.setText(seleccionado.getPassword());
                cmbRol.setValue(seleccionado.getRol());
                lblEstado.setText("Editando usuario ID #" + idSeleccionado);
            }
        });

        VBox.setVgrow(tablaUsuarios, Priority.ALWAYS);
        return new VBox(10, lblSubtitulo, tablaUsuarios);
    }

    private void accionGuardar() {
        boolean exito = controller.registrarUsuario(
                txtUsername.getText(),
                txtCorreo.getText(),
                txtPassword.getText(),
                cmbRol.getValue()
        );

        if (exito) {
            lblEstado.setText("Usuario guardado correctamente en Oracle.");
            limpiarFormulario();
            cargarDatosEnTabla();
        } else {
            lblEstado.setText("Error: Completa todos los campos o cambia el username.");
        }
    }

    private void accionActualizar() {
        if (idSeleccionado == -1) {
            lblEstado.setText("Selecciona primero un usuario en la tabla.");
            return;
        }

        boolean exito = controller.actualizarUsuario(
                idSeleccionado,
                txtUsername.getText(),
                txtCorreo.getText(),
                txtPassword.getText(),
                cmbRol.getValue()
        );

        if (exito) {
            lblEstado.setText("Usuario ID #" + idSeleccionado + " actualizado.");
            limpiarFormulario();
            cargarDatosEnTabla();
        } else {
            lblEstado.setText("Error al actualizar los datos.");
        }
    }

    private void accionEliminar() 
    {
        if (idSeleccionado == -1) {
            lblEstado.setText("Selecciona primero un usuario en la tabla.");
            return;
        }

        boolean exito = controller.eliminarUsuario(idSeleccionado);


        if (exito) {
            lblEstado.setText("Usuario eliminado de Oracle.");
            limpiarFormulario();
            cargarDatosEnTabla();
        } else {
            lblEstado.setText("No se pudo eliminar el usuario.");
        }
    }

    private void cargarDatosEnTabla() 
    {
        ObservableList<Usuario> datos = FXCollections.observableArrayList(
                controller.obtenerUsuarios()
        );
        tablaUsuarios.setItems(datos);
    }

    private void limpiarFormulario() 
    {
        idSeleccionado = -1;
        txtUsername.clear();
        txtCorreo.clear();
        txtPassword.clear();
        cmbRol.setValue(null);
        tablaUsuarios.getSelectionModel().clearSelection();
    }
}

