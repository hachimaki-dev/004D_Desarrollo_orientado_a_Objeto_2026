public class Libro extends Material{
    private int numPaginas;

    public Libro(String titulo, String autor, int cantidadDisponible, int numPaginas) {
        super(titulo, autor, cantidadDisponible);
        this.numPaginas = numPaginas;
    }

    public int getNumPaginas() {
        return this.numPaginas;
    }

    @Override
    public int calcularDiasPrestamo() {
        // TODO Auto-generated method stub
        if (getNumPaginas() > 300){
            return 14;
        }
        else{
            return 7;
        }
    }

    @Override
    public String mostrarInfo() {
        // TODO Auto-generated method stub
        return super.mostrarInfo() + "Tipo de material: " + "Libro\n" + "Número de Páginas: " + getNumPaginas() + "\n\n";
    }
}
