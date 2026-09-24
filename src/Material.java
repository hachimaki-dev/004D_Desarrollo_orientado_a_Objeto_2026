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
    
    public abstract int calcularDiasPrestamo();

    public String mostrarInfo(){
        return "el titulo es: " + getTitulo() + " | el autor es: " + getAutor() + " | la cantidad disponible es de: " + getCantidadDisponible() + calcularDiasPrestamo();
    }

}
