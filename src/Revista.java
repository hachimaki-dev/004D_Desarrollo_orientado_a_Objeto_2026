public class Revista extends Materiales{
    private String mesPublicacion;

    Revista(String titulo, String autor, int cantidadDisponible, String mesPublicacion){
        super(titulo, autor, cantidadDisponible);
        this.mesPublicacion = mesPublicacion;
    }

    String getMesPublicacion(){
        return this.mesPublicacion;
    }

    @Override
    public int calcularDiasPrestamo() {
        return 3;
    }

    @Override
    String mostrarInfo() {
        return super.mostrarInfo() + "" + " Mes de publicacion: " + this.getMesPublicacion();
    }
}
