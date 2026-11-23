package com.caso2_franco_dietert.controller;

import com.caso2_franco_dietert.dao.PropiedadDAO;
import java.util.ArrayList;
import com.caso2_franco_dietert.model.Propiedad;

public class PropiedadController {

    
    private PropiedadDAO dao = new PropiedadDAO();

    public ArrayList<Propiedad> listarPropiedades (){

        return dao.listarPropiedades();
    }

    public void insertarPropiedad (Propiedad propiedad) {

        dao.insertarPropiedad(propiedad);
    }

    public void eliminarPropiedad (int id) {

        dao.eliminarPropiedad(id);
    }

    public void actualizarPropiedad (Propiedad propiedad) {

        dao.actualizarPropiedad(null);
    }
}
