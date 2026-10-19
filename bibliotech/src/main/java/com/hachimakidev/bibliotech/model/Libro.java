package com.hachimakidev.bibliotech.model;

public class Libro {
    private String nombre;
    private String autor;
    private String imagen;

    Libro() {}

    public Libro(String nombre, String autor, String imagen){
        this.nombre = nombre;
        this.autor = autor;
        this.imagen = imagen;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getAutor(){
        return this.autor;
    }

    public String getImagen(){
        return this.imagen;
    }
    
}
