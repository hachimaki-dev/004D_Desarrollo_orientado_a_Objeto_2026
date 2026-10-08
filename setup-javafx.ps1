# ============================================================
# Java + Maven + JavaFX + VS Code
# Bootstrap para laboratorio Windows
#
# Uso:
#   .\setup-javafx.ps1
#
# El script:
#   - Configura JAVA_HOME
#   - Configura MAVEN_HOME
#   - Configura PATH
#   - Verifica Java y Maven
#   - Configura Maven para JavaFX
#   - Configura VS Code / Java Language Server
#   - Compila el proyecto
#   - Abre VS Code en la carpeta correcta
# ============================================================

$ErrorActionPreference = "Stop"

# ------------------------------------------------------------
# COLORES / FUNCIONES
# ------------------------------------------------------------

function Write-Step {
    param([string]$Message)
    Write-Host ""
    Write-Host "==> $Message" -ForegroundColor Cyan
}

function Write-OK {
    param([string]$Message)
    Write-Host "[OK] $Message" -ForegroundColor Green
}

function Write-Warn {
    param([string]$Message)
    Write-Host "[!] $Message" -ForegroundColor Yellow
}

function Write-Fail {
    param([string]$Message)
    Write-Host "[ERROR] $Message" -ForegroundColor Red
}

# ------------------------------------------------------------
# CONFIGURACION
# ------------------------------------------------------------

$JAVA_HOME_PATH = "C:\Program Files\Java\jdk-21"
$MAVEN_HOME_PATH = "C:\apache-maven-3.9.11"

# La carpeta donde esta este script
$ROOT_PATH = $PSScriptRoot

# Proyecto Maven
$PROJECT_PATH = Join-Path $ROOT_PATH "githubaapp"

# Archivos importantes
$POM_PATH = Join-Path $PROJECT_PATH "pom.xml"
$VSCODE_PATH = Join-Path $PROJECT_PATH ".vscode"
$SETTINGS_PATH = Join-Path $VSCODE_PATH "settings.json"

# ------------------------------------------------------------
# INICIO
# ------------------------------------------------------------

Clear-Host

Write-Host "============================================================" -ForegroundColor Cyan
Write-Host "       JAVA + MAVEN + JAVAFX + VS CODE BOOTSTRAP" -ForegroundColor Cyan
Write-Host "============================================================" -ForegroundColor Cyan
Write-Host ""

# ------------------------------------------------------------
# JAVA_HOME
# ------------------------------------------------------------

Write-Step "Configurando Java 21"

if (-not (Test-Path $JAVA_HOME_PATH)) {
    Write-Fail "No se encontro Java 21 en:"
    Write-Host $JAVA_HOME_PATH
    Write-Host ""
    Write-Host "Verifica que exista:"
    Write-Host "C:\Program Files\Java\jdk-21"
    exit 1
}

$env:JAVA_HOME = $JAVA_HOME_PATH

# Agregar Java al PATH de esta sesion
if ($env:Path -notlike "*$JAVA_HOME_PATH\bin*") {
    $env:Path = "$JAVA_HOME_PATH\bin;$env:Path"
}

Write-OK "JAVA_HOME = $env:JAVA_HOME"

# ------------------------------------------------------------
# MAVEN_HOME
# ------------------------------------------------------------

Write-Step "Configurando Maven 3.9.11"

if (-not (Test-Path $MAVEN_HOME_PATH)) {
    Write-Fail "No se encontro Maven en:"
    Write-Host $MAVEN_HOME_PATH
    exit 1
}

$env:MAVEN_HOME = $MAVEN_HOME_PATH

# Agregar Maven al PATH de esta sesion
if ($env:Path -notlike "*$MAVEN_HOME_PATH\bin*") {
    $env:Path = "$MAVEN_HOME_PATH\bin;$env:Path"
}

Write-OK "MAVEN_HOME = $env:MAVEN_HOME"

# ------------------------------------------------------------
# VERIFICAR JAVA
# ------------------------------------------------------------

Write-Step "Verificando Java"

java -version

if ($LASTEXITCODE -ne 0) {
    Write-Fail "Java no funciona correctamente."
    exit 1
}

Write-OK "Java funcionando correctamente."

# ------------------------------------------------------------
# VERIFICAR MAVEN
# ------------------------------------------------------------

Write-Step "Verificando Maven"

mvn -version

if ($LASTEXITCODE -ne 0) {
    Write-Fail "Maven no funciona correctamente."
    exit 1
}

Write-OK "Maven funcionando correctamente."

# ------------------------------------------------------------
# VERIFICAR PROYECTO
# ------------------------------------------------------------

Write-Step "Buscando proyecto Maven"

if (-not (Test-Path $PROJECT_PATH)) {
    Write-Fail "No se encontro el proyecto:"
    Write-Host $PROJECT_PATH
    Write-Host ""
    Write-Host "La estructura esperada es:"
    Write-Host "$ROOT_PATH\githubaapp\pom.xml"
    exit 1
}

if (-not (Test-Path $POM_PATH)) {
    Write-Fail "No se encontro pom.xml:"
    Write-Host $POM_PATH
    exit 1
}

Write-OK "Proyecto encontrado."
Write-Host "     $PROJECT_PATH"

# ------------------------------------------------------------
# CONFIGURAR VSCODE
# ------------------------------------------------------------

Write-Step "Configurando VS Code"

if (-not (Test-Path $VSCODE_PATH)) {
    New-Item -ItemType Directory -Path $VSCODE_PATH | Out-Null
}

