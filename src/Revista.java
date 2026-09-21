public class Revista extends Material{
    private String mesPublicacion;

    public Revista(String titulo, String autor, int cantidadDisponible, String mesPublicacion) {
        super(titulo, autor, cantidadDisponible);
        this.mesPublicacion = mesPublicacion;
    }

    public String getMesPublicacion() {
        return this.mesPublicacion;
    }

    @Override
    public int calcularDiasPrestamo() {
        // TODO Auto-generated method stub
        return 3;
    }

    @Override
    public String mostrarInfo() {
        // TODO Auto-generated method stub
        return super.mostrarInfo() + "Tipo de material: " + "Revista\n" + "Mes de publicación: " + getMesPublicacion() + "\n\n";
    }
}
