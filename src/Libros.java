public class Libros extends Material {
    
    private int numPaginas;

 

    public Libros(String titulo, String autor, int cantidadDisponibles, int numPaginas) {
        super(titulo, autor, cantidadDisponibles);
        this.numPaginas = numPaginas;
    }

    public int getNumPaginas() {
        return numPaginas;
    }


static int calcularDiasDePrestamo (){

    return 0;
}
}

    





