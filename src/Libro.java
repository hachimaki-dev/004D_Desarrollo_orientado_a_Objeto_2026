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
    public int calcularDiasPrestamo() {
        if(NumPaginas < 300){
            return 7;

        }else{
            return 3;
        }

    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " | el numero de paguinas es de: " + getNumPaginas();
    }
}
