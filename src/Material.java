public class Material {
    String titulo;
    String autor;
    int cantidadDisponible;

    Material(String titulo,String autor,int cantidadDisponible){
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

    public void setCantidadDispobible(int cantidadDisponible){
        this.cantidadDisponible = cantidadDisponible;
    }

    public abstract int calcularDiasPrestamo();

    public String mostrarInfo(){
        
    }
}

