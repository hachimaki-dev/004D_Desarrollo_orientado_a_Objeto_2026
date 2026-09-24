public abstract class Materiales {
    private String titulo;
    private String autor;
    private int cantidadDisponible;

    Materiales(String titulo, String autor, int cantidadDisponible){
        this.autor = autor;
        this.titulo = titulo;
        this.cantidadDisponible = cantidadDisponible;
    }

    String getTitulo(){
        return this.titulo;
    }

    String getAutor(){
        return this.autor;
    }

    int getCantidadDisponible(){
        return this.cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible){
        if (this.cantidadDisponible < 0) {
            System.out.println("ERROR, debes ingresar una cantidad que se entera positiva");
        }
        else {
            System.out.println("Cantidad registrada");
        }
    }

    public abstract int calcularDiasPrestamo();

    String mostrarInfo(){
        return "Titulo: " + this.getTitulo() + "" +  " Dias de prestamo: " + calcularDiasPrestamo() + "" + " Autor: " + this.getAutor() + " Cantidad disponible: " + "" + this.getCantidadDisponible();
    }
}
