// Ahora mismo se esta programdo con java que a diferencia de python aca trabajamos dandole mas caracteristicas al "objeto"
// lo que diferencia java de python son artas cosas entre estas encontramos que a la hora de difinir una variable en java especificamos el tipo de dato del cual va haccer la variable
// mientas que en python es mas facil porque solo si es un string el valor de esa variable va entre comillas "" , y si es un entero o boolean se escribe el valor sin mas 
// Otra mas seria que a diferencia de python , java te permite manejar tus variables  con mas privacidad (private , public , protected ) , en cambio python es mas de "todos somos iguales"
// Hablando claramente de lo que seria la privacidad 

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    

    public static void main(String[] args) {
        mostrar_menu() ;
    }


    static  ArrayList<Libro> inventario_libros = new ArrayList<>() ;

    static  ArrayList<Revista> inventario_revistas = new ArrayList<>() ;

    static  ArrayList<Material> inventario_cnjunto = new ArrayList<>() ;


    static  Scanner sc = new Scanner(System.in) ;

    static  void mostrar_menu(){
        boolean while_activo = true ;
    
        while (while_activo) {
            System.out.println("=== BIBLIOTECA MUNICIPAL ===");
            System.out.println("1. Registrar material");
            System.out.println("2. Listar catalogo");
            System.out.println("3. Buscar material por titulo");
            System.out.println("4. Prestar material");
            System.out.println("5. Resumen del catalogo");
            System.out.println("6. Salir");
            
            
            int opcion_elegida = 0 ;
            while (true) {
                try {
                   System.out.println("Seleccione una opcion: ");
                    opcion_elegida = Integer.parseInt(sc.nextLine()) ;

                    if (opcion_elegida == 1 || opcion_elegida == 2 || opcion_elegida == 3 || opcion_elegida == 4 || opcion_elegida == 5 || opcion_elegida == 6) {
                        break ;
                    }else{
                        System.out.println("ingrese una opcion valida ");
                    }    
                } catch (NumberFormatException e) {
                    System.out.println("Ingrese una de las opciones aparecidas en el menu ");
                }
                
            }
            
            switch (opcion_elegida) {
                case 1:
                    registrar_material();
                    break;
                case 2:
                    listar_catalogo();
                    break;
                case 3:
                    buscar_material();
                    break;
                case 4:
                    prestar_material();
                    break;
                case 5:
                    resumen_catalogo();
                    break;
                case 6:
                    while_activo = false ;
                    break;
                default:
                    break;
            }

        }
    
    }



    static  void registrar_material(){
        boolean  mostrar_menu = true;

        while (mostrar_menu) {
            System.out.println("===== Procedimiento de Registro =====");
            System.out.println("1. Libro");
            System.out.println("2. Revista");
            System.out.println("3. SALIR");
        
            int opcion_elegida = 0 ;

                try {
                   System.out.println("Seleccione una opcion: ");
                    opcion_elegida = Integer.parseInt(sc.nextLine()) ;

                    switch (opcion_elegida) {
                    case 1:
                        registrar_libro();
                        break;
                    case 2 :
                        registrar_revista(); 
                        break ;
                    case 3 :
                        mostrar_menu = false ;
                        break ;
                    default:
                        break;
                    }                       
                } catch (NumberFormatException e) {
                    System.out.println("Ingrese una de las opciones aparecidas en el menu ");
                }
            
        }
    }



    static void registrar_libro (){

        System.out.println("===== Registro de libro =====");
        
        System.out.println("Titulo del libro :");
        String titulo = sc.nextLine().toLowerCase() ;

        System.out.println("Autor del libro :");
        String autor = sc.nextLine().toLowerCase() ;

        int cantidad_disponible = 0 ;
        while (true) {
            try {
                System.out.println("cantidad disponible :");
                cantidad_disponible = Integer.parseInt(sc.nextLine()) ;
            
                if (cantidad_disponible < 0) {
                    System.out.println("ingrese una cantidad mayor a 0");
                }
                else{
                    break ;
                }
            } catch (NumberFormatException e) {
                System.out.println("ingrese una opcion valida");
            }
        }


        int numero_d_paginas = 0 ;
        while (true) {
            try {
                System.out.println("Numero de paginas del libro :");
                numero_d_paginas = Integer.parseInt(sc.nextLine()) ;
            
                if (numero_d_paginas <= 0) {
                    System.out.println("ingrese una cantidad de paginas valida ");
                }
                else{
                    break ;
                }
            } catch (NumberFormatException e) {
                System.out.println("ingrese una opcion valida");
            }
        }

        

        Libro libro_agregado = new Libro(titulo, autor, cantidad_disponible, numero_d_paginas) ;

        inventario_libros.add(libro_agregado) ;
        inventario_cnjunto.add(libro_agregado) ;





    }


    static  void registrar_revista(){
        System.out.println("===== Registro de Revista =====");
        
        System.out.println("Titulo  de la revista :");
        String titulo = sc.nextLine().toLowerCase() ;

        System.out.println("Autor de la revista :");
        String autor = sc.nextLine().toLowerCase() ;

        int cantidad_disponible = 0 ;
        while (true) {
            try {
                System.out.println("cantidad disponible :");
                cantidad_disponible = Integer.parseInt(sc.nextLine()) ;
            
                if (cantidad_disponible < 0) {
                    System.out.println("ingrese una cantidad mayor a 0");
                }
                else{
                    break ;
                }
            } catch (NumberFormatException e) {
                System.out.println("ingrese una opcion valida");
            }
        }

        System.out.println("Mes de publicacion  de la revista :");
        String mes_publicacion = sc.nextLine().toLowerCase() ;
        
        Revista revista_agregada = new Revista(titulo, autor, cantidad_disponible, mes_publicacion);

        inventario_cnjunto.add(revista_agregada) ;
        inventario_revistas.add(revista_agregada);


    }


    static void listar_catalogo(){
        if (inventario_cnjunto.isEmpty()) {
            System.out.println("No hay ningun libro ni revista agregado todavia !");
        }else {
            System.out.println("");
            System.out.println("==== Libros Registrados ===");

            for (Libro libro : inventario_libros) {
                System.out.println(libro.mostrarinfo());
                
            }
            
            System.out.println("");

            System.out.println("==== Revistaa Registradas ===");

            for (Revista revista : inventario_revistas) {
                System.out.println(revista.mostrarinfo());
            }

            System.out.println("");


        }
    }

    static void buscar_material(){
        if (inventario_cnjunto.isEmpty()) {
            System.out.println("No hay nada resgistrado todavia , porvafor registre algo antes de buscar ");
        }else{
            System.out.println("Ingrese el Titulo del libro o revista que esta buscando :");
            String buscar = sc.nextLine().toLowerCase() ;

            boolean bandera = false ;

            for (Material encontrado : inventario_cnjunto) {
                if (encontrado.gettitulo().contains(buscar)) {
                    System.out.println(encontrado.mostrarinfo());
                    bandera = true ;
                }
            }

            if (!bandera) {
                System.out.println("No se encontraron resultados de la  busqueda : "+ buscar  );
            }
        }
        

    }




    static  void prestar_material(){
        if (inventario_cnjunto.isEmpty()) {
            System.out.println("No hay nada registrado en este moento ");
        }else{;

            System.out.println("=== LIbros y Revistas Disponibles ===");
            int contador = 0 ;
            for (Material material : inventario_cnjunto) {
                System.out.println( (contador + 1) + ")" + material.mostrarinfo());
                contador ++;
            }
            
            while (true) {
                System.out.println("Ingrese el indice : ");
                int indice = Integer.parseInt(sc.nextLine());
                int indice_guardado = indice ;

                if (indice_guardado <= 0 ) {
                    System.out.println("Ingrese un indice valido ");
                }else if (inventario_cnjunto.get(indice_guardado).getcantidad_disponible() <= 0) {
                    System.out.println("Ingrese un Material cn la cantidad disponible mayor a 0");
                }else{

                    int descuenta = inventario_cnjunto.get(indice_guardado).getcantidad_disponible() - 1 ;
                    inventario_cnjunto.get(indice_guardado).setcantidad_disponible(descuenta);

                    int calculo = inventario_cnjunto.get(indice_guardado).calcularDiasPrestamo() ;


                    System.out.println("=== Comprobante ===");
                    System.out.println("Titulo :" + inventario_cnjunto.get(indice_guardado).gettitulo());
                    System.out.println("Dias de Prestamo :" + calculo);
                    System.out.println("Cantidad disponible restante : " + inventario_cnjunto.get(indice_guardado).getcantidad_disponible());
                    


                }
            
            }
            
      
        }
   
    }

    static  void resumen_catalogo(){
        if (inventario_cnjunto.isEmpty()) {
            System.out.println("No hay nada registrado");
        }else{

            int cantidad_total  = inventario_cnjunto.size() ;
            int cantidad_libros = 0 ;
            int cantidad_revistas  = 0 ;
            int total_ejemplares  = 0 ;


            for (Material material : inventario_cnjunto) {
                if (material instanceof Libro) {
                    cantidad_libros += 1 ;
                }else{
                    cantidad_revistas += 1 ;
                }

                total_ejemplares += material.getcantidad_disponible() ;


            }

            System.out.println("===== RESUMEN CATALOGO =====");
            System.out.println("Cantidad total : " + cantidad_total);
            System.out.println("Cantidad de libros : " + cantidad_libros);
            System.out.println("Cantidad de revistas : " + cantidad_revistas);
            System.out.println("Total de ejemplares " + total_ejemplares);
            System.out.println("");
        }
    }
}
