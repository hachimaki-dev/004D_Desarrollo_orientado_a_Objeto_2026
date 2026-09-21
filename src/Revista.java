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
    public void calcularDiasPrestamo() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mostrarInfo() {
        // TODO Auto-generated method stub
        super.mostrarInfo();
    }
}
