package src;

import java.util.ArrayList;
import java.util.Scanner;

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

                    mostrarCatalogo();

                    break;

                case 3:

                    buscarMaterial();

                    break;

                case 4:

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

    public static int menuPrincipal()
    {
        int respuestaMenu;

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
                return respuestaMenu = Integer.parseInt(scanner.nextLine());
            }
            catch (Exception e)
            {
                System.out.println("La respuesta introducida es invalida. Intentalo de nuevo.");
            }

        }
    }

    public static int registroMaterial()
    {   

        int respuestaRegistro;

        while (true)
        { 

            System.out.println("Registro de materiales: ");

            System.out.println("1.- Libro ");

            System.out.println("2.- Revistas ");

            System.out.println("Introduce una respuesta (número):");

            try
            {   
               return respuestaRegistro = Integer.parseInt(scanner.nextLine());
            }
            catch (Exception e)
            {
                System.out.println("La respuesta es invalida. Intentalo de nuevo.");
            }      
        }

    }
                
                public static void registroLibro()
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

                public static void registroRevista()
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
    
    public static void mostrarCatalogo()
    {
        for (int i = 0; i < registroMateriales.size(); i++)
        {   
            try
            {
                System.out.println(registroMateriales.get(i).mostrarInfo());
            }
            catch (IndexOutOfBoundsException e)
            {
                System.out.println("Actualmente no tienes materiales registrados.");
            }
        } 
    }

    public static void buscarMaterial()
    {   
        String busqueda;

        boolean bandera=false;
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
    }

    public static void resumenCatalogo()
    {   
        
        int totalLibros=0;

        int totalRevistas=0;

        int cantidadEjemplares=0;

        System.out.println("La cantidad de materiales disponibles son: " + registroMateriales.size());

        for (int i = 0; i < registroMateriales.size(); i++)
        {

            if (registroMateriales.get(i) instanceof Libro)
            {
                totalLibros += 1;
            }
            else if (registroMateriales.get(i) instanceof Libro)
            {
                totalRevistas += 1;
            }

            cantidadEjemplares += registroMateriales.get(i).getCantidadDisponible();
        }
        System.out.println("El total de libros es: " + totalLibros);

        System.out.println("El total de revistas es: " + totalRevistas);

        System.out.println("La cantidad total de ejemplares es: " + cantidadEjemplares);

    }

    public static boolean salir()
    {   
        int respuestaSalir;

        while (true)
        {

            System.out.println("¿Estas seguro que quieres salir?");

            System.out.println("1- Si");

            System.out.println("2- No");

            System.out.println("Introduce un número: ");

            try
            {   

                respuestaSalir = Integer.parseInt(scanner.nextLine());

                switch (respuestaSalir) 
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

