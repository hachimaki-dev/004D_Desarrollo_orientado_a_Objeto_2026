public class ProductoFisico extends Producto {
    
    private int costoEnvio;

    ProductoFisico(String nombre, int precioBase, int stock, int costoEnvio){
        super(nombre, precioBase, stock);
        this.costoEnvio = costoEnvio;
    }

    @Override
    public int calcularPrecioFinal() {
        // TODO Auto-generated method stub
        return this.getPrecioBase() + this.costoEnvio;
    }

    public int getCostoEnvio(){
        return this.costoEnvio;
    }

    @Override
    public String mostrarInfo() {
        // TODO Auto-generated method stub
        return super.mostrarInfo() + ". Y el costo de envio es " + this.costoEnvio;
    }


}
