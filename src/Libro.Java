public class Libro extends Material{
    private int numPaginas;
    
    public void Libro(String titulo, String autor, int cantidadDisponible, int numPaginas){
        super(titulo, autor, cantidadDisponible);

    }
    public int getNumPaginas(){
        return numPaginas;
    }
    public calcularDiasPrestamo(int){
    int dias = 0;
    if(numPaginas > 300){
        return 14 
    else
        return 7
        }
    }

    @override
    public String mostrarInfo(){
        {}

    }
}