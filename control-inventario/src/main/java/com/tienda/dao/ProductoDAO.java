package com.tienda.dao;

import com.tienda.model.Producto;
import com.tienda.util.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    public void guardar(Producto p) {
        String sql = "INSERT INTO producto (codigo, nombre,descripcion, stock, stock_minimo) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConexionBD.conectar();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, p.getCodigo());
            stmt.setString(2, p.getNombre());
            stmt.setString(3, p.getDescripcion());
            stmt.setInt(4, p.getStock());
            stmt.setInt(5, p.getStockMinimo());
            stmt.executeUpdate();
            System.out.println("✅ Producto guardado correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al guardar producto: " +
                    e.getMessage());
        }
    }

    public List<Producto> listar() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM producto";
        try (Connection con = ConexionBD.conectar();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt("id"));
                p.setCodigo(rs.getString("codigo"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setStock(rs.getInt("stock"));
                p.setStockMinimo(rs.getInt("stock_minimo"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al listar productos: " +
                    e.getMessage());
        }
        return lista;
    }

    public Producto buscarPorCodigo(String codigo) {
        String sql = "SELECT * FROM producto WHERE codigo = ?";
        Producto p = null;
        try (Connection con = ConexionBD.conectar();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                p = new Producto();
                p.setId(rs.getInt("id"));
                p.setCodigo(rs.getString("codigo"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setStock(rs.getInt("stock"));
                p.setStockMinimo(rs.getInt("stock_minimo"));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al buscar producto: " +
                    e.getMessage());
        }
        return p;
    }

    public void actualizarStock(int idProducto, int nuevoStock) {
        String sql = "UPDATE producto SET stock = ? WHERE id = ?";
        try (Connection con = ConexionBD.conectar();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, nuevoStock);
            stmt.setInt(2, idProducto);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar stock: " +
                    e.getMessage());
        }
    }
}
