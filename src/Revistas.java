public class Revistas extends Material {
    String mesPublicacion;

    public Revistas(String titulo, String autor, int cantidadDisponible, String mesPublicacion) {
        super(titulo, autor, cantidadDisponible);
        this.mesPublicacion = mesPublicacion;
    }

    @Override
    public int calcularDiasPrestamo() {
        return 3;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + "Tipo: Revista Mes de publicación: " + this.mesPublicacion;
    }
}
