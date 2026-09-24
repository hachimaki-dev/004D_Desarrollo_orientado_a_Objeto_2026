import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //1. en cuanto a esceuctura y encapsulamiento java agrupa datos (atributos) y 
    // comportamientos (metodos) dentro de clases protegidas, en otros lenguajes de programacion
    //los datos se manejan por escructuras sueltas o variables globales sin proteccion

    //2. con respecto a la ejecuccion y tipado java usa tipado estatico donde los 
    //tipos de datos se verifican en tiempo de compilacion
    //En lenguajes de tipado dinamico o interpretados la verificacion ocurre en 
    //tiempo de ejecucion

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

        int cantidadDisponible = leerEnteroValido("Ingrese la cantidad de ejemplares disponibles: ");

        int numPaginas = leerEnteroValido("Ingrese el numero de paginas: ");

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

        int cantidadDisponible = leerEnteroValido("Ingrese la cantidad de ejemplares disponibles: ");

        System.out.println("Ingrese el mes de publicacion: ");
        String mesPublicacion = sc.nextLine();

        Revistas revistaNuevo = new Revistas(titulo, autor, cantidadDisponible, mesPublicacion);
        material.add(revistaNuevo);

        System.out.println("Revista registrada exitosamente");
    }

    public static void listarCatalogo(){
        if (material.isEmpty()) {
            System.out.println("el catalogo se encuentra vacio");
            return;
        }
            for (Material m : material) {
                System.out.println(" [" + m.mostraInfo() + "] ");
            }
        
            return;
    }

    public static void buscarPorTitulo(){
        if(material.isEmpty()){
            System.out.println("No hay materiales en el catalogo");
            return;
        }
            System.out.println("Ingrese el nombre del material que desea buscar: ");
            String nombreABuscar = sc.nextLine().trim().toLowerCase();

            for (Material mbusqueda : material) {
                if(mbusqueda.getTitulo().toLowerCase().contains(nombreABuscar)){
                    System.out.println("encontrado: " + mbusqueda.mostraInfo());
                }
                
                System.out.println("no se encontro ninguna cooincidencia");
                return;
            }
            return;
        
    }

    public static void prestarMaterial(){
        if(material.isEmpty()){
            System.out.println("no hay material disponible para prestar");
            return;
        }
            
        for(int i = 0; i < material.size(); i ++){
                Material m = material.get(i);
                System.out.println( "[ " + (i +1)+ " ||" + m.mostraInfo() + "]");
            }

        int indcep = leerEnteroValido("ingrese el indice del libro que se prestara: ");

        if(indcep < 1 || indcep > material.size()){
            System.out.println("invalido, intenta nuevamente");
            return;
            }

            Material mSeleccionado = material.get(indcep - 1);
            int c = leerEnteroValido("cuantos ejemplares desea prestar?: ");

            if(c < 1 || mSeleccionado.getCantidadDisponible() < c ){
                System.out.println("cantidad insuficiente");
                return;
                }else{
                    if(mSeleccionado instanceof Prestable){
                        Prestable prestable = (Prestable)mSeleccionado;
                        if(prestable.prestar(c)){
                            int totalDias = mSeleccionado.calcularDiasPrestamo();
                            System.out.println("pretamo realizado por: " + totalDias + " dias");
                        }else{
                            System.out.println("no se pudo realizar el prestamo");
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

    private static int leerEnteroValido(String mensaje){
        while (true) {
            try {
                System.out.println(mensaje + "");
                int valor = Integer.parseInt(sc.nextLine());

                if(valor <= 0){
                    System.out.println("Error: valor invalido");
                    continue;
                }
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("error con el tipo de dato, intente nuevamente");
            }
            
        }
    }
}
