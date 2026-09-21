public class Revistas extends Material {

    private String MesDePublicacion;



    public Revistas(String titulo, String autor, int ejemplaresDisponibles, String mesDePublicacion) {
        super(titulo, autor, ejemplaresDisponibles);
        MesDePublicacion = mesDePublicacion;
    }



    public String getMesDePublicacion() {
        return MesDePublicacion;
    }
    
}
