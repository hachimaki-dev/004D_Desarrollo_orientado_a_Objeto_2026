public class Revista extends Material {
    private String mesPublicacion;

    public Revista(String mesPublicacion, String titulo, String autor, int cantidadDisponible) {
        super(titulo, autor, cantidadDisponible);
        this.mesPublicacion = mesPublicacion;
    }

    public String getMesPublicacion() {
        return mesPublicacion;
    }

    @Override
    public int calcularDiasPrestamo() {
        return 7;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + ". Tipo: Revista. Mes de publicacion: " + this.getMesPublicacion();
    }

    
}
