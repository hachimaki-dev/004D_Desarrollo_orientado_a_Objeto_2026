package com.evelinvidal.Controller;

import com.evelinvidal.Dao.PropiedadDAO;
import com.evelinvidal.Modelo.Casa;
import com.evelinvidal.Modelo.Departamento;
import com.evelinvidal.Modelo.Propiedad;
import java.util.List;
public class PropiedadController {
    private final PropiedadDAO dao;

    public PropiedadController() {
        this.dao = new PropiedadDAO();
    }

    public List<Propiedad> obtenerTodas() {
        return dao.listar();
    }

    public boolean guardarCasa(String direccion, int arriendo, int m2, int pisos, boolean patio) {
        Casa nueva = new Casa(0, direccion, arriendo, m2, pisos, patio);
        return dao.insertar(nueva);
    }

    public boolean guardarDepartamento(String direccion, int arriendo, int m2, int numPiso, int gastos) {
        Departamento nuevo = new Departamento(0, direccion, arriendo, m2, numPiso, gastos);
        return dao.insertar(nuevo);
    }

    public boolean actualizarCasa(int id, String direccion, int arriendo, int m2, int pisos, boolean patio) {
        Casa editada = new Casa(id, direccion, arriendo, m2, pisos, patio);
        return dao.actualizar(editada);
    }

    public boolean actualizarDepartamento(int id, String direccion, int arriendo, int m2, int numPiso, int gastos) {
        Departamento editado = new Departamento(id, direccion, arriendo, m2, numPiso, gastos);
        return dao.actualizar(editado);
    }

    public boolean eliminarPropiedad(int id) {
        return dao.eliminar(id);
    }
}