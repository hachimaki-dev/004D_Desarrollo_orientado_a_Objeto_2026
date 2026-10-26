package com.hachimakidev.biblioapp.model;

public class Revista extends Material {
    private String editorial;
    private String periodicidad;

     public Revista(String nombre, String titulo, int publicacion, String editorial, String periodicidad) {
        super(nombre, titulo, publicacion);
        this.editorial = editorial;
        this.periodicidad = periodicidad;
    }

 public String getEditorial() {
        return editorial;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }



}
