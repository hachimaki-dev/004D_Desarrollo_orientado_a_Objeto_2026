import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       mostrarMenu();

    }
    
    static void mostrarMenu(){
        String opcion_menu;
        boolean mantener_menu = true;
        
        Personaje personaje_jugador = new Personaje();

        Scanner scanner = new Scanner(System.in); 

        while (mantener_menu) {
            System.out.println("Elija su opción");
            System.out.println("1.- Crear personaje");
            System.out.println("2.- Ver personaje");
            System.out.println("3.- Cerrar");
            opcion_menu = scanner.nextLine();

            switch (opcion_menu) {
                case "1":
                    System.out.println("Creación del Personaje");
                    System.out.println("¿Cómo llamaras al personaje?");
                    personaje_jugador.nombre = scanner.nextLine();
                    System.out.println("¿Cómo llamaras al apellido del personaje?");
                    personaje_jugador.apellido = scanner.nextLine();
                    System.out.println("Asigna la vida del personaje");
                    //personaje_jugador.vida = Integer.parseInt(scanner.nextLine());
                    personaje_jugador.setVida(Integer.parseInt(scanner.nextLine()));
                    //Pero haber creado el metodo no es suficiente, por que si el atributo sigue publico, el encapsulamiento no tiene sentido. Revisemos con un ejemplo, observa la siguiente linea
                    //personaje_jugador.vida = -20;
                    //Para que esto no sea posible, declararemos el atributo como privado
                    break;
                case "2":
                    System.out.println("Datos del personaje creado");
                    System.out.print("Nombre personaje: " + personaje_jugador.nombre);
                    System.out.print("Apellido personaje: " + personaje_jugador.apellido);

                    //OJITO CON ESTO, ESTO ES LA LUZ!
                    //REFLEXIONA, POR QUÉ ES MEJOR ESTO?
                    //ENCAPSULANDO
                    System.out.print("Vida personaje: " + personaje_jugador.getVida());
                    System.out.print("¿Se encuentra vivo?: " + personaje_jugador.esta_vivo);
                    break;
                case "3":
                    System.out.println("Cosas de opcion 3");
                    mantener_menu = false;
                    break;
            
                default:
                    System.out.println("Por favor ingrese una opción valida");
                    break;
            }
        }
    }
}
