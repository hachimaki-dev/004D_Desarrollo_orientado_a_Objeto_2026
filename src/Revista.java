public class Revista extends Material{
    String mesPublicacion;

    Revista(String titulo,String autor,int cantidadDisponible,int numPaginas,String mesPublicacion){
        this.titulo = titulo;
        this.autor = autor;
        this.cantidadDisponible = cantidadDisponible;
        this.numPaginas = numPaginas;
        this.mesPublicacion = mesPublicacion;
    }

    public int getMesPublicacion(){
        return this.mesPublicacion;
    }
}
