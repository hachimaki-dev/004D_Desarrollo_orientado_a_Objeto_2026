public class Revista extends Material{
    private String mesPublicacion;

    Revista(String titulo, String autor, int cantidadDisponible, String mesPublicacion) {
        super(titulo, autor, cantidadDisponible);
        this.mesPublicacion = mesPublicacion;
    }

    public String getMesPublicacion() {
        return this.mesPublicacion;
    }

    @Override
    public int calcularDiasPrestamo() {
        return 3;
    }

    @Override
    public String mostrarInfo() {
        return "Revista | " + super.mostrarInfo() + " | Mes de Publicación: " + getMesPublicacion();
    } 
}
