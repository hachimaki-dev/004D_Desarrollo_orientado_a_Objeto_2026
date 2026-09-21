public class Libro extends Material{
    private int numPaginas;

    Libro(String titulo, String autor, int cantidadDisponible, int numPaginas) {
        super(titulo, autor, cantidadDisponible);
        this.numPaginas = numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        if (numPaginas < 0) {
            System.out.println("No debe ser negativo");
        } else {
            this.numPaginas = numPaginas;
        }
    }

    public int getNumPaginas() {
        return this.numPaginas;
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
        return super.mostrarInfo() + " | " + getNumPaginas() + " páginas";
    }
}
