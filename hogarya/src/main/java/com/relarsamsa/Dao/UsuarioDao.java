package com.relarsamsa.Dao;

import com.relarsamsa.Model.Propiedad;

public class UsuarioDAO {

    // 1. OPERACIÓN CREAR (INSERT)
    public boolean guardar(Propiedad propiedades) {
        String sql = "INSERT INTO propiedades (id, direccion, arriendoBase, metrosCuadrados) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, propiedades.getId());
            ps.setString(2, propiedades.getDireccion());
            ps.setString(3, propiedades.getArriendoBase());
            ps.setString(4, propiedades.getMetrosCuadrados());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("Error al guardar propiedades: " + e.getMessage());
            return false;
        }
    }



        // 2. OPERACIÓN LEER TODOS (SELECT)
    public ArrayList<Propiedad> obtenerTodos() {
        ArrayList<Propiedad> lista = new ArrayList<>();
        String sql = "SELECT id, direccion, arriendoBase, metrosCuadrados FROM propiedades ORDER BY id ASC";

        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql); 
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String direccion = rs.getString("direccion");
                int arriendoBase = rs.getString("arriendoBase");
                int metrosCuadrados = rs.getString("metrosCuadrados");

                Propiedad u = new propiedad(id, direccion, arriendoBase, metrosCuadrados);
                lista.add(u);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar propiedades: " + e.getMessage());
        }
        return lista;
    }


        // 3. OPERACIÓN ACTUALIZAR (UPDATE)
    public boolean actualizar(Propiedad propiedades) {
        String sql = "UPDATE usuarios SET username = ?, correo = ?, password = ?, rol = ? WHERE id = ?";

        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, propiedades.getDireccion());
            ps.setString(2, propiedades.arriendoBase());
            ps.setString(3, propiedades.metrosCuadrados());
            ps.setInt(4, propiedades.getId()); // El 5° signo '?' corresponde al WHERE id = ?

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar propiedades: " + e.getMessage());
            return false;
        }
    }

    // 4. OPERACIÓN ELIMINAR (DELETE)
    public boolean eliminar(int id) {
        String sql = "DELETE FROM propiedades WHERE id = ?";

        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
            return false;
        }
    }
}