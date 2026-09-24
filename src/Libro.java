public class Libro extends Materiales{
    int numPaginas;

    public void main(String titulo, String autor, int cantidadDisponible, int numPaginas) {
        this.numPaginas = numPaginas;
    }
    public int getNumpaginas(){
        return numPaginas;
    }

}