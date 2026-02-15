package com.tienda.model;

public class Producto {
    private int id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private int stock;
    private int stockMinimo;

    public Producto() {
    }

    public Producto(String codigo, String nombre, String descripcion, int stock, int stockMinimo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    @Override
    public String toString() {
        return id + " | " + codigo + " | " + nombre + " | Stock: " +
                stock + " (Mínimo: " + stockMinimo + ")";
    }
}
