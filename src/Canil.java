public class Canil {

    public static void main(String[] args) {
        System.out.println("****Bienvenido al Caníl*****");



        Perro perro_del_profe = new Perro();

        perro_del_profe.nombre = "Gimli";
        perro_del_profe.edad = 1;
        perro_del_profe.peso = 40;
        perro_del_profe.tiene_vacuna = false;

        if (perro_del_profe.edad > 2){
            System.out.println("Es mayor que 2 años");
        }
        else {
            System.out.println("El perro es menor que 2 años");
        }


        System.out.println("Gracias por su visita, lo quiero mucho <3");
    }

}
