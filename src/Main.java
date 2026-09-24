package src;

import java.util.ArrayList;
import java.util.Scanner;
/* --Paradigmas-- */

/* R1: */
/* El paradigma en relación a la creación de objetos.
   Se completamente en el concepto de clase, y objetos que se crean a partir de esta.
   Los objetos tienen atributos y actitudes especiales, que se acceden de forma facil y se pueden definir dentro de un recuadro distinto.
   Gracias a esto, permite una estructuración más completa y mejor distribuida.
   Todo el sistema completo en java se basa en clases, y todo funciona dentro de clases, las cuales a su vez, le puedes poner restricciones.
*/
/*R2: */
/* Una diferencia crucial entre Java y Python es la forma en la que se compila el programa, mientras que python lo hace en el momento de ejecución, 
   Java se compila antes de iniciar el programa, esto no solo permite que los programas sean más rapido en el momento, permite detectar errores, porque Java no inicia si existe algun error.

    Otra diferencia es la forma en la que se guardan los datos, las clases permiten crear estructuras independiente de las cuales se encuentran separadas del sistema principal, se le pueden definir atributos, comportamientos, etc.
    Se le pueden poner todas las restricciones que uno quiera, mucho más beneficioso que diseñar el programa completo en Python solo con funciones, listas y diccionarios.
*/
public class Main
{   

    public static ArrayList<Material> registroMateriales = new ArrayList<>();

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) 
    {   
        Sistema_principal:
        while (true) 
        { 
            switch (menuPrincipal()) 
            {
                case 1:
                    
                    caso_1:

                    while (true) 
                    { 

                        switch (registroMaterial()) 
                        {
                            case 1:
                                
                                registroLibro();

                                break caso_1;

                            case 2:

                                registroRevista();

                                break caso_1;

                            default:
                                
                                System.out.println("El número introducido no se encuentra en el menu. Intentalo de nuevo.");
                        } 

                    }

                    break;

                case 2:

                    if (mostrarCatalogo() == false)
                    {
                        System.out.println("No tienes materiales registrados.");
                    }

                    break;

                case 3:

                    if (buscarMaterial() == false)
                    {
                        System.out.println("No tienes materiales registrados actualmente.");
                    }

                    break;

                case 4:

                    if (prestamo() == false)
                    {   
                        System.out.println("No tienes materiales actualmente registrados.");
                    }

                    break;
                
                case 5:

                    resumenCatalogo();

                    break;

                case 6:

                    if (salir())
                    {
                        break Sistema_principal;
                    }

                    break;

                default:
                    
                    System.out.println("El número introducido se tiene que encontrar en el menu. Intentalo de nuevo.");
            }
        } 
    }

    public static int menuPrincipal() /*Completado */
    {

        while (true)
        {
            System.out.println("= BIBLIOTECA MUNICIPAL =");

            System.out.println("1. Registrar material");

            System.out.println("2. Listar catalogo");

            System.out.println("3. Buscar material por titulo");

            System.out.println("4. Prestar material");

            System.out.println("5. Resumen del catalogo");

            System.out.println("6. Salir");

            System.out.println("Seleccione una opcion");

            try
            {
                return Integer.parseInt(scanner.nextLine());
            }
            catch (Exception e)
            {
                System.out.println("La respuesta introducida es invalida. Intentalo de nuevo.");
            }

        }
    }

    public static int registroMaterial() /*Completado */
    {   

        while (true)
        { 

            System.out.println("Registro de materiales: ");

            System.out.println("1.- Libro ");

            System.out.println("2.- Revistas ");

            System.out.println("Introduce una respuesta (número):");

            try
            {   
               return Integer.parseInt(scanner.nextLine());
            }
            catch (Exception e)
            {
                System.out.println("La respuesta es invalida. Intentalo de nuevo.");
            }      
        }

    }
                
                public static void registroLibro()  /*Completado */
                {

                    String tituloLibro;

                    String nombreAutor;

                    int cantidadDisponible;

                    int numPaginas;

                    System.out.println("Introduce el titulo del libro: ");

                    tituloLibro = scanner.nextLine();

                    System.out.println("Introduce el autor del libro: ");

                    nombreAutor = scanner.nextLine();

                    System.out.println("Introduce la cantidad disponibles del libro: ");

                    while (true)
                    {
                        try
                        {
                            cantidadDisponible = Integer.parseInt(scanner.nextLine());

                            break;
                        }
                        catch (Exception e)
                        {
                            System.out.println("La cantidad introducida no es un valor valido. Intentalo de nuevo.");
                        }
                    }

                    System.out.println("Introduce el número de paginas del libro: ");

                    while (true)
                    {
                        try
                        {
                            numPaginas = Integer.parseInt(scanner.nextLine());

                            break;
                        }
                        catch (Exception e)
                        {
                            System.out.println("La cantidad introducida no es un valor valido. Intentalo de nuevo.");
                        }
                    }
                
                    Libro libro = new Libro(tituloLibro, nombreAutor, cantidadDisponible, numPaginas);
                    
                    registroMateriales.add(libro);

                    System.out.println("El libro a sido registrado con exito!!");

                }

                public static void registroRevista()    /*Completado */
                {

                    String tituloLibro;

                    String nombreAutor;

                    int cantidadDisponible;

                    String mesPublicacion;

                    System.out.println("Introduce el titulo de la revista: ");

                    tituloLibro = scanner.nextLine();

                    System.out.println("Introduce el autor de la revista: ");

                    nombreAutor = scanner.nextLine();

                    System.out.println("Introduce la cantidad de ejemplares de la revista: : ");

                    while (true)
                    {
                        try
                        {
                            cantidadDisponible = Integer.parseInt(scanner.nextLine());

                            break;
                        }
                        catch (Exception e)
                        {
                            System.out.println("La cantidad introducida no es un valor valido. Intentalo de nuevo.");
                        }
                    }

                    System.out.println("Introduce el mes de la publicación de la revista: ");
                    
                    mesPublicacion = scanner.nextLine();

                    Revista revista = new Revista(tituloLibro, nombreAutor, cantidadDisponible, mesPublicacion);
                    
                    registroMateriales.add(revista);

                    System.out.println("La revista fue registrada con exito!!");
                    
                }
    
    public static boolean mostrarCatalogo() /*Completado */
    {   
        if (registroMateriales.isEmpty())
        {
            return false;
        }

        for (int i = 0; i < registroMateriales.size(); i++)
        {   
            System.out.println(registroMateriales.get(i).mostrarInfo());
        } 

        return true;
    }

    public static boolean buscarMaterial()  /*Completado */
    {   
        String busqueda;

        boolean bandera = false;

        if (registroMateriales.isEmpty())
        {
            return false;
        }

        System.out.println("Introduce el nombre del material: ");

        busqueda = scanner.nextLine();

        System.out.println("Materiales encontrados: ");

        for (int i = 0; i < registroMateriales.size(); i++)
        {
            if (registroMateriales.get(i).getTitulo().toLowerCase().contains(busqueda.toLowerCase()))
            {   
                bandera = true;

                System.out.println(registroMateriales.get(i).mostrarInfo());
            }
        }

        if (bandera == false)
        {
            System.out.println("No se a encontrado materiales.");
        }

        return true;
    }

    public static boolean prestamo() /*Completado */
    {   
        int respuesta;

        boolean bandera = false;

        if (registroMateriales.isEmpty())
        {   
            return false;
        }

        System.out.println("Listado de materiales: ");

        for (int i = 0; i < registroMateriales.size(); i ++)
        {
            System.out.println((i + 1) + ". " + registroMateriales.get(i).getTitulo());
        }
        System.out.println("¿Cual es el indice del material que quieres prestar?");

        while (true)
        {
            try
            {
                respuesta = Integer.parseInt(scanner.nextLine());

                if (respuesta <= 0)
                {
                    System.out.println("El indice es invalido. Tiene que ser un mayor a 0.");
                }
                else
                {
                    break;
                }
            }
            catch (Exception e)
            {
                System.out.println("Respuesta invalida");
            }
        }
        
        for (int i = 0; i < registroMateriales.size(); i++)
        {
            if (i == (respuesta - 1))
            {
                if (registroMateriales.get(i).getCantidadDisponible() > 0)
                {
                    registroMateriales.get(i).setCantidadDisponible(registroMateriales.get(i).getCantidadDisponible() - 1);

                    System.out.println("Titulo: " + registroMateriales.get(i).getTitulo() + " | Dias de prestamos: " + registroMateriales.get(i).calcularDiasPrestamos() + " | Ejemplares restantes: " + registroMateriales.get(i).getCantidadDisponible());
                }
                else
                {
                    System.out.println("El material que intentas prestar no tiene stock.");
                }

                bandera = true;
            }
        }

        if (bandera == false)
        {
            System.out.println("El indice que buscaste, actualmente no se encuentra registrado.");
        }

        return true;
    }
    
    public static void resumenCatalogo() /*Completado */
    {   

        int totalLibros = 0;

        int totalRevistas = 0;

        int cantidadEjemplares = 0;

        System.out.println("La cantidad de materiales disponibles son: " + registroMateriales.size());

        for (int i = 0; i < registroMateriales.size(); i++)
        {

            if (registroMateriales.get(i) instanceof Libro)
            {
                totalLibros += 1;
            }
            else if (registroMateriales.get(i) instanceof Revista)
            {
                totalRevistas += 1;
            }

            cantidadEjemplares += registroMateriales.get(i).getCantidadDisponible();
        }
        System.out.println("El total de libros es: " + totalLibros);

        System.out.println("El total de revistas es: " + totalRevistas);

        System.out.println("La cantidad total de ejemplares es: " + cantidadEjemplares);

    }

    public static boolean salir() /*Completado */
    {   

        while (true)
        {

            System.out.println("¿Estas seguro que quieres salir?");

            System.out.println("1- Si");

            System.out.println("2- No");

            System.out.println("Introduce un número: ");

            try
            {   

                switch (Integer.parseInt(scanner.nextLine())) 
                {
                    case 1:
                        
                        return true;

                    case 2:

                        return false;
                        
                    default:
                        
                        System.out.println("El número introducido no se encuentra en el menu. Intentalo de nuevo.");
                }
            }
            catch (Exception e)
            {
                System.out.println("La respuesta es invalida. Intentalo de nuevo.");
            }
        }

        
    }

}

