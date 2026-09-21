public class Libro extends Material {
    private int numPaginas;

    public Libro(String titulo, String autor, int cantidadDisponible, int numPaginas) {
        super(titulo, autor, cantidadDisponible);
        this.numPaginas = numPaginas;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    @Override
    public int calcularDiasPrestamo() {
        if (this.getNumPaginas() > 300) {
            System.out.println("Es mayor a 300");
            return 14;
        } else {
            System.out.println("Es menos a 300");
            return 7;
        }
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " Tipo: Libro" + " Y el numero de paginas es: " + this.getNumPaginas();

    }

}
