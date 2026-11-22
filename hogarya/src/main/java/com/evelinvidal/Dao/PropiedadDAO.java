package com.evelinvidal.Dao;

import com.evelinvidal.HogarYa.Conexion.ConexionDB;
import com.evelinvidal.Modelo.Casa;
import com.evelinvidal.Modelo.Departamento;
import com.evelinvidal.Modelo.Propiedad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PropiedadDAO {

    public List<Propiedad> listar() {
        List<Propiedad> lista = new ArrayList<>();
        String sql = "SELECT * FROM propiedades ORDER BY id";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String tipo = rs.getString("tipo");
                String direccion = rs.getString("direccion");
                int arriendoBase = rs.getInt("arriendo_base");
                int metrosCuadrados = rs.getInt("metros_cuadrados");

                if ("CASA".equalsIgnoreCase(tipo)) {
                    int cantidadPisos = rs.getInt("cantidad_pisos");
                    boolean tienePatio = rs.getInt("tiene_patio") == 1;
                    lista.add(new Casa(id, direccion, arriendoBase, metrosCuadrados, cantidadPisos, tienePatio));
                } else if ("DEPARTAMENTO".equalsIgnoreCase(tipo)) {
                    int numeroPiso = rs.getInt("numero_piso");
                    int gastosComunes = rs.getInt("gastos_comunes");
                    lista.add(new Departamento(id, direccion, arriendoBase, metrosCuadrados, numeroPiso, gastosComunes));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al listar propiedades: " + e.getMessage());
        }
        return lista;
    }

    public boolean insertar(Propiedad p) {
        String sql = "INSERT INTO propiedades (tipo, direccion, arriendo_base, metros_cuadrados, " +
                     "cantidad_pisos, tiene_patio, numero_piso, gastos_comunes) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getTipo());
            ps.setString(2, p.getDireccion());
            ps.setInt(3, p.getArriendoBase());
            ps.setInt(4, p.getMetrosCuadrados());

            if (p instanceof Casa casa) {
                ps.setInt(5, casa.getCantidadPisos());
                ps.setInt(6, casa.isTienePatio() ? 1 : 0);
                ps.setNull(7, Types.INTEGER);
                ps.setNull(8, Types.INTEGER);
            } else if (p instanceof Departamento depto) {
                ps.setNull(5, Types.INTEGER);
                ps.setNull(6, Types.INTEGER);
                ps.setInt(7, depto.getNumeroPiso());
                ps.setInt(8, depto.getGastosComunes());
            }

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar propiedad: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizar(Propiedad p) {
        String sql = "UPDATE propiedades SET tipo = ?, direccion = ?, arriendo_base = ?, metros_cuadrados = ?, " +
                     "cantidad_pisos = ?, tiene_patio = ?, numero_piso = ?, gastos_comunes = ? " +
                     "WHERE id = ?";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getTipo());
            ps.setString(2, p.getDireccion());
            ps.setInt(3, p.getArriendoBase());
            ps.setInt(4, p.getMetrosCuadrados());

            if (p instanceof Casa casa) {
                ps.setInt(5, casa.getCantidadPisos());
                ps.setInt(6, casa.isTienePatio() ? 1 : 0);
                ps.setNull(7, Types.INTEGER);
                ps.setNull(8, Types.INTEGER);
            } else if (p instanceof Departamento depto) {
                ps.setNull(5, Types.INTEGER);
                ps.setNull(6, Types.INTEGER);
                ps.setInt(7, depto.getNumeroPiso());
                ps.setInt(8, depto.getGastosComunes());
            }

            ps.setInt(9, p.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar propiedad: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM propiedades WHERE id = ?";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar propiedad: " + e.getMessage());
            return false;
        }
    }
}
