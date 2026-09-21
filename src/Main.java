import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //1. El progrmama usa poo, organiza clases que represetan
    //entidades y comportamientos con atributos y metodos

    //2. la organicaion es diferente en cuanto a java y python ya que 
    //en python es regla tabular, en java es importante que los metodos solo 
    //esten entre llaves {}

    // otra diferencia fundamental es que java organiza el codigo en objetos
    // que combinan datos y comportamientos mutables y 
    //python se centra en trasformar datos por funciones puras sin cambiar estados,osea inmutable 

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Material> material = new ArrayList<>();

    public static void main(String[] args) {
        MostrarMenu();
    }

    public static void MostrarMenu(){
        boolean menuActivo = true;

        while (menuActivo) {
            System.out.println(" === BIBLIOTECA MUNUCIPAL === ");
            System.out.println("");
            System.out.println("1. Registrar Material");
            System.out.println("2. Listar Catalogo ");
            System.out.println("3. Buscar Material por Tiulo");
            System.out.println("4. Prestar material");
            System.out.println("5. Resuemen del catalogo");
            System.out.println("6. Salir");
            System.out.println("");
            System.out.println("Seleccione una de las opciones: ");
            System.out.println("");

             String opcionMenu = sc.nextLine();

             switch (opcionMenu) {
                case "1":
                    resgistrarMaterial();
                    break;
                case "2":
                    listarCatalogo();
                    break;
                case "3":
                    buscarPorTitulo();
                    break;
                case "4":
                    prestarMaterial();
                    break;
                case "5":
                    resumenDeCatalogo();
                    break;
                case "6":
                    System.out.println("Bye bye have a nice day!!");
                    menuActivo = false;
                    break;
                default:
                    System.out.println("opcion Ingresada invalida intenta nuevamente");
                    break;
             }
           
        }
    }

    public static void resgistrarMaterial(){
        boolean subMenuActivo = true;

        while (subMenuActivo) {
            System.out.println(" === Elige el tipo de material a registrar === ");
            System.out.println("");
            System.out.println("1. Libro");
            System.out.println("2. Revista");
            System.out.println("3. Salir");
            System.out.println("");
            System.out.println("Ingrese una de las opciones: ");
            System.out.println("");

            String opcionSubMenu = sc.nextLine();

            switch (opcionSubMenu) {
                case "1":
                    registrarLibro();
                    break;
                case "2":
                    registrarRevista();
                    break;
                case "3":
                    System.out.println("volviendo al menu principal.....");
                    subMenuActivo = false;
                    break;
                default:
                    System.out.println("La opcion ingresada es invalida");
                    break;
            }
        }
    }

    public static void registrarLibro(){
        System.out.println("Registrando libro...");
        System.out.println("Ingrese el titulo: ");
        String titulo = sc.nextLine();

        System.out.println("Ingrese el nombre del autor: ");
        String autor = sc.nextLine();

        System.out.println("Ingrese la cantidad de ejemplares disponibles: ");
        int cantidadDisponible = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese el numero de paginas: ");
        int numPaginas = Integer.parseInt(sc.nextLine());

        Libros libroNuevo = new Libros(titulo, autor, cantidadDisponible, numPaginas);
        material.add(libroNuevo);

        System.out.println("Libro agregado exitosamente");
    }

    public static void registrarRevista(){
        System.out.println("Registrando Revista...");
        System.out.println("Ingrese el titulo: ");
        String titulo = sc.nextLine();

        System.out.println("Ingrese el nombre del autor: ");
        String autor = sc.nextLine();

        System.out.println("Ingrese la cantidad de ejemplares disponibles: ");
        int cantidadDisponible = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese el mes de publicacion: ");
        String mesPublicacion = sc.nextLine();

        Revistas revistaNuevo = new Revistas(titulo, autor, cantidadDisponible, mesPublicacion);
        material.add(revistaNuevo);
    }

    public static void listarCatalogo(){
        if (material.isEmpty()) {
            System.out.println("el catalogo se encuentra vacio");
            return;
        }else{
            for (Material m : material) {
                System.out.println(" [" + m.mostraInfo() + "] ");
            }
        }
        return;
    }

    public static void buscarPorTitulo(){
        if(material.isEmpty()){
            System.out.println("No hay materiales en el catalogo");
            return;
        }else{
            System.out.println("Ingrese el nombre del material que desea buscar: ");
            String nombreABuscar = sc.nextLine().trim().toLowerCase();

            for (Material mbusqueda : material) {
                if(mbusqueda.getTitulo().toLowerCase().contains(nombreABuscar)){
                    System.out.println("encontrado: " + mbusqueda.mostraInfo());
                }else{
                    System.out.println("no se encontro ninguna cooincidencia");
                }
            }
            return;
        }
    }

    public static void prestarMaterial(){
        if(material.isEmpty()){
            System.out.println("no hay material disponible para prestar");
        }else{
            for(int i = 0; i < material.size(); i ++){
                Material m = material.get(i);
                System.out.println( "[" + (i +1) + m.mostraInfo() + "]");
            }
            System.out.println("ingrese el indice del libro que se prestara: ");
            int indcep = Integer.parseInt(sc.nextLine());

            if(indcep < 1 || indcep > material.size()){
                System.out.println("invalido, intenta nuevamente");
            }else{
                Material mSeleccionado = material.get(indcep - 1);
                System.out.println("cuantos ejemplares desea prestar?");
                int c = Integer.parseInt(sc.nextLine());

                if(c < 1 || mSeleccionado.getCantidadDisponible() < c ){
                    System.out.println("cantidad insuficiente");
                }else{
                    mSeleccionado.setCantidadDisponible(mSeleccionado.getCantidadDisponible() - c);
                    int totalPrestamo = mSeleccionado.calcularDiasPrestamo() * c;
                    System.out.println("prestamo realizado con exito" + totalPrestamo);
                }
            }
        }
    }

    public static void resumenDeCatalogo(){
        int totalLibros = 0;
        int totalRevistas = 0;
        int Total = 0;

        for (Material material2 : material) {
            if(material2 instanceof Libros){
                totalLibros ++;
            }else{
                totalRevistas ++;
            }
        }

        Total = totalLibros + totalRevistas;
        System.out.println("libros: " + totalLibros);
        System.out.println("Revistas: " + totalRevistas);
        System.out.println("En total hay: "+ Total);
    }
}
