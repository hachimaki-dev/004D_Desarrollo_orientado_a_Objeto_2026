package com.vicentesoto.userapp.dao;

import com.vicentesoto.userapp.database.ConexionDB;
import com.vicentesoto.userapp.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {

    // 1. OPERACIÓN CREAR (INSERT)
    public boolean guardar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (username, correo, password, rol) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getPassword());
            ps.setString(4, usuario.getRol());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("Error al guardar usuario: " + e.getMessage());
            return false;
        }
    }
} hadasdadasddada holaaaaaaaa asdadasd