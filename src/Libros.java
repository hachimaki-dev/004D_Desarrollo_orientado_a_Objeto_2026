public class Libros extends Material {
    private int numPaginas;

    Libros(String titulo, String autor, int cantidadDisponible, int numPaginas){
        super(titulo, autor, cantidadDisponible);
        this.numPaginas = numPaginas;
    }

    public int getNumPaginas(){
        return numPaginas;
    }

    @Override
    public int calcularDiasPrestamo() {
        if(numPaginas > 300){
            return 14;
        }else{
            return 7;
        }
    }

    @Override
    public String mostraInfo() {
        return super.mostraInfo() + " Cantidad de paginas" + getNumPaginas();
    }

}
