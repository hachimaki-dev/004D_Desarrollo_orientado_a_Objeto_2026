public class Libro  extends Material{
    private int numPaginas;

    Libro(String titulo, String autor, int cantidadDisponible, int numPaginas){
        super(titulo, autor, cantidadDisponible);
        this.numPaginas = numPaginas;
    }

    public int getNumPaginas(){
        return this.numPaginas;
    }

    @Override
    public int calcularDiasPrestamo() {
        // TODO Auto-generated method stub
        if (numPaginas > 300){
            System.out.println("Este libro debe regresarse en 14 dias");
            return 14;
        }else{
            System.out.println("Este libro debe devolverse en 7 dias");
            return 7;
        }
        
    }

    @Override
    public String mostrarInfo() {
        // TODO Auto-generated method stub
        return super.mostrarInfo() + "Libro registrado" + getNumPaginas();
    }
}
