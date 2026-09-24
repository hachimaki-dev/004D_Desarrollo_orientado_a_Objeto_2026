public class Revista extends Material{

    private String MesPublicacion;

    public Revista(String MesPublicacion, String Titulo, String Autor, int CantidadDisponible){
        super(Titulo, Autor, CantidadDisponible);
        this.MesPublicacion = MesPublicacion;
    }

    public String getMesPublicacion() {
        return MesPublicacion;
    }

    public void setMesPublicacion(String mesPublicacion) {
        MesPublicacion = mesPublicacion;
    }

    @Override
    public int calcularDiasPrestamo() {
        return 7;
        
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " | el mes de publicacion es el: " + getMesPublicacion();
    }
}
