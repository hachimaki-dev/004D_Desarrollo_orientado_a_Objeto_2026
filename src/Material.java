public abstract class Material {
    
    private String titulo ;
    private String autor ;
    private int  cantidad_disponible ;

    Material(String titulo , String autor , int  cantidad_disponible){
        this.titulo = titulo ;
        this.autor = autor ;
        this.cantidad_disponible = cantidad_disponible ;
    }


    public String gettitulo(){
        return  this.titulo ;
    }

    public String getautor(){
        return  this.autor ;
    }



    public  int getcantidad_disponible(){
        return  this.cantidad_disponible;
    }




    public void  setcantidad_disponible(int cantidad_disponible){
        this.cantidad_disponible = cantidad_disponible ;
    }


    public  abstract int calcularDiasPrestamo() ;


    public String mostrarinfo(){
        return  "| Titulo :" + this.gettitulo() + " |  Autor :" + this.getautor() + " |  Cantidad_disponible : " + this.getcantidad_disponible();
    }




}
