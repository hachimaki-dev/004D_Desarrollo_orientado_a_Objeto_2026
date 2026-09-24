// la diferencia entre el java y python es que el lenguaje de progrmacion es muy importante ya que aca pódemos hacer clases y sub clases
// asi pudiendo craerlas y heredarlas de cada una hasta poder llegar a nuestro main y poder reciclar el codigo llamandose polimorfismo.
// mietras tanto que es python hacemos algo muy diferente ya que hay ya no tenemos lo que son las clases y pero si podemos reciclar codigo atraves del def
// y sus diferencias es que ya no usamos ni polimorfismo al igual que clases y sub clases.


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Material> Inventario = new ArrayList<>();
    static Scanner consola = new Scanner(System.in);

    public static void main(String[] args) {
        MostrarMenu();
    }
        
     static public void MostrarMenu(){
         boolean Funcionando = true;
            
        
    while (Funcionando) {

        System.out.println("==== BIBLIOTECA MUNICIPAL ====");
        System.out.println("1. Registrar material");
        System.out.println("2. listar catalogo");
        System.out.println("3. buscar material por revista");
        System.out.println("4. prestar material");
        System.out.println("5. resumen del catalogo");
        System.out.println("6. salir");
        System.out.println("7. insertar datos");
        System.out.println("seleccione una opcion:");
        
        
        String OpcionMemu = consola.nextLine();

        switch (OpcionMemu) {
            case "1":
                MostrarSubMenu();
                break;

            case "2":
                ListarCatalogo();
                break;

            case "3":
                BuscarMaterial();
                break;

            case "4":
                PrestarMaterial();
                break;

             case "5":
                ResumenDelCatalogo();
                break;

             case "6":
                Funcionando = false;
                System.out.println("gracias por usar la biblioteca nacional, que tenga buen dia :)");
                break;

            case "7":
                InsertarDatos();
                break;

            default:
                break;
            }
        }
    }

     static public void MostrarSubMenu(){
        boolean FuncionandoSub = true;

        while (FuncionandoSub) {

        System.out.println("1. registra libro");
        System.out.println("2. registrar revista");
        System.out.println("3. salir");

        System.out.println("seleccione una opcio:");
            
        
        String OpcionSubMenu = consola.nextLine();

        switch (OpcionSubMenu) {
            case "1":
                registraLibro();
                break;

             case "2":
                registraRevista();
                break;

             case "3":
                FuncionandoSub = false;
                System.out.println("gracias por usar el sistema de registro");
                break;
        
            default:
                break;
            }
        }
    }

    static void registraLibro(){
        try {
        System.out.println("ingrese el nombre del titulo: ");
        String Titulo = consola.nextLine();

        System.out.println("ingrese el nombre del autor: ");
        String Autor = consola.nextLine();

        System.out.println("ingrese la cantidad disponible: ");
        int CantidadDisponible = Integer.parseInt(consola.nextLine());

        System.out.println("ingrese el numero de paguinas: ");
        int NumPaginas= Integer.parseInt(consola.nextLine());

        Material Libro = new Libro(NumPaginas, Titulo, Autor, CantidadDisponible);
        Inventario.add(Libro);
        System.out.println("el libro se resgistro exitosamente");     
        
        } catch (IllegalArgumentException e) {
            System.out.println("dato no valido");
        }
    }
        
      static void registraRevista(){
        try {
        System.out.println("ingrese el nombre del titulo: ");
        String Titulo = consola.nextLine();

        System.out.println("ingrese el nombre del autor: ");
        String Autor = consola.nextLine();

        System.out.println("ingrese la cantidad disponible: ");
        int CantidadDisponible = Integer.parseInt(consola.nextLine());

         System.out.println("ingrese el mes de la publicacion: ");
        String MesPublicacion = consola.nextLine();

        Material Revista = new Revista(MesPublicacion, Titulo, Autor, CantidadDisponible);
        Inventario.add(Revista);
        System.out.println("la revista se registro exitosamente");
            } catch (IllegalArgumentException e) {
            System.out.println("dato no valido");
        }

    }

    static void ListarCatalogo(){
        try {
        System.out.println("######## LISTA DEL CATALOGO ######");

        if(Inventario.isEmpty()){
            System.out.println("no se encuentra nada dentro del inventario");
            return;
        }
        for (int i = 0; i < Inventario.size(); i++) {
            Material L = Inventario.get(i);
            System.out.println("[" + (i + 1) + "]" + L.mostrarInfo() );
        }
            } catch (IllegalArgumentException e) {
            System.out.println("dato no valido");
        }
    }

    static void BuscarMaterial(){
        try {
        System.out.println("######## INGRESE EL MATERIAL A BUSCAR POR AUTOR ######");
        
        Boolean Encontrado = false;
        if(Inventario.isEmpty()){
            System.out.println("no hay nada dentro del Inventario");
            return;
        }
        String Buscar = consola.nextLine();

         for (int i = 0; i < Inventario.size(); i++) {
            Material B = Inventario.get(i);
            if(B.getAutor().toLowerCase().contains(Buscar.toLowerCase())){
            Encontrado = true;
            System.out.println("se encontro con el autor relacionado el" + B.mostrarInfo());
            }
            if(!Encontrado){
                System.out.println("no se encontro nada relacionado");
            }
        }
            } catch (IllegalArgumentException e) {
            System.out.println("dato no valido");
        }
    }

    static void PrestarMaterial(){
        try {
           System.out.println("######## PRESTAR MATERIAL ######");

        if(Inventario.isEmpty()){
            System.out.println("no se encuentra nada dentro del inventario");
            return;
        }
        for (int i = 0; i < Inventario.size(); i++) {
            Material L = Inventario.get(i);
            System.out.println("[" + (i + 1) + "]" + L.mostrarInfo() );
            
        }
            } catch (IllegalArgumentException e) {
            System.out.println("dato no valido");
        }
    }

    static void ResumenDelCatalogo(){
        try {
           System.out.println("######## RESUMEN DEL CATALOGO ######");

        if(Inventario.isEmpty()){
            System.out.println("no se encuentra nada dentro del inventario");
            return;
        }
        for (int i = 0; i < Inventario.size(); i++) {
            Material L = Inventario.get(i);
            System.out.println("[" + (i + 1) + "]" + L.mostrarInfo() );
            
        }
            } catch (IllegalArgumentException e) {
            System.out.println("dato no valido");
        }
    }

    static void InsertarDatos(){
        System.out.println("######## DATOS INSERTADOS #########");
        Inventario.add(new Libro(250, "libro 1", "gustavo", 30));
        Inventario.add(new Libro(250, "libro 2", "romina", 240));
        Inventario.add(new Libro(250, "libro 3", "emilia", 10));

        Inventario.add(new Revista("marzo", "libro 4", "profe carlos", 28));
        Inventario.add(new Revista("abril", "libro 5", "hernand", 100));
        Inventario.add(new Revista("mayo", "libro 6", "benja", 5));

    }
}