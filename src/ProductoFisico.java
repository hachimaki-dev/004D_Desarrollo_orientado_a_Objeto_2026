public class ProductoFisico extends Producto{
    private int costoDeEnvio;

    public void ProductoFisico(String nombre, int precioBase, int stock){

    }

    public int getCostoDeEnvio() {
        return costoDeEnvio;
    }

    public int calcularPrecioFinal(){
        return 67;
    }

    public String mostrarInfo(){
        return null;
    }
}
