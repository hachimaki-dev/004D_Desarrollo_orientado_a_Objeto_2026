public class Revista extends Material {
    private String mesPublicacion;

    Revista(String autor, String titulo, int CantidadDisponible,String mesPublicacion){
        super(autor, titulo, CantidadDisponible);
        this.mesPublicacion = mesPublicacion;
    }
    public String getMespublicacion(){
        return  this.mesPublicacion;
    }
    
}
