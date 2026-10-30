package com.hachimakidev.techstore.controller;

import java.util.ArrayList;

import com.hachimakidev.techstore.model.Dispositivo;
import com.hachimakidev.techstore.model.DispositivoManager;

public class DispositivoController {
    
    private  DispositivoManager manager = new DispositivoManager();
    

    public  ArrayList<Dispositivo> obtenerdispositivos(){
        return manager.getDispositivos();     
    }


    public void agregar_dispositivo(Dispositivo nuevo){ 
        manager.agregarDispositivo(nuevo);      
    }



}

