public class Libro extends Material {
    private int numPaginas;

    public Libro(int numPaginas, String titulo, String autor, int cantidadDisponible) {
        super(titulo, autor, cantidadDisponible);
        this.numPaginas = numPaginas;
    }

        public int getNumPaginas() {
        return numPaginas;
    }

    @Override
    public int calcularDiasPrestamo() {
        if (getNumPaginas()>300){
            return 14;
        }else{
            return 7;
        }
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + ". Tipo: Libro. Numero de páginas: " + this.getNumPaginas();
    }

    
    
}
