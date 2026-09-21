public class libro extends material{
    private int numPaginas;

    libro(String nombre,String autor,int cantidadDisponible,int numPaginas){
        super(autor, autor, cantidadDisponible);
        numPaginas = this.numPaginas;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    @Override
    public int calcularDiasPrestamo() {
        if (numPaginas < 300) {
            return 14;
        }
        else{
            return  7;
        }
    }

    @Override
    public String mostrarInfo() {
        return "libro" + super.mostrarInfo() + " numero de paginas " + numPaginas + "dias de prestamo " + calcularDiasPrestamo();
    }





}