$settings = @'
{
    "java.jdt.ls.java.home": "C:\\Program Files\\Java\\jdk-21",
    "java.configuration.updateBuildConfiguration": "automatic",
    "java.debug.settings.onBuildFailureProceed": true,
    "java.import.maven.enabled": true,
    "java.configuration.maven.userSettings": "",
    "java.server.launchMode": "Standard"
}
'@

Set-Content `
    -Path $SETTINGS_PATH `
    -Value $settings `
    -Encoding UTF8

Write-OK "VS Code configurado."
Write-Host "     $SETTINGS_PATH"

# ------------------------------------------------------------
# VERIFICAR / CONFIGURAR POM
# ------------------------------------------------------------

Write-Step "Verificando configuracion JavaFX"

$pomContent = Get-Content $POM_PATH -Raw

if ($pomContent -notmatch "javafx-controls") {
    Write-Warn "No se encontro javafx-controls en pom.xml."
    Write-Warn "El script NO modificara automaticamente tu pom.xml."
    Write-Warn "Agrega JavaFX manualmente si corresponde."
}
else {
    Write-OK "javafx-controls encontrado."
}

if ($pomContent -notmatch "javafx-maven-plugin") {

    Write-Warn "No se encontro javafx-maven-plugin."

    Write-Host ""
    Write-Host "IMPORTANTE:" -ForegroundColor Yellow
    Write-Host "El proyecto puede compilar, pero 'mvn javafx:run' necesita"
    Write-Host "el plugin de JavaFX en el pom.xml."
    Write-Host ""

    Write-Host "Agrega dentro de <build>:" -ForegroundColor Yellow
    Write-Host ""

    Write-Host @"
<plugins>
    <plugin>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-maven-plugin</artifactId>
        <version>0.0.8</version>
        <configuration>
            <mainClass>com.hachimakidev.github.GithubApplication</mainClass>
        </configuration>
    </plugin>
</plugins>
"@

    Write-Host ""
    Write-Warn "El script continuara, pero revisa el pom.xml."
}
else {
    Write-OK "javafx-maven-plugin encontrado."
}

# ------------------------------------------------------------
# ENTRAR AL PROYECTO
# ------------------------------------------------------------

Set-Location $PROJECT_PATH

Write-Step "Compilando proyecto"

Write-Host ""
Write-Host "Ejecutando: mvn clean compile" -ForegroundColor Gray
Write-Host ""

mvn clean compile

if ($LASTEXITCODE -ne 0) {
    Write-Fail "La compilacion fallo."
    Write-Host ""
    Write-Host "El entorno esta configurado, pero el proyecto tiene errores."
    exit 1
}

Write-OK "Proyecto compilado correctamente."

# ------------------------------------------------------------
# BUSCAR CODE
# ------------------------------------------------------------

Write-Step "Buscando Visual Studio Code"

$codeCommand = Get-Command code -ErrorAction SilentlyContinue

if ($null -eq $codeCommand) {

    Write-Warn "El comando 'code' no esta disponible en PATH."

    $possibleCodePaths = @(
        "$env:LOCALAPPDATA\Programs\Microsoft VS Code\bin\code.cmd",
        "C:\Program Files\Microsoft VS Code\bin\code.cmd",
        "C:\Program Files (x86)\Microsoft VS Code\bin\code.cmd"
    )

    $codePath = $null

    foreach ($path in $possibleCodePaths) {
        if (Test-Path $path) {
            $codePath = $path
            break
        }
    }

    if ($null -ne $codePath) {
        Write-OK "VS Code encontrado:"
        Write-Host "     $codePath"

        Write-Host ""
        Write-Host "Abriendo proyecto..." -ForegroundColor Cyan

        Start-Process `
            -FilePath $codePath `
            -ArgumentList "`"$PROJECT_PATH`""

    }
    else {
        Write-Warn "No se pudo encontrar VS Code automaticamente."
        Write-Host "Abre VS Code manualmente y selecciona:"
        Write-Host $PROJECT_PATH
    }

}
else {

    Write-OK "Comando 'code' encontrado."

    Write-Host ""
    Write-Host "Abriendo proyecto en VS Code..." -ForegroundColor Cyan

    code $PROJECT_PATH
}

# ------------------------------------------------------------
# FINAL
# ------------------------------------------------------------

Write-Host ""
Write-Host "============================================================" -ForegroundColor Green
Write-Host "                    ENTORNO LISTO" -ForegroundColor Green
Write-Host "============================================================" -ForegroundColor Green
Write-Host ""

Write-Host "Java:" -ForegroundColor Yellow
Write-Host "  $JAVA_HOME_PATH"

Write-Host ""
Write-Host "Maven:" -ForegroundColor Yellow
Write-Host "  $MAVEN_HOME_PATH"

Write-Host ""
Write-Host "Proyecto:" -ForegroundColor Yellow
Write-Host "  $PROJECT_PATH"

Write-Host ""
Write-Host "Comandos disponibles:" -ForegroundColor Yellow
Write-Host ""
Write-Host "  Compilar:"
Write-Host "    mvn clean compile" -ForegroundColor White
Write-Host ""
Write-Host "  Ejecutar JavaFX:"
Write-Host "    mvn javafx:run" -ForegroundColor White
Write-Host ""

Write-Host "IMPORTANTE:" -ForegroundColor Cyan
Write-Host "Si VS Code ya estaba abierto, usa:"
Write-Host ""
Write-Host "  Ctrl + Shift + P"
Write-Host "  Java: Clean Java Language Server Workspace"
Write-Host ""
Write-Host "para que el Java Language Server vuelva a cargar Maven."
Write-Host ""

Write-Host "Listo. 🚀" -ForegroundColor Green
Write-Host ""