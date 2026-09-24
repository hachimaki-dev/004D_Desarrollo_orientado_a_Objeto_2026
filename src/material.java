public class Material {
//estos son los rasgos unicos que la clase padre "material"
    private String titulo;
    private String autor;
    private int cantidad_disponible;

    Material(String titulo, String autor , int cantidad_disponible){
        this.titulo = titulo;
        this.autor = autor ;
        this.cantidad_disponible = cantidad_disponible;
    }

    public String getTitulo(){
        return this.titulo;
    }
    
    public String getAutor(){
        return this.autor;
    }

    public int getCantidad_disponible(){
        return this.cantidad_disponible;
    }

    public void setCantidad_disponible(int Cantidad_disponible){
        return this.Cantidad_disponible = Cantidad_disponible;
    }

    public int Cantidad_de_dias_prestamo(){
        return this.Cantidad_de_dias_prestamo();
    }

    @Override 
    public static void MostrarInfo(){
        return MostrarInfo();
    }

    
}

