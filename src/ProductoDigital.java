public class ProductoDigital extends Producto{
    private int descuento;
    private String plataforma;

    ProductoDigital(String nombre, int precioBase, int stock, int descuento, String plataforma){
        super(nombre, precioBase, stock);
        this.descuento = descuento;
        this.plataforma = plataforma;
    }

    public int getDescuento(){
        return this.descuento;
    }

    public String getPlataforma(){
        return this.plataforma;
    }

    @Override
    public int calcularPrecioFinal() {
        return (getPrecioBase() * this.descuento) / 100 ;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " . El descuento es " + this.descuento + " . Plataforma: " + this.plataforma;
    }

}
