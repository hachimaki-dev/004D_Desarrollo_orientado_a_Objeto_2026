public abstract class Material {
    private String titulo;
    private String autor;
    private int cantidadDisponible;

    public Material(String titulo, String autor, int cantidadDisponible){
        this.titulo = titulo;
        this.autor = autor;
        setCantidadDisponible(cantidadDisponible);
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public int getCantidadDisponible() {
        return this.cantidadDisponible;
    }

    public void setCantidadDisponible (int cantidad) {
        this.cantidadDisponible = cantidad;
    }

    public abstract int calcularDiasPrestamo();

    public String mostrarInfo() {
        return "Título: " + this.titulo + "\nAutor: " + this.autor + "\nDías de préstamo: " + this.calcularDiasPrestamo() + "\nCantidad Disponible: " + this.cantidadDisponible;
    }
    
}
