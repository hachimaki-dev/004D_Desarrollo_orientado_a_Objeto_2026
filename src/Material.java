package src;

public abstract class Material 
{

    private String titulo;

    private String autor;

    private int cantidadDisponible;

    public Material(String titulo, String autor, int cantidadDisponible)
    {

        this.titulo = titulo;

        this.autor = autor;

        this.cantidadDisponible = cantidadDisponible;

    }

    public String getTitulo()
    {
        return this.titulo;
    }

    public String getAutor()
    {
        return this.autor;
    }

    public int getCantidadDisponible()
    {
        return this.cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible)
    {
        this.cantidadDisponible = cantidadDisponible;
    }

    public abstract int calcularDiasPrestamos();

    public String mostrarInfo()
    {
        return "Titulo: " + this.getTitulo() + "| Autor: " + this.getAutor() + "| Cantidad disponible: " + this.getCantidadDisponible() + "| Dias de prestamo: " + Integer.toString(calcularDiasPrestamos());
    }

}