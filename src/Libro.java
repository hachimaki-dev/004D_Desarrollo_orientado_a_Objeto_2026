public class Libro extends Material{
    private int numPaginas;


 public int getNumPaginas() {
        return numPaginas;
    }


    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }


 public Libro(String titulo, String autor, int cantidadDisponible, int numPaginas){
    super(titulo, autor, cantidadDisponible);
 }
 @Override
 public int calcularDiasPrestamo() {
     // TODO Auto-generated method stub
     return super.calcularDiasPrestamo();
 }

 @Override
 public String mostrarInfo() {
     // TODO Auto-generated method stub
     return super.mostrarInfo();
 }
}
