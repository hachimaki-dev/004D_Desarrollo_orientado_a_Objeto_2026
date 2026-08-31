public class Personaje {
    private String nombre;
    String apellido;
    private int vida;
    boolean esta_vivo = true;



    //Se va a comportar como un metodo seteador
    public void validarNombre(String nombre ){
        nombre = nombre.toUpperCase();
        if (nombre.length() < 1) {
            System.out.print("El nombre del personaje no puede quedar vacio");
        }
        switch (nombre) {
            case "WEON":
                this.nombre = "****";
                break;
            case "ESTUPIDO":
                this.nombre = "****";
                break;
            case "SOPENKO":
                this.nombre = "****";
                break;
            case "SOPENCO":
                this.nombre = "****";
                break;
            case "IDIOTA":
                this.nombre = "****";
                break;
        
            default:
                this.nombre = nombre;
                break;
        }
    }

    //Se le conoce como el metodo Getter. Sirve para obtener el valor de un atributo
    public String mostrarNombre(){
        return this.nombre;
    }

    public void setVida(int vida){
        if (vida < 0){
            System.out.print("La vida del personaje no puede ser negativa. Que demonios haces!");
            this.vida = 0;
        } else{
            this.vida = vida;
        }
    }

    public int getVida(){
        return vida;
    }



    public void trabajar(){
        System.out.println("Chambeando");
    }

}