package com.hachimakidev.biblioapp.model;

public abstract class Material {
    private String nombre;
    private String titulo;
    private int publicacion;
    


public Material(String nombre, String titulo, int publicacion) {
        this.nombre = nombre;
        this.titulo = titulo;
        this.publicacion = publicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPublicacion() {
        return publicacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPublicacion(int publicacion) {
        this.publicacion = publicacion;
    }
       
}