public class Libro extends Material{
    private int numPaginas;

    public libro(String titulo, String autor, int cantidadDisponible, int numPaginas) {
        super(titulo, autor, cantidadDisponible)
        this.numPaginas = numPaginas;   
    }

    public int getNumpaginas() {
        return numPaginas;
    }

    public int calcularDiasPrestamo() {
        if (numPaginas > 300) {
            return 14;
        } else {
            return 7; 
        }
    } 

    public String mostrarInfo() {
        return 
    }

}