public class revista extends material {
    private int mesPublicacion;

    revista(String titulo,String autor, int cantidadDisponible,int mesPublicacion){
        super(titulo, autor, cantidadDisponible);
        mesPublicacion = this.mesPublicacion;
    }

    public int getMesPublicacion() {
        return mesPublicacion;
    }

    @Override
    public int calcularDiasPrestamo() {
        return 3;
    }

    @Override
    public String mostrarInfo() {
        return "revista" + "mes de publicacion " + mesPublicacion+super.mostrarInfo();
    }
}
