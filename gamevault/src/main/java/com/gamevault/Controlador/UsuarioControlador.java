package com.gamevault.Controlador;
import com.gamevault.model.Usuario;
import com.gamevault.model.UsuarioManager;


public class UsuarioControlador {
    private UsuarioManager manager;

    public UsuariorControlador() {
        manager = new UsuariorManager();
    }

    public boolean datosDisponibles() {
        return manager.isDatosCargados();
    }

    public Usuario buscarUsuario(String rut_ingresado) {
        String rut_limpio = rut_ingresado.trim();
        return manager.buscarPorRut(rut_limpio);
    }
    

}
