public class Revista extends Material{
    private String mesPublicacion;

    public void getMesPublicacion(String mesPublicacion) {
        this.mesPublicacion = mesPublicacion;
    }

    Revista(String titulo, String autor, int cantidadDisponible, int numPaginas, String mesPublicacion){
        super(titulo, autor, cantidadDisponible);
    }

    @Override
    public int calcularDiasPrestamo() {
        // TODO Auto-generated method stub
        return super.calcularDiasPrestamo();
    }

    @Override
    public String mostrarInfo() {
        // TODO Auto-generated method stub
        return super.mostrarInfo();
    }
}
