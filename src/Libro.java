public class Libro extends Material {
    int numPaginas;

    Libro(String titulo,String autor,int cantidadDisponible,int numPaginas){
        this.titulo = titulo;
        this.autor = autor;
        this.cantidadDisponible = cantidadDisponible;
        this.numPaginas = numPaginas;
    }

    public int getNumPaginas(){
        return this.numPaginas;
    }
}
