public class Libros extends Material implements Prestable{
    private int numPaginas;

    public Libros(String titulo, String autor, int cantidadDisponible, int numPaginas){
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
        return super.mostraInfo() + "|| Cantidad de paginas " + getNumPaginas();
    }

    @Override
    public boolean prestar(int cantidad){
        if(cantidad <= getCantidadDisponible()){
            setCantidadDisponible(getCantidadDisponible()- cantidad);
            return true;
        }
        return false;
    }

    @Override 
    public void devolver(int cantidad){
        setCantidadDisponible(getCantidadDisponible()+cantidad);
    }
}
