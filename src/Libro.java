public class Libro extends Material
{
    private int numPaginas;

    public Libro(String titul, String autor, int cantidadDisponible, int numPaginas) {
        super(titul, autor, cantidadDisponible);
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
            System.out.println("numero de pagias");
        }
        return 14;
    }

    @Override 
    public String mostrarInfo()
    {
        return "Tipo libro" +
                "Numero de paginas" + this.numPaginas;
    }

}
