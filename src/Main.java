import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       mostrarMenu();

    }


    static void mostrarMenu(){
        Personaje personaje_jugador = new Personaje();
        String opcion_elegida;
        Scanner scanner = new Scanner(System.in);
        boolean iniciar_menu = true;
        System.out.println("**BIENVENIDOS AL MUNDO DE WESTEROS");

        while (iniciar_menu) {
            
        System.out.println("1.- Crear personaje");
        System.out.println("2.- Ver personaje");
        System.out.println("3.- Salir");

        System.out.print("Por favor ingrese una opción: ");

        opcion_elegida = scanner.nextLine();

        System.out.print("La opcion escogida por el usuario es: " + opcion_elegida);

        //Este sirve para hacer acciones en funcion de un valor o sus posibles valores
        switch (opcion_elegida) {
            case "1":
                System.out.println("CREACIÓN DE PERSONAJE");
                

                System.out.println("¿Cómo llamaras a tu héroe?");
                personaje_jugador.nombre = scanner.nextLine();

                System.out.println("¿Cuál es el apellido del héroe?");
                personaje_jugador.apellido = scanner.nextLine();

                System.out.println("Indique la vida del Héroe");
                //Ya no lo haremos así, por que es inseguro
                //personaje_jugador.vida = Integer.parseInt(scanner.nextLine());

                personaje_jugador.setearVida(Integer.parseInt(scanner.nextLine()));

                break;

            case "2":
                System.out.println("VER PERSONAJE");
                System.out.println("Nombre: " + personaje_jugador.nombre);
                System.out.println("Apellido " + personaje_jugador.apellido);
                System.out.println("Vida " + personaje_jugador.verVida() );
                break;

            case "3":
                System.out.println("GRACIAS POR JUGAR");
                iniciar_menu = false;
                break;
        
            default:
                System.out.println("POR FAVOR INGRESE UNA DE LAS OPCIONES PERMITIDAS");
                break;
        }
        }
    }


}
