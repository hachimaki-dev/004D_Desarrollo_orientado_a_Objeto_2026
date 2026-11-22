package com.agcamila01.hogarya.controller;

import java.util.ArrayList;

import com.agcamila01.hogarya.dao.PropiedadDAO;
import com.agcamila01.hogarya.model.Casa;
import com.agcamila01.hogarya.model.Departamento;
import com.agcamila01.hogarya.model.Propiedad;

public class PropiedadController {
    private PropiedadDAO propiedadDAO;

    public PropiedadController() {
        this.propiedadDAO = new PropiedadDAO();
    }

    public boolean registrarPropiedad(Propiedad propiedad) {
        if (propiedad == null || propiedad.getDireccion() == null || propiedad.getDireccion().isBlank() ||
            propiedad.getArriendoBase() <= 0 || propiedad.getMetrosCuadrados() <= 0) {
                return false;
        }

        if (propiedad instanceof Casa casa) {
            if (casa.getCantidadPisos() <= 0) {
                return false;
            }
        } else if (propiedad instanceof Departamento departamento) {
            if (departamento.getGastosComunes() < 0) {
                return false;
            }
        } else {
            return false;
        }

        return propiedadDAO.guardarPropiedad(propiedad);
    }

    public ArrayList<Propiedad> obtenerPropiedades() {
        return propiedadDAO.obtenerPropiedades();
    }

    public boolean actualizarPropiedad(Propiedad propiedad) {
        if (propiedad == null || propiedad.getId() <= 0 || propiedad.getDireccion() == null ||
            propiedad.getDireccion().isBlank() || propiedad.getArriendoBase() <= 0 || propiedad.getMetrosCuadrados() <= 0) {
            
            return false;
        }

        if (propiedad instanceof Casa casa) {
            if (casa.getCantidadPisos() <= 0) {
                return false;
            }
        } else if (propiedad instanceof Departamento departamento) {
            if (departamento.getGastosComunes() < 0) {
                return false;
            }
        } else {
            return false;
        }

        return propiedadDAO.actualizarPropiedades(propiedad);
    } 
    
    public boolean eliminarPropiedad(int id) {
        if (id <= 0) {
            return false;
        }
        
        return propiedadDAO.eliminarPropiedad(id);
    }
}
