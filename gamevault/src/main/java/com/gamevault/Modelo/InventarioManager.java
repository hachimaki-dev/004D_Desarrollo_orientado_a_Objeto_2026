package com.gamevault.Modelo;

import java.util.ArrayList;
import java.util.List;

public class InventarioManager {

    private List<Videojuego> listaVideojuegos;
    private boolean datosCargados;

    public InventarioManager() {
        this.listaVideojuegos = new ArrayList<>();
        this.datosCargados = false;
        cargarDatosIniciales();
    }

    private void cargarDatosIniciales() {
        listaVideojuegos.add(new Videojuego("Zelda: Tears of the Kingdom", "Nintendo Switch", 59.99, 10));
        listaVideojuegos.add(new Videojuego("God of War Ragnarök", "PlayStation 5", 69.99, 5));
        this.datosCargados = !listaVideojuegos.isEmpty();
    }

    public boolean isDatosCargados() {
        return datosCargados;
    }

    public List<Videojuego> obtenerListaVideojuegos() {
        return listaVideojuegos;
    }

    public Videojuego buscarPorTitulo(String titulo) {
        if (titulo == null) {
            return null;
        }
        for (Videojuego v : listaVideojuegos) {
            if (v.getTitulo().equalsIgnoreCase(titulo)) {
                return v;
            }
        }
        return null;
    }

    public boolean agregarVideojuego(Videojuego nuevoJuego) {
        if (nuevoJuego != null && !listaVideojuegos.contains(nuevoJuego)) {
            listaVideojuegos.add(nuevoJuego);
            datosCargados = true;
            return true;
        }
        return false;
    }
}