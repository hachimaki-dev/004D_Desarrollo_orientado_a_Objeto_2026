public class Libro extends Material
{
    private int numPaginas;

    public Libro(String titulo, String autor, int cantidadDisponible, int numPaginas) 
    {
        super(titulo, autor, cantidadDisponible);
        this.numPaginas = numPaginas;
    }

    public int getNuPaginas() 
    {
        return numPaginas;
    }

    @Override 
    public int calcularDiasPrestamo()
    {
        if (getNuPaginas() > 300)
        {
            return 14;
        }
        return 7;
    }

    @Override 
    public String mostrarInfo()
    {
        return "Libro" +
                " | Titulo: " + getTitulo() +
                " | Autor: " + getAutor() + 
                " | Cantidad disponible: " + getCantidadDisponible() +
                " | Numero de paginas: " + this.numPaginas;
    }

}
