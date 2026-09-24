public abstract class Material {
    private String titulo;
    private String autor;
    private int cantidadDisponible;

    Material(String titulo, String autor, int cantidadDisponible){
        this.titulo = titulo;
        this.autor = autor;
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public String getAutor(){
        return this.autor;
    }

    public int getCantidadDisponible(){
        return this.cantidadDisponible;
    }

    public void setCatidadDisponible(int cantidadDisponible){
    }

    public abstract int calcularDiasPrestamo();

    public String mostrarInfo(){
        return "Titulo: " + this.titulo + 
        " Autor: " + this.autor + 
        " Dias prestados: " + this.calcularDiasPrestamo() +
        " Libros disponibles: " + this.getCantidadDisponible();
    }
}