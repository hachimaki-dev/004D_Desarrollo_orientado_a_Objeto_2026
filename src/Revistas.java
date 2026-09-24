public class Revistas extends Material implements Prestable{
    private String mesPublicacion;

    public Revistas(String titulo, String autor, int cantidadDisponible, String mesPublicacion){
        super(titulo, autor, cantidadDisponible);
        this.mesPublicacion = mesPublicacion;
    }

    public String getMesPublicacion(){
        return mesPublicacion;
    }

    @Override
    public int calcularDiasPrestamo() {
        return 3;
    }

    @Override
    public String mostraInfo() {
        return super.mostraInfo() + "|| Mes de publicaion :" + getMesPublicacion();
    }

    @Override
    public boolean prestar(int cantidad){
        if(cantidad <= getCantidadDisponible()){
            setCantidadDisponible(getCantidadDisponible()- cantidad);
            return true;
        }
        return false;
    }

    @Override 
    public void devolver(int cantidad){
        setCantidadDisponible(getCantidadDisponible()+cantidad);
    }
}
