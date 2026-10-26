package com.hachimakidev.biblioapp.model;

public class Revistas extends Material{
    
    private String editorial;
    private String periodicidad;

    public Revistas(String titulo, String fechaPublicacion, String editorial, String periodicidad){
        super(titulo, fechaPublicacion);
        this.editorial = editorial;
        this.periodicidad = periodicidad;
    }

    public String get_editorial(){
        return editorial;
    }

    public String getPeriodicidad(){
        return periodicidad;
    }

}
