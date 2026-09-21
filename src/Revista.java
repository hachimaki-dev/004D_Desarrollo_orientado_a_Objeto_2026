public class Revista extends Material {
    private String mesPublicacion;

    public Revista(String titulo, String autor, int cantidadDisponible, String mesPublicacion) {
        super(titulo, autor, cantidadDisponible);
        this.mesPublicacion = mesPublicacion;
    }

    public String getMesPublicacion() {
        return mesPublicacion;
    }

    @Override
    public int calcularDiasPrestamo() {
        return 3;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " Tipo: Revista" + " Mes de Publicacion: " + this.getMesPublicacion();
    }

    
    
}
