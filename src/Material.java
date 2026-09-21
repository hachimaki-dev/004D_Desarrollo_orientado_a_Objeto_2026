public abstract class Material {
    private String Titulo;
    private String autor;
    private int CantidadDisponible;

    Material(String Titulo, String autor,int CantidadDisponible){
        this.Titulo = Titulo;
        this.autor = autor;
        this.CantidadDisponible = CantidadDisponible;
    }

    public String getTitulo(){
        return this.Titulo;
    }

    public String getautor(){
        return  this.autor;
    }
    public int getCantidadDisponible(){
        return this.CantidadDisponible;
    }
    public void getsetCantidadDisponible(int CantidadDisponible ){
        this.CantidadDisponible = CantidadDisponible;  

    }

    public abstract void calcularDiasprestamo();

    public String mostrarInfo(){
        return "titulo" +  this.Titulo + "autor:" + this.autor; 
    }
    
}
