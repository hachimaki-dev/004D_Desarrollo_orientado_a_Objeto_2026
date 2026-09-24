public class Libro extends Material {
    
    private int numPaginas;

    public Libro(int numPaginas, String autor, int cantidadDisponible, String titulo) {
        super(autor, cantidadDisponible, titulo);
        setNumPaginas(numPaginas);
    }

    public int getNumPaginas() {
        return this.numPaginas;
    }

    public final void setNumPaginas(int numPaginas) {
        if(numPaginas < 0){
            System.out.println("Error: La cantidad de paginas no puede ser menor a 0.");
        }
        else{
            this.numPaginas = numPaginas;    
        }
    }

    @Override
    public int calcularDiasPrestamo() {
        if (numPaginas > 300){
            return 14;
        }
        else{
            return 7;
        }
    }

    @Override
    public void mostrarInfo() {
        System.out.println("=== LIBRO ===");
        super.mostrarInfo();
        System.out.println("Numero de paginas: " + getNumPaginas());
    }

    
}
