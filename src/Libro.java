public class Libro extends Materiales {
    private int numeroPaginas;

    Libro(String titulo, String autor, int cantidadDisponible, int numeroPaginas){
        super(titulo, autor, cantidadDisponible);
        this.numeroPaginas = numeroPaginas;
    }

    int getNumeroPaginas(){
        return this.numeroPaginas;
    }

    @Override
    public int calcularDiasPrestamo() {
        if (this.getNumeroPaginas() > 300) {
            return 14;    
        }
        else {
            return 7;
        }
        
    }

    @Override
    String mostrarInfo() {
        return super.mostrarInfo() + "Libro" +  this.getNumeroPaginas();
    }
}
