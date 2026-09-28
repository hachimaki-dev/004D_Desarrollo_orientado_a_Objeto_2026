@echo off
setlocal enabledelayedexpansion
chcp 65001 > nul
cls

echo =========================================================
echo    INICIADOR JAVAFX - DESARROLLO ORIENTADO A OBJETOS
echo =========================================================
echo.

:: 1. Verificar si java y javac estan en el PATH
where java >nul 2>nul
if %errorlevel% equ 0 (
    goto :JAVA_LISTO
)

:: 2. Si no estan en el PATH, buscar en rutas tipicas de laboratorios universitarios
echo [AVISO] Java no esta en la variable PATH del sistema.
echo Buscando instalacion de Java 21 en el disco...

set "RUTAS_BUSQUEDA="C:\Program Files\Java" "C:\Program Files\Eclipse Adoptium" "C:\Program Files\Amazon Corretto" "C:\Program Files\BellSoft" "C:\Program Files\Zulu" "%LOCALAPPDATA%\Programs\Eclipse Adoptium""

for %%D in (%RUTAS_BUSQUEDA%) do (
    if exist %%D (
        for /f "delims=" %%J in ('dir /b /s "%%~D\javac.exe" 2^>nul') do (
            set "JAVAC_PATH=%%J"
            set "JAVA_DIR=%%~dpJ"
            goto :JAVA_ENCONTRADO
        )
    )
)

:JAVA_NO_ENCONTRADO
echo [ERROR] No se pudo encontrar un compilador Java (javac.exe) en las rutas tipicas.
echo Por favor asegurate de que Java 21 JDK este instalado en este equipo.
echo.
pause
exit /b 1

:JAVA_ENCONTRADO
set "PATH=%JAVA_DIR%;%PATH%"
echo [OK] JDK encontrado en: %JAVA_DIR%
echo.

:JAVA_LISTO
if not exist "bin" mkdir "bin"

echo [1/2] Compilando clases Java...
javac --module-path lib --add-modules javafx.controls,javafx.fxml -d bin src/*.java
if %errorlevel% neq 0 (
    echo.
    echo [ERROR] Hubo un problema al compilar el codigo.
    echo Revisa los errores mostrados arriba.
    echo.
    pause
    exit /b %errorlevel%
)

echo [OK] Compilacion exitosa.
echo.
echo [2/2] Iniciando aplicacion JavaFX...
java --module-path lib --add-modules javafx.controls,javafx.fxml -cp bin Main

if %errorlevel% neq 0 (
    echo.
    echo [ERROR] Hubo un error al ejecutar la aplicacion.
    echo.
    pause
)
