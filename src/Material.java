public class Material {
    
    private String titulo;
    private String autor;
    private int cantidadDisponibles;


    public Material (String titulo, String autor, int ejemplaresDisponibles) {

        this.titulo = titulo;
        this.autor = autor;
        this.cantidadDisponibles = ejemplaresDisponibles;
    }


    public void setCantidadDisponibles(int cantidadDisponibles) {
        this.cantidadDisponibles = cantidadDisponibles;
    }


    public String getTitulo() {
        return titulo;
    }


    public String getAutor() {
        return autor;
    }


    public int getCantidadDisponibles() {
        return cantidadDisponibles;
    }


    static int calcularDiasDePrestamo (){

        return 0;
    }

   
    }
  