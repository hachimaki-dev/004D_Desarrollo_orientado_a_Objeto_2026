public class Libro extends Material{
    private int numPaginas;

    public Libro(String titulo, String autor, int cantidadDisponible, int numPaginas){
        super(titulo, autor, cantidadDisponible);
        this.numPaginas = numPaginas;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    @Override
    public int calcularDiasPrestamo() {
        if (this.numPaginas > 300) {
            return 14;
        } else {
            return 7;
        }
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + "\nTipo de material: LIBRO" + "\nNúmero de páginas: " + numPaginas;
    }
    
}
