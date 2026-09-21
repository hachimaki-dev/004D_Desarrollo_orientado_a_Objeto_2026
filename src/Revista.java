public class Revista extends Material {
    
    private  String mes_publicacion  ;

    Revista(String titulo , String autor , int  cantidad_disponible , String mes_publicacion){

            super(titulo, autor, cantidad_disponible);
            this.mes_publicacion = mes_publicacion ;        

    }


    public  String get_mes_publicacion(){
        return  this.mes_publicacion ;
    }



    @Override
    public int calcularDiasPrestamo() {
        return 3 ;
    }

    @Override
    public String mostrarinfo() {
        return "Tipo : Revista " +super.mostrarinfo() + " |  Mes de Publicacion : " + get_mes_publicacion() + " | Precio final :" + this.calcularDiasPrestamo();
    }


}
