public class Libro extends Material{

    private int NumPaginas;
    
    public Libro(int NumPaginas, String Titulo, String Autor, int CantidadDisponible){
        super(Titulo, Autor, CantidadDisponible);
        this.NumPaginas = NumPaginas;
    }
    public int getNumPaginas() {
        return NumPaginas;
    }
    public void setNumPaginas(int numPaginas) {
        NumPaginas = numPaginas;
    }
    
    @Override
    public void calcularDiasPrestamo() {
        // TODO Auto-generated method stub
    }

    @Override
    public void mostrarInfo() {
        // TODO Auto-generated method stub
        super.mostrarInfo();
    }
}
