public class Revista extends Material{
    private String mesPublicacion;

    public void Revista(String titulo, String autor, int cantidadDisponible, int numPaginas){
        super(titulo, autor, cantidadDisponible);

    }
    public String getMesPublicacion(){
        return mesPublicacion;
    }

}