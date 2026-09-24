public abstract class Materiales {
    private String titulo;
    private String autor;
    private int cantidadDisponible;


    public void main(String titulo, String autor, int cantidadDisponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.cantidadDisponible = cantidadDisponible;
    }

    public String gettitulo(){
        return this.titulo;
    }

    public String getautor(){
        return this.autor;
    }

    public int getcantidadDisponible(){
        return this.cantidadDisponible;
    }

    

}

