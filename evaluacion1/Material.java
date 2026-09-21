public abstract class Material {
    private String titulo;
    private String autor;
    private int cantidadDisponible;

    Material(String titulo, String autor, int cantidadDisponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        if (cantidadDisponible < 0) {
            System.out.println("La cantidad no puede ser negativa");
        } else {
            this.cantidadDisponible = cantidadDisponible;
        }
    }

    public int getCantidadDisponible() {
        return this.cantidadDisponible;
    }

    public abstract int calcularDiasPrestamo();

    public String mostrarInfo() {
        return "Título: " + getTitulo() + " | Autor: " + getAutor() + " | Cantidad: " + getCantidadDisponible() + " | Días de prestamo: " + calcularDiasPrestamo();
    }
}
