import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        mostrarMenu();

    }

    static void mostrarMenu() {
        String opcion_menu;
        boolean mantener_menu = true;

        Personaje personaje_jugador = new Personaje();

        Scanner scanner = new Scanner(System.in);

        while (mantener_menu) {
            System.out.println("Elija su opción");
            System.out.println("1.- Crear personaje");
            System.out.println("2.- Ver personaje");
            System.out.println("3.- Cerrar");
            System.out.println("4.- Testeando cositas");
            opcion_menu = scanner.nextLine();

            switch (opcion_menu) {
                case "1":
                    crearPersonaje(scanner, personaje_jugador);

                    break;
                case "2":
                    verDatosDelPersonaje(scanner, personaje_jugador);
                    break;
                case "3":
                    System.out.println("Cosas de opcion 3");
                    mantener_menu = false;
                    break;

                case "4":
                    testeandoCositas();
                    break;
                default:
                    System.out.println("Por favor ingrese una opción valida");
                    break;
            }
        }
    }

    static void testeandoCositas(){
        System.out.println("Este es ek hacker");
        Personaje hacker = new Hacker();
        hacker.trabajar();

        hacker.validarNombre("carlitos");
        System.out.println(hacker.mostrarNombre());

        System.out.println("Este es el gamedev");
        Personaje gamedev = new GameDev();
        gamedev.trabajar();
        
    }

    static void crearPersonaje(Scanner scanner, Personaje personaje_jugador) {
        Hacker amaro = new Hacker();
        Programador alexander = new Programador();
        GameDev mati = new GameDev();
    
        Personaje alan = new Personaje();
        
        System.out.println("Creación del Personaje");
        System.out.println("¿Cómo llamaras al personaje?");
        String nombre_sin_validar = scanner.nextLine();

        boolean bandera_ciclo_validar_nombre = true;

        while (bandera_ciclo_validar_nombre) {
            if (nombre_sin_validar.length() < 1) {
                System.out.println("Ingrese un nombre valido");
                nombre_sin_validar = scanner.nextLine();
            } else {
                bandera_ciclo_validar_nombre = false;
            }
        }

        personaje_jugador.validarNombre(nombre_sin_validar);

        System.out.println("¿Cómo llamaras al apellido del personaje?");
        personaje_jugador.apellido = scanner.nextLine();
        System.out.println("Asigna la vida del personaje");
        // personaje_jugador.vida = Integer.parseInt(scanner.nextLine());
        personaje_jugador.setVida(Integer.parseInt(scanner.nextLine()));
        // Pero haber creado el metodo no es suficiente, por que si el atributo sigue
        // publico, el encapsulamiento no tiene sentido. Revisemos con un ejemplo,
        // observa la siguiente linea
        // personaje_jugador.vida = -20;
        // Para que esto no sea posible, declararemos el atributo como privado
    }

    static void verDatosDelPersonaje(Scanner scanner, Personaje personaje_jugador) {
        System.out.println("Datos del personaje creado");
        System.out.println("Nombre personaje: " + personaje_jugador.mostrarNombre());
        System.out.println("Apellido personaje: " + personaje_jugador.apellido);

        // OJITO CON ESTO, ESTO ES LA LUZ!
        // REFLEXIONA, POR QUÉ ES MEJOR ESTO?
        // ENCAPSULANDO
        System.out.println("Vida personaje: " + personaje_jugador.getVida());
        System.out.println("¿Se encuentra vivo?: " + personaje_jugador.esta_vivo);
    }
}
