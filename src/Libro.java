package src;
public class Libro extends Material
{
    private int numPaginas;

    public Libro(String titulo, String autor, int cantidadDisponible, int numPaginas)
    {

        super(titulo, autor, cantidadDisponible);

        this.numPaginas = numPaginas;

    }

    public int getNumPaginas()
    {
        return numPaginas;
    }
    @Override 
    public int calcularDiasPrestamos()
    {
        if (this.numPaginas > 300)
        {
            return 14;
        }
        else
        {
            return 7;
        }
    }
    @Override 
    public String mostrarInfo()
    {
        return "Titulo: " + this.getTitulo() + "| Autor: " + this.getAutor() + "| Cantidad disponible: " + this.getCantidadDisponible() + "| Dias de prestamo: " + Integer.toString(calcularDiasPrestamos()) + "| Número de paginas: " + getNumPaginas();
    }
}
