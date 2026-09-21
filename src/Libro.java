public class Libro extends Material {
    private int numPaginas;

    public Libro(String titulo, String autor, int cantidadDisponible, int numPaginas) {
        super(titulo, autor, cantidadDisponible);
        this.numPaginas = numPaginas;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }
    
    @Override
    public int calcularDiasPrestamo() {
        if (numPaginas > 300) {
            return 14;
        } else {
            return 7;
        }
    }
    
    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + "Tipo: Libro Cantidad de paginas: " + this.numPaginas;
    }

}
