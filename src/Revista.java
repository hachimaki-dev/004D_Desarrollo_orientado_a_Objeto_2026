public class Revista extends material {
//la clase hijo de revistas hereda de la clase padre y se le suma algo que lo haga distinto
    private String mesPublicacion;
    libro(String titulo,String autor,int cantidad_disponible, String mesPublicacion){
        this.mesPublicacion;
    }
   
    public String getMesPublicacion(){
        return this.mesPublicacion;
    }
   
   
    @Override 
    public int calcularDiasPrestamo(){
        return 3;
    }
}
