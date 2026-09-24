public class Libros extends material{
    private int numPaginas;
//la clase hijo de libro hereda de la clase padre y se le suma algo que lo haga distinto
    Libros(String titulo, String autor, int cantidad_disponible,int numPaginas){

        super(titulo,autor,cantidad_disponible){
            this.numPaginas = numPaginas;
        }
        
    }

    public int getNumPaginas(){
        this.numPaginas;
    }

    public int calular_dias_prestamos(){
        if(getNumPaginas()>300){
            return 14;
        }{else
            return 7;
        }

    public String MostrarInfo(){
        return this.MostrarInfo();

    }
    
}
}