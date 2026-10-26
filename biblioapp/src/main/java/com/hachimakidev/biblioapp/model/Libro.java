package com.hachimakidev.biblioapp.model;

public class Libro extends Material {

    private String autor;
    private int paginas;

    public Libro(String nombre, String titulo, int publicacion, String autor, int paginas) {
        super(nombre, titulo, publicacion);
        this.autor = autor;
        this.paginas = paginas;
    }

    
    public String getAutor() {
        return autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

}
