public abstract class Material 
{
    private String titulo;
    private String autor;
    private int cantidadDisponible;
   
    public Material(String titul, String autor, int cantidadDisponible) 
    {
        this.titulo = titul;
        this.autor = autor;
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getTitulo() 
    {
        return titulo;
    }

    public String getAutor() 
    {
        return autor;
    }

    public int getCantidadDisponible() 
    {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) 
    {
        this.cantidadDisponible = cantidadDisponible;
    }

    public abstract int calcularDiasPrestamo();

    public String mostrarInfo()
    {
     return "Material " + 
            " | Titulo: " + titulo +
            " | Autor: " + autor + 
            " | Cantidad disponible: " + cantidadDisponible;
    }
    
    
    
}
