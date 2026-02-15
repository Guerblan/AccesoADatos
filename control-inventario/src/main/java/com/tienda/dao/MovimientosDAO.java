package com.tienda.dao;

import com.tienda.model.Movimiento;
import com.tienda.util.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovimientosDAO {

    // Inserta un movimiento (ENTRADA/SALIDA)
    public void registrar(Movimiento m) {
        // Lo implementaremos en el siguiente paso
    }

    // Lista todos los movimientos
    public List<Movimiento> listar() {
        return new ArrayList<>(); // Implementaremos SELECT luego
    }

    // Verifica si hay stock suficiente para una SALIDA
    public boolean validarStockSuficiente(int idProducto, int cantidad) {
        return true; // De momento devolvemos true; luego lo haremos real
    }

    // Registra y actualiza stock de producto en una sola operación
    public void registrarYActualizar(Movimiento m) {
        // Implementaremos dentro de una transacción en el siguiente paso
    }
}
