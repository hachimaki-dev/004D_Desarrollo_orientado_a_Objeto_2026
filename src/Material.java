public class Material {
    
    private String titulo;
    private String autor;
    private int EjemplaresDisponibles;


    public Material (String titulo, String autor, int ejemplaresDisponibles) {

        this.titulo = titulo;
        this.autor = autor;
        this.EjemplaresDisponibles = ejemplaresDisponibles;
    }


    
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public int getEjemplaresDisponibles() {
        return EjemplaresDisponibles;
    }
    public void setEjemplaresDisponibles(int ejemplaresDisponibles) {
        EjemplaresDisponibles = ejemplaresDisponibles;
    }

    static int CalcularDiasPrestamo(){
        return 0;
    }
}