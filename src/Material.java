public abstract class Material {
    private String titulo;
    private String autor;
    private int cantidadDisponible;

    public Material(String titulo, String autor, int cantidadDisponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public int calcularDiasPrestamo(){
        return 0;
    }

    public String mostrarInfo(){
        return "Titulo: " + this.titulo + " Autor: " + this.autor + " Dias de prestamo: " + calcularDiasPrestamo() + " Cantidad Disponible: " + this.cantidadDisponible;
    }
}
