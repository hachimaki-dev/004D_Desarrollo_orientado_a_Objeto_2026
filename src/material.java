public abstract class material {
    private String titulo;
    private String autor;
    private int cantidadDisponible;

    material(String titulo,String autor, int cantidadDisponible){
        titulo = this.titulo;
        autor = this.autor;
        cantidadDisponible = this.cantidadDisponible;
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

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public abstract int calcularDiasPrestamo();

    public String mostrarInfo(){
        return "titulo " + getTitulo() + "autor " + getAutor() + "disponible " + getCantidadDisponible(); 
    }


}
