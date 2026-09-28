import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Aplicación principal de JavaFX para Desarrollo Orientado a Objetos.
 */
public class App extends Application {

    private int contadorClicks = 0;

    @Override
    public void start(Stage primaryStage) {
        // Título de la ventana
        primaryStage.setTitle("Desarrollo Orientado a Objetos - JavaFX Lab");

        // Componentes de interfaz
        Label lblTitulo = new Label("🚀 ¡JavaFX funcionando correctamente!");
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #1e293b;");

        Label lblSubtitulo = new Label("Listo para el laboratorio sin necesidad de Maven ni variables de entorno.");
        lblSubtitulo.setStyle("-fx-font-size: 13px; -fx-text-fill: #64748b;");

        // Entrada interactiva
        Label lblNombre = new Label("Ingresa tu nombre:");
        lblNombre.setStyle("-fx-font-size: 13px; -fx-text-fill: #334155;");

        TextField txtNombre = new TextField();
        txtNombre.setPromptText("Ej: Juan Pérez");
        txtNombre.setMaxWidth(220);
        txtNombre.setStyle("-fx-padding: 8px; -fx-background-radius: 6px; -fx-border-radius: 6px; -fx-border-color: #cbd5e1;");

        Button btnSaludar = new Button("Saludar");
        btnSaludar.setStyle("-fx-background-color: #2563eb; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 8px 16px; -fx-background-radius: 6px; -fx-cursor: hand;");

        Label lblMensaje = new Label("");
        lblMensaje.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #059669;");

        // Botón contador
        Button btnContador = new Button("Clicks: 0");
        btnContador.setStyle("-fx-background-color: #e2e8f0; -fx-text-fill: #1e293b; -fx-font-weight: bold; -fx-padding: 8px 16px; -fx-background-radius: 6px; -fx-cursor: hand;");

        // Eventos
        btnSaludar.setOnAction(e -> {
            String nombre = txtNombre.getText().trim();
            if (nombre.isEmpty()) {
                lblMensaje.setText("¡Por favor escribe tu nombre!");
                lblMensaje.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #dc2626;");
            } else {
                lblMensaje.setText("¡Bienvenido/a, " + nombre + "! Disfruta la clase.");
                lblMensaje.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #059669;");
            }
        });

        btnContador.setOnAction(e -> {
            contadorClicks++;
            btnContador.setText("Clicks: " + contadorClicks);
        });

        HBox cajaInput = new HBox(10, txtNombre, btnSaludar);
        cajaInput.setAlignment(Pos.CENTER);

        VBox contenedor = new VBox(16, lblTitulo, lblSubtitulo, cajaInput, lblMensaje, btnContador);
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setPadding(new Insets(30));
        contenedor.setStyle("-fx-background-color: #f8fafc;");

        Scene escena = new Scene(contenedor, 520, 320);
        primaryStage.setScene(escena);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
