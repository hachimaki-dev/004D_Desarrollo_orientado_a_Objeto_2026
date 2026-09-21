import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean Menu = true;
        ComentarioParadigma();

        while (Menu){
        mostrarMenu();
        String opcionUser = input.nextLine();
        switch (opcionUser) {
            case "1":
                registrarMaterial();
                break;
            case "2":
                System.out.println("Función para listar catalogo pendiente");
                break;
            case "3":
                System.out.println("Función para buscar material por titulo pendiente");
                break;
            case "4":
                System.out.println("Función para prestar material pendiente");
                break;
            case "5":
                System.out.println("Función para resumir catalogo pendiente");
                break;
            case "6":
                boolean Cierre = false;
                Menu = Cierre;
                System.out.println("Programa finalizado"); 
                break;
            case "wwssadadbastart":
                System.out.println("Función para registrar material pendiente");
                break;
            default:
                System.out.println("Opción no valida, intente nuevamente");
                break;
        }
        }
input.close();}
    
    static void ComentarioParadigma(){
        System.out.println("El paradigma utilizado en este programa es conocido como POO(Programación Orientada a Objetos) paradigma el cual siendo explicativo por su nombre, es un programa que busca replicar un algo/alguien de la vida real, explicando en codigo cuales son sus caracteristicas(Atributos) y comportamientos(Metodos).");
        System.out.println("Las principales diferencias serian las siguientes: \n\nDiferencia 1 \n-En Python todo el codigo de ejecutaba de forma lineal(Arriba hacia Abajo), por lo que de cierto modo, el programa tenía un fin ya establecido \n-En Java, el programa funciona mediante bloques de codigo que pueden ser reutilizados las veces que se necesiten. \n\nDiferencia 2 \n-En Python se tiene entendido que el codigo puede funcionar gracias a un interprete para que la computadora pueda leerlo. \n-En Java, el codigo al momento de que queramos que funcione este se debe compilar, en otras palabras, se debe transformar al lenguaje de las computadoras, por lo que el codigo será convertido a 0 y 1, dado de este modo, el codigo NO puede tener errores debido a que si una cosa está mal, impedirá que se ejecute");
    }

    static void mostrarMenu(){
        System.out.println("\n\n==== BIBLIOTECA REGIONAL====");
        System.out.println("1. Registrar material");
        System.out.println("2. Listar catalogo");
        System.out.println("3. Buscar material por título");
        System.out.println("4. Prestar material");
        System.out.println("5. Resumen del catálogo");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    static void registrarMaterial(){
        System.out.println("--- Tipo de material ---");
        System.out.print("1. Libro \n2. Revista \nSeleccione: ");
        String tipoMaterial = input.nextLine();
        if (tipoMaterial.equals("1")){
            System.out.println("");
        }
        else if (tipoMaterial.equals("2")){

        }
        else{
            System.out.println("Error, intente nuevamente");
        }
        
    }

}
