public class Revista extends Material {
    
    private String mesPublicacion;

    public Revista(String mesPublicacion, String autor, int cantidadDisponible, String titulo) {
        super(autor, cantidadDisponible, titulo);
        setMesPublicacion(mesPublicacion);
    }

    public String getMesPublicacion() {
        return this.mesPublicacion;
    }

    public final void setMesPublicacion(String mesPublicacion) {

        if (mesPublicacion == null){
            System.out.println("El titulo no puede el valor nulo.");
        }
        else if (mesPublicacion.strip().isEmpty()) {
            System.out.println("El titulo no puede estar vacio.");
        }
        else{
            this.mesPublicacion = mesPublicacion.strip();
        }
    }


    @Override
    public int calcularDiasPrestamo() {  
        return 3;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("=== REVISTA ===");
        super.mostrarInfo();
        System.out.println("Mes publicacion: " + getMesPublicacion());

    }
    
}
