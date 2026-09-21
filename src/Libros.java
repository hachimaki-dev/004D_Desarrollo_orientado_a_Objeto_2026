public class Libros extends Material {
    
    private int numPaginas;

 

    public Libros(String titulo, String autor, int ejemplaresDisponibles, int numPaginas) {
        super(titulo, autor, ejemplaresDisponibles);
        this.numPaginas = numPaginas;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    
}




