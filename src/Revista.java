public class Revista extends Material{
    private String mesPublicacion;

    Revista(String titulo, String autor, int cantidadDisponible, String mesPublicacion){
        super(titulo, autor, cantidadDisponible);
        this.mesPublicacion = mesPublicacion;
    }

    public String getMesPublicacion(){
        return this.mesPublicacion;
    }

    @Override
    public int calcularDiasPrestamo() {
        System.out.println("Esta revista debe devolverse en 3 dias");
        return 3;
    }

    @Override
    public String mostrarInfo() {
        // TODO Auto-generated method stub
        return super.mostrarInfo() + "Revista registrada" + getMesPublicacion();
    }
}
