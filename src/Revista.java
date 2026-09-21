package src;
public class Revista extends Material
{
    private String mesPublicacion;

    public Revista(String titulo, String autor, int cantidadDisponible, String mesPublicacion)
    {

        super(titulo, autor, cantidadDisponible);

        this.mesPublicacion = mesPublicacion;

    }

    public String getMesPublicacion()
    {
        return this.mesPublicacion;
    }

    @Override 
    public int calcularDiasPrestamos()
    {
        return 3;
    }

    @Override 
    public String mostrarInfo()
    {
        return "Titulo: " + this.getTitulo() + "| Autor: " + this.getAutor() + "| Cantidad disponible: " + this.getCantidadDisponible() + "| Dias de prestamo: " + Integer.toString(calcularDiasPrestamos()) + "| Mes de publicación: " + getMesPublicacion();
    }
}
