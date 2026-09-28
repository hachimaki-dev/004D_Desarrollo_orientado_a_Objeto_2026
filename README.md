# Proyecto JavaFX (Desarrollo Orientado a Objetos)

Plantilla lista para usar en los **laboratorios de la universidad** sin necesidad de Maven ni permisos de administrador para cambiar variables de entorno (`JAVA_HOME` o `PATH`).

---

## 🚀 ¿Cómo clonar y empezar?

### 1. Clonar esta rama desde GitHub
Abre la terminal o Git Bash y ejecuta:
```bash
git clone -b EA2/javafx_profe https://github.com/TU_USUARIO/TU_REPOSITORIO.git
cd TU_REPOSITORIO
```

---

## 💻 ¿Cómo ejecutar el proyecto?

Tienes **dos opciones** súper sencillas:

### Opción A: Desde Visual Studio Code (Recomendada)
1. Abre la carpeta del proyecto en **VS Code** (`Archivo > Abrir carpeta...`).
2. Abre el archivo [`src/Main.java`](file:///Users/hachimaki/Desktop/2026%202%20semestre/Desarrollo%20Orientado%20a%20Objeto/004D_Desarrollo_orientado_a_Objeto_2026/src/Main.java).
3. Presiona la tecla **F5** (o haz clic en el botón superior **Run / Play**).
4. ¡Listo! La ventana de JavaFX se abrirá inmediatamente.

> **Nota:** La configuración de VS Code en [`.vscode/launch.json`](file:///Users/hachimaki/Desktop/2026%202%20semestre/Desarrollo%20Orientado%20a%20Objeto/004D_Desarrollo_orientado_a_Objeto_2026/.vscode/launch.json) ya incluye las banderas de módulos necesarias (`--module-path lib --add-modules javafx.controls,javafx.fxml`).

---

### Opción B: Con doble clic (Windows - Laboratorio)
1. Abre el explorador de archivos de Windows en la carpeta del proyecto.
2. Haz doble clic en el archivo [`ejecutar.bat`](file:///Users/hachimaki/Desktop/2026%202%20semestre/Desarrollo%20Orientado%20a%20Objeto/004D_Desarrollo_orientado_a_Objeto_2026/ejecutar.bat).
3. El script detectará automáticamente Java 21 en el equipo, compilará el código y ejecutará la aplicación.

*(Si estás en macOS o Linux, puedes ejecutar en la terminal: `./ejecutar.sh`)*

---

## 📁 Estructura del Proyecto

```text
├── .vscode/
│   ├── launch.json       # Configuración para ejecutar con F5 en VS Code
│   └── settings.json     # Rutas de librerías para autocompletado y sintaxis
├── lib/                  # JARs de JavaFX 21 para Windows (Laboratorio)
│   ├── javafx-base-21.0.6-win.jar
│   ├── javafx-controls-21.0.6-win.jar
│   ├── javafx-fxml-21.0.6-win.jar
│   ├── javafx-graphics-21.0.6-win.jar
│   └── mac/              # JARs compatibles para macOS
├── src/
│   ├── App.java          # Interfaz gráfica y lógica de JavaFX
│   └── Main.java         # Clase lanzadora (evita errores de runtime de JavaFX)
├── ejecutar.bat          # Lanzador automático de 1 clic para Windows
├── ejecutar.sh           # Lanzador para Mac / Linux
└── README.md
```

---

## 🛠️ ¿Cómo agregar nuevas pantallas o código?
1. Escribe tus clases con lógica POO en la carpeta [`src/`](file:///Users/hachimaki/Desktop/2026%202%20semestre/Desarrollo%20Orientado%20a%20Objeto/004D_Desarrollo_orientado_a_Objeto_2026/src).
2. Modifica la clase [`src/App.java`](file:///Users/hachimaki/Desktop/2026%202%20semestre/Desarrollo%20Orientado%20a%20Objeto/004D_Desarrollo_orientado_a_Objeto_2026/src/App.java) para construir tus controles (Botones, Cajas de texto, Tablas, Layouts).
3. Recuerda siempre iniciar tu programa ejecutando [`src/Main.java`](file:///Users/hachimaki/Desktop/2026%202%20semestre/Desarrollo%20Orientado%20a%20Objeto/004D_Desarrollo_orientado_a_Objeto_2026/src/Main.java).
