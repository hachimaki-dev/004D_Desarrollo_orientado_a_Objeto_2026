package com.hachimakidev.biblioapp.model;

public class Libro extends Material {
    private String autor;
    private String paginas;

    public Libro(String nombre, String titulo, String publicacion, String autor, String editorial, String paginas) {
        super(nombre, titulo, publicacion);
        this.autor = autor;
        this.paginas = paginas; 
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getPaginas() {
        return paginas;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }
    
}
