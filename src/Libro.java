public class Libro extends Material {
    int numPginas;

    Libro(String Titulo,String autor, int CantidadDisponible,int numPginas){
    super(Titulo,autor,CantidadDisponible);
    this.numPginas = numPginas;

}

public int numPginas(){
    return this.numPginas;
}


@Override 
public void calcularDiasprestamo(){
    System.out.println("ingrese el numero de paginas ");
    if (numPginas > 300) {
        System.out.println(" dias habiles del pretamo: 14 dias");
        
    }else{
        System.out.println("dias habile de prestamo: 7 dias");
    }

}

@Override 
public String mostrarInfo(){
    return super.mostrarInfo() + "numero de paginas:" + this.numPginas;
}
    
}
