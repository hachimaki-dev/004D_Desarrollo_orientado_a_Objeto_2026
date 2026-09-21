import java.util.Scanner;

public class main {

    Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
    while (true) {
    System.out.println("= BIBLIOTECA MUNICIPAL =");
    System.out.println("1. Registrar material");
    System.out.println("2. Listar catalogo");   
    System.out.println("3. Buscar material por titulo");
    System.out.println("4. Prestar material");
    System.out.println("5. Resumen del catalogo");
    System.out.println("6. Salir");
    System.out.println("Seleccione una opcion: _");
    int opcion = sc.nextint();

    switch (opcion) {
        case 1:
            registrarmaterial();
            break;

        case "2":
        case "3":
        case "4":
        case "5":
        case "6":
        default:
            break;
    }
    String registrarmaterial(){
        System.out.println("1-revista");
        System.out.println("2-libro");
        int opcion2 = sc.nextint();
        switch (opcion2) {
            case 1:
                this.titulo = sc.nextline();
                break;
            case 2:
                this.titulo = sc.nextline();
                break;
        
            default:
                break;

        return 
        }
    }
    }
 }
}
