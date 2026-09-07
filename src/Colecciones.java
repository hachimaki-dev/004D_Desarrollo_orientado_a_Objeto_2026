import java.util.ArrayList;
import java.util.Scanner;

public class Colecciones {
    public static void main(String[] args) {
        System.out.println("///Todo impeke/////");
        Scanner sc = new Scanner(System.in);
        
        boolean mostrar_menu = true;

        while (mostrar_menu) {
            System.err.println("1. Conociendo Arrays");
            System.err.println("2. Conociendo ArrayList");
            System.err.println("9. Salir");

            System.out.println("Ingrese una opcion ");
            String opcion_ingresada = sc.nextLine();

            switch (opcion_ingresada) {
                case "1":
                    conociendoArrays();
                    break;
                
                case "2":
                    conociendoArrayList();
                    break;
                
                case "9":
                    System.err.println("Saliendo...");
                    mostrar_menu = false;
            
                default:
                    break;
            }
        }
    }

    static void conociendoArrays(){
        String[] alumnos = new String[4];
        alumnos[0] = "Diego Marín";
        alumnos[1] = "Amaro Lopez";
        alumnos[2] = "Mariany Sanchez";
        alumnos[3] = "Gustavo Araneda";

        Integer[] edades = new Integer[4];
        edades[0] = 18;
        edades[1] = 19;
        edades[2] = 19;
        edades[3] = 18;
        System.out.println("Datos de " + alumnos[0] + " edad " + edades[0]);
        System.out.println("Datos de " + alumnos[1] + " edad " + edades[1]);
        System.out.println("Datos de " + alumnos[2] + " edad " + edades[2]);
        System.out.println("Datos de " + alumnos[3] + " edad " + edades[3]);


       for (int i = 1; i < edades.length; i++) {
        System.out.println("Nombres:" + alumnos[i] + "Edades:" + edades[i]);
       }
    }


    static void conociendoArrayList(){

        ArrayList<String> alumnos = new ArrayList<>();

        alumnos.add("Diego Marín");
        alumnos.add("Amaro Lopes");
        alumnos.add("Mariany Sanchez");
        alumnos.add("Gustavo Araneda");
        

        alumnos.set(1, "Amaró Lopez");
        alumnos.remove(1);
        for (int i = 0; i < alumnos.size(); i++) {
            System.out.println(alumnos.get(i));
        }

    }
}
