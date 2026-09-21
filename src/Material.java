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

    public void setCantidadDisponible(int cantidadDisponible) {
        if (cantidadDisponible<0){
            System.out.println("Debe ser un numero entero positivo");
        }else{
        this.cantidadDisponible = cantidadDisponible;}
    }

    public abstract int calcularDiasPrestamo();

    public String mostrarInfo(){
        return "Titulo: " + this.getTitulo() + ". Autor: " + this.getAutor() + ". Cantidad disponible: " + this.getCantidadDisponible() + 
        ". Dias de prestamo: " + calcularDiasPrestamo();
    }
}
