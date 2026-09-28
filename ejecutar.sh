#!/bin/bash
# Script de ejecución para macOS y Linux

set -e

# Detectar OS y arquitectura para seleccionar librerías adecuadas
OS="$(uname -s)"
ARCH="$(uname -m)"

LIB_DIR="lib"

if [ "$OS" = "Darwin" ]; then
    if [ -d "lib/mac" ]; then
        LIB_DIR="lib/mac"
    fi
fi

mkdir -p bin

echo "Compilando clases Java con JavaFX ($LIB_DIR)..."
javac --module-path "$LIB_DIR" --add-modules javafx.controls,javafx.fxml -d bin src/*.java

echo "Iniciando aplicación JavaFX..."
java --module-path "$LIB_DIR" --add-modules javafx.controls,javafx.fxml -cp bin Main
