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
            System.out.println("1. Libro");
            System.out.println("2. Revista");
            System.out.println("3. SALIR");
        
            int opcion_elegida = 0 ;
            while (true) {
                try {
                   System.out.println("Seleccione una opcion: ");
                    opcion_elegida = Integer.parseInt(sc.nextLine()) ;

                    if (opcion_elegida == 1 || opcion_elegida == 2 || opcion_elegida == 3 ) {
                        break ;
                    }else{
                        System.out.println("ingrese una opcion valida ");
                    }    
                } catch (NumberFormatException e) {
                    System.out.println("Ingrese una de las opciones aparecidas en el menu ");
                }
        
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
            
            
            }
        
        
        
        
        }
    }


    static void registrar_libro (){

        System.out.println("===== Registro de libro =====");
        
        System.out.println("Titulo del libro :");
        String titulo = sc.nextLine().toLowerCase() ;

        System.out.println("Autor del libro :");
        String autor = sc.nextLine() ;

        System.out.println("cantidad disponible :");
        int cantidad_disponible = Integer.parseInt(sc.nextLine()) ;

        System.out.println("Numero de paginas del libro :");
        int numero_d_paginas = Integer.parseInt(sc.nextLine()) ;

        Libro libro_agregado = new Libro(titulo, autor, cantidad_disponible, numero_d_paginas) ;

        inventario_libros.add(libro_agregado) ;
        inventario_cnjunto.add(libro_agregado) ;





    }


    static  void registrar_revista(){
        System.out.println("===== Registro de Revista =====");
        
        System.out.println("Titulo del de la revista :");
        String titulo = sc.nextLine().toLowerCase() ;

        System.out.println("Autor de la revista :");
        String autor = sc.nextLine() ;

        System.out.println("cantidad disponible :");
        int cantidad_disponible = Integer.parseInt(sc.nextLine()) ;

        System.out.println("Mes de publicacion  de la revista :");
        String mes_publicacion = sc.nextLine() ;
        
        Revista revista_agregada = new Revista(titulo, autor, cantidad_disponible, mes_publicacion);

        inventario_cnjunto.add(revista_agregada) ;
        inventario_revistas.add(revista_agregada);


    }


    static void listar_catalogo(){
        if (inventario_cnjunto.isEmpty()) {
            System.out.println("No hay ningun libro ni revista agregado todavia !");
        }else {
            System.out.println("==== Libros Registrados ===");

            for (Libro libro : inventario_libros) {
                System.out.println(libro.mostrarinfo());
                
            }
            
            System.out.println("==== Revistaa Registradas ===");

            for (Revista revista : inventario_revistas) {
                System.out.println(revista.mostrarinfo());
            }



        }
    }

    static void buscar_material(){
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




    static  void prestar_material(){
        if (inventario_cnjunto.isEmpty()) {
            System.out.println("No hay nada registrado en este moento ");
        }else{;

            System.out.println("=== LIbros y Revistas Disponibles ===");
            int contador = 0 ;
            for (Material material : inventario_cnjunto) {
                System.out.println( (contador + 1)+ material.mostrarinfo());
            }
            
            while (true) {
                System.out.println("Ingrese el indice : ");
                int indice = Integer.parseInt(sc.nextLine());

                if (indice <= 0 ) {
                    System.out.println("Ingrese un indice valido ");

                }else if (inventario_libros.get(indice).getcantidad_disponible() <= 0) {
                    System.out.println("Ingrese un Material cn la cantidad disponible mayor a 0");
                }else{

                    int descuenta = inventario_cnjunto.get(indice).getcantidad_disponible() - 1 ;
                    inventario_cnjunto.get(indice).setcantidad_disponible(descuenta);

                    int calculo = inventario_cnjunto.get(indice).calcularDiasPrestamo() ;


                    System.out.println("=== Comprobante ===");
                    System.out.println("Titulo :" + inventario_cnjunto.get(indice).gettitulo());
                    System.out.println("Dias de Prestamo :" + calculo);
                    System.out.println("Cantidad disponible restante : " + inventario_cnjunto.get(indice).getcantidad_disponible());
                    


                }
            
            }
            
      
        }
   
    }

    static  void resumen_catalogo(){
        if (inventario_cnjunto.isEmpty()) {
            System.out.println("No hay nada registrado");
        }else{

            int cantidad_total  = 0 ;
            int cantidad_libros = 0 ;
            int cantidad_revistas  = 0 ;
            int total_ejemplares  = 0 ;


            for (Material material : inventario_cnjunto) {
                if (material instanceof inventario_cnjunto) {
                    cantidad_libros += 1 ;
                    cantidad_revistas += 1 ;
                }
            }

           


        }
    }

}
