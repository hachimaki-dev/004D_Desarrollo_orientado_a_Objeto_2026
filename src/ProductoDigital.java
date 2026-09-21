public class ProductoDigital extends Producto{
    private int descuento;
    private String plataforma;

    public void productoDigital(String nombre, int precioBase, int stock, int descuento, String plataforma){

    }

    public int getDescuento() {
        return descuento;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public int calcularPrecioFinal(){
        return 67;
    }

    public String mostrarInfo(){
        return null;
    }
}
