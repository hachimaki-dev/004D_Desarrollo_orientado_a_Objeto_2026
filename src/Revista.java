public class Revista extends material {
//la clase hijo de revistas hereda de la clase padre y se le suma algo que lo haga distinto
    private String mesPublicacion;
    Revista(String titulo,String autor,int cantidad_disponible, String mesPublicacion){
        super(titulo, autor, cantidad_disponible);
        mesPublicacion = this.mesPublicacion;
    }
   
    public String getMesPublicacion(){
        return this.mesPublicacion;
    }
    
    @Override 
    public static void mostrarInfo(){
        return "revista" + "mes de publicacion" + mesPublicacion+super
    }
   
    @Override 
    public int calcularDiasPrestamo(){
        return 3;
    }
}
