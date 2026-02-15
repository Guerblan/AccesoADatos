package com.tienda.app;

import com.tienda.util.ConexionBD;
import java.sql.Connection;

public class TestConexion {
    public static void main(String[] args) {
        try (Connection con = ConexionBD.conectar()) {
            System.out.println("✅ Conexión exitosa a la base de datos");
        } catch (Exception e) {
            System.out.println("❌ Error de conexión: " + e.getMessage());
        }
    }
}