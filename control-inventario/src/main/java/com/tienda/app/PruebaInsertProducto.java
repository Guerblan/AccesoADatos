package com.tienda.app;

import com.tienda.dao.ProductoDAO;
import com.tienda.model.Producto;

public class PruebaInsertProducto {
    public static void main(String[] args) {
        ProductoDAO dao = new ProductoDAO();

        Producto p = new Producto();
        p.setCodigo("P001");
        p.setNombre("Ratón inalámbrico");
        p.setDescripcion("Ratón óptico con conexión bluetooth");
        p.setStock(10);
        p.setStockMinimo(2);

        dao.guardar(p);
    }
}
