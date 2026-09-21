public class Revistas extends Material{
    private String mesPublicacion;

    Revistas(String titulo, String autor, int cantidadDisponible, String mesPublicacion){
        super(titulo, autor, cantidadDisponible);
        this.mesPublicacion = mesPublicacion;
    }

    public String getMesPublicacion(){
        return mesPublicacion;
    }

    @Override
    public int calcularDiasPrestamo() {
        return 3;
    }

    @Override
    public String mostraInfo() {
        return super.mostraInfo() + " Mes de publicaion :" + getMesPublicacion();
    }
}
