public class Personaje {
    String nombre;
    String apellido;
    private int vida;
    boolean esta_vivo = true;


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
}