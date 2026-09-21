public abstract class Material{
    private String titulo;
    private String autor;
    private int cantidadDisponible;

    public void Material(String titulo, String autor, int cantidadDisponible){
        setTitulo(titulo);
        setAutor(autor);
        setCantidadDisponible(cantidadDisponible);

    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        if(titulo == null || titulo.trim()isEmpty()){
        
        }
        this.titulo = titulo
    }
    public String getAutor(){
        return autor;
    }
    public void setTitulo(String autor){
        if(autor == null || autor.trim()isEmpty()){
        }
        this.autor = autor
    }
    public int getCantidadDisponible(){
        return cantidadDisponible;
    }
    public void setCantidadDisponible(int cantidadDisponible){
        if (cantidadDisponible < 0){
            throw new 
        
        }
        this.cantidadDisponible = cantidadDisponible;
    }
     
    public double abstract calcularDiasPrestamo(int);
    
    public String mostrarInfo(){
        "|Titulo: " + this.titulo +
        "|Autor" + this.autor +
        "|Dias de Prestamo: " + this.calcularDiasPrestamo +
        "|Cantidad Disponible: " + this.cantidadDisponible

    }
    }
}   