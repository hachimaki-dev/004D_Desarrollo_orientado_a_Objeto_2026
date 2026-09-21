public abstract class Material {
    private String titulo;
    private String autor;
    private int cantidadDisponible;

    Material(String titulo, String autor, int cantidadDisponible){
        this.titulo = titulo;
        this.autor = autor;
        this.cantidadDisponible = cantidadDisponible;
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

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        if (cantidadDisponible < 0) {
            System.out.println("Cantidad insuficiente. ");
        }else{
            this.cantidadDisponible = cantidadDisponible;
            System.out.println("Cantidad si se encuentra disponible.");
        }
    }

    public int calcularDiasPrestamo(){
        return cantidadDisponible;
    } 
    
    public String mostrarInfo(){
        return this.getTitulo() + "Nombre del libro: " + this.getAutor() + "Nombre del autor: " + this.getCantidadDisponible() + "Cantidad: ";
    }

}
