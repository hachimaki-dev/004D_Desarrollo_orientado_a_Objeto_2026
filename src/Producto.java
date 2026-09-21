public class Producto {
    private String nombre;
    private int precioBase;
    private int stock;

    public void Producto(String nombre_a_asignar, int precio_base_a_asignar, int stock_a_asignar){
        
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPrecioBase() {
        return precioBase;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

    public int calcularPrecioFinal(){
        return 67;
    }

    public String mostrarInfo(){
        return null;
    }
}
