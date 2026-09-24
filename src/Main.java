import java.util.Scanner;
import java.util.ArrayList;

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
                listarCatalogo();
                break;
            case "3":
                buscarMaterialTitulo();
                break;
            case "4":
                prestarMaterial();
                break;
            case "5":
                resumirCatalogo();
                break;
            case "6":
                boolean Cierre = false;
                Menu = Cierre;
                System.out.println("shao"); 
                break;
            case "wwssadadbastart":
                System.out.println("Easter egg que ni me dio tiempo a terminar XD");
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
        System.out.println("\n\n==== BIBLIOTECA MUNICIPAL con alzheimer====");
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
        switch (tipoMaterial) {
            case "1":
                System.out.print("Titulo: ");
                String tituloIngresadolibro = input.nextLine();
                System.out.print("Autor: ");
                String autorIngresadolibro = input.nextLine();
                System.out.print("Cantidad disponible: ");
                int cantidadIngresadalibro = Integer.parseInt(input.nextLine());
                System.out.print("Numero de paginas: ");
                int numeropaginasIngresadaslibro = Integer.parseInt(input.nextLine());
                
                
                System.out.println("Hecho");
                break;
            case "2":
                System.out.print("Titulo: ");
                String tituloIngresadorevista = input.nextLine();
                System.out.print("Autor: ");
                String autorIngresadorevista = input.nextLine();
                System.out.print("Cantidad disponible: ");
                int cantidadIngresadarevista = Integer.parseInt(input.nextLine());
                System.out.print("Mes de publicación: ");
                String mesingresadorevista = input.nextLine();
                

                System.out.println("Hecho");
                break;
        
            default:
                System.out.println("Error: Intente nuevamente");
                break;
        }
        
    }

    static void listarCatalogo(){
        System.out.println("--- CATALOGO ---");
    }

    static void buscarMaterialTitulo(){
        System.out.print("Ingrese el texto a buscar: ");
        String busquedaMaterial = input.nextLine().toLowerCase();
        System.out.println("No hay sistema x_x");
    }

    static void prestarMaterial(){
        System.out.print("Ingrese el nombre del material: ");
        String nombreMaterialprestamo = input.nextLine();
        System.out.println("No hay sistema x_x");
    }

    static void resumirCatalogo(){
        System.out.println("¿Que catalogo?");
    }
}
