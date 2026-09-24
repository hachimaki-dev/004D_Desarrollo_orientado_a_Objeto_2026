public abstract class Material {

    private String titulo;
    private String autor;
    private int cantidadDisponible;

    public Material(String titulo, String autor, int cantidadDisponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.cantidadDisponible = cantidadDisponible;
    }


    public String getTitulo(){
        return titulo;
    }
   
    public String getAutor(){
        return autor;
    }

    public int getCantidadDisponible(){
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible){
        this.cantidadDisponible = cantidadDisponible;
    }

    public abstract int calcularDiasPrestamo();
        

    public String mostraInfo(){
        return "Titulo: " + getTitulo() + "|| Autor: " + getAutor() + "|| cantidad disponible: " + getCantidadDisponible() + "|| Dias de prestamo: " + calcularDiasPrestamo();
    }

}

