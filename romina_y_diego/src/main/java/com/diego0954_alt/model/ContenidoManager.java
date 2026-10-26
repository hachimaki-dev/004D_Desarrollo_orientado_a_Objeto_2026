package com.diego0954_alt.model;

import java.util.ArrayList;

public class ContenidoManager {

    private ContenidoManager contenidoManager;

    public ContenidoManager(){
        contenidoManager = new ContenidoManager();

    }

    public ArrayList <Contenido> getContenidos(){
        return contenidoManager.getContenidos();
    }
    
}
