public class Revista extends Material
{
    private  String mesPublicacion;

    public Revista(String titul, String autor, int cantidadDisponible, String mesPublicacion) 
    {
        super(titul, autor, cantidadDisponible);
    }

    public String getMesPublicacion() 
    {
        return mesPublicacion;
    }

    public int calcularDiasPrestamo()
    {
        return 3 ;
    }

    @Override 
     public String mostrarInfo()
     {
        return "tip revista"+
               " | mes de ublicacio" + mesPublicacion ;
     }
    
    
}
