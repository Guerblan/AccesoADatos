package com.tienda.model;

import java.time.LocalDateTime;

public class Movimiento {
    private int id;
    private int idProducto;
    private String tipo; // "ENTRADA" o "SALIDA"
    private int cantidad;
    private LocalDateTime fecha;

    public Movimiento() {
    }

    public Movimiento(int idProducto, String tipo, int cantidad) {
        this.idProducto = idProducto;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + tipo + " - " + cantidad + " unidades (producto " + idProducto + ")";
    }
}