package com.hachimakidev.biblioapp.model;

public abstract class Material {
    private String nombre;
    private String titulo;
    private String publicacion;

    public Material(String nombre, String titulo, String publicacion) {
        this.nombre = nombre;
        this.titulo = titulo;
        this.publicacion = publicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(String publicacion) {
        this.publicacion = publicacion;
    }
}
