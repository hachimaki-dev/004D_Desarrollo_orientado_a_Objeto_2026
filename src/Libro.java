public class Libro extends Material {
    
    private int numero_d_paginas  ;


    Libro(String titulo , String autor , int  cantidad_disponible , int numero_d_paginas ){

        super(titulo, autor, cantidad_disponible);
        this.numero_d_paginas = numero_d_paginas ;

    }



    public  int get_numero_paginas(){
        return  this.numero_d_paginas ;
    }

    @Override
    public int calcularDiasPrestamo() {
        if (get_numero_paginas() > 300) {
            return  14  ;
        }else {
            return  7 ;
        }
    }


    @Override
    public String mostrarinfo() {
        return " Tipo : Libro  " + super.mostrarinfo() + " | Numero de Paginas :" + this.get_numero_paginas() + " | Dias Prestados : " + this.calcularDiasPrestamo();
    }


}
