public class Revistas extends Material {

    private String mesDePublicacion;



    public Revistas(String titulo, String autor, int cantidadDisponibles, String mesDePublicacion) {
        super(titulo, autor, cantidadDisponibles);
        mesDePublicacion = mesDePublicacion;
    }

    public String getMesDePublicacion() {
        return mesDePublicacion;
    }
 
}
