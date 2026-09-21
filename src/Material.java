public abstract class Material {
    private String Titulo;
    private String Autor;
    private int CantidadDisponible;

    public Material(String Titulo, String Autor, int CantidadDisponible){
    this.Titulo = Titulo;
    this.Autor = Autor;
    this.CantidadDisponible = CantidadDisponible;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public int getCantidadDisponible() {
        return CantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        CantidadDisponible = cantidadDisponible;
    }
    
    public abstract void calcularDiasPrestamo();

    public void mostrarInfo(){
        System.out.println("el titulo es: " + Titulo + "el autor es: " + Autor + "la cantidad disponible es de: " + CantidadDisponible);
    }

}
