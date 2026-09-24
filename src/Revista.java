public class Revista extends Material
{
    private  String mesPublicacion;

    public Revista(String titulo, String autor, int cantidadDisponible, String mesPublicacion) 
    {
        super(titulo, autor, cantidadDisponible);
    }

    public String getMesPublicacion() 
    {
        return mesPublicacion;
    }

    public int calcularDiasPrestamo()
    {
        return 3;
    }

    @Override 
     public String mostrarInfo()
     {
        return "tip revista" + 
                " | Titulo: " + getTitulo() +
                " | Autor: " + getAutor() + 
                " | Cantidad disponible: " + getCantidadDisponible() +
                " | mes de ublicacio" + mesPublicacion ;
     }
    
    
}
