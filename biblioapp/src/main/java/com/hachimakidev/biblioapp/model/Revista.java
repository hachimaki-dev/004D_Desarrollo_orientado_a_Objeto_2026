package com.hachimakidev.biblioapp.model;

public class Revista extends Material {
    private String periodicidad;
    private String editorial;

    public Revista(String nombre, String titulo, String publicacion, String autor, String editorial, String paginas, String periodicidad) {
        super(nombre, titulo, publicacion);
        this.periodicidad = periodicidad;
        this.editorial = editorial;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    
    
}
