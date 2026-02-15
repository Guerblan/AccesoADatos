package com.tienda.app;

import com.tienda.dao.MovimientosDAO;
import com.tienda.dao.ProductoDAO;
import com.tienda.model.Movimiento;
import com.tienda.model.Producto;
import java.util.List;
import java.util.Scanner;

public class MenuApp {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new MenuApp().run();
    }

    private void run() {
        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            System.out.print("Elige opción: ");
            String opcion = sc.nextLine().trim();

            switch (opcion) {
                case "1": {
                    System.out.println("\n--- LISTA DE PRODUCTOS ---");
                    ProductoDAO dao = new ProductoDAO();
                    List<Producto> lista = dao.listar();

                    if (lista.isEmpty()) {
                        System.out.println("(No hay productos)");
                    } else {
                        for (Producto p : lista) {
                            System.out.println("ID: " + p.getId()
                                    + " | Código: " + p.getCodigo()
                                    + " | Nombre: " + p.getNombre()
                                    + " | Stock: " + p.getStock()
                                    + " (mín: " + p.getStockMinimo() + ")");
                        }
                    }
                    break;
                }
                case "2": {

                    System.out.println("\n--- INSERTAR PRODUCTO ---");

                    System.out.print("Código: ");
                    String codigo = sc.nextLine().trim();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine().trim();

                    System.out.print("Descripción: ");
                    String descripcion = sc.nextLine().trim();

                    System.out.print("Stock inicial: ");
                    int stock = Integer.parseInt(sc.nextLine().trim());

                    System.out.print("Stock mínimo: ");
                    int stockMin = Integer.parseInt(sc.nextLine().trim());

                    Producto p = new Producto();
                    p.setCodigo(codigo);
                    p.setNombre(nombre);
                    p.setDescripcion(descripcion);
                    p.setStock(stock);
                    p.setStockMinimo(stockMin);

                    ProductoDAO dao = new ProductoDAO();
                    dao.guardar(p);

                    System.out.println("Producto insertado.");

                    break;
                }
                case "3": {
                    System.out.println("[3] Registrar movimiento");

                    System.out.print("Código del producto: ");
                    String codigo = sc.nextLine().trim();

                    ProductoDAO pdao = new ProductoDAO();
                    Producto p = pdao.buscarPorCodigo(codigo);

                    if (p == null) {
                        System.out.println("No existe un producto con ese código.");
                        break;
                    }

                    System.out.print("Tipo (E=entrada, S=salida): ");
                    String tipoStr = sc.nextLine().trim().toUpperCase();
                    if (!tipoStr.equals("E") && !tipoStr.equals("S")) {
                        System.out.println("Tipo no válido.");
                        break;
                    }

                    System.out.print("Cantidad: ");
                    int cantidad;
                    try {
                        cantidad = Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException ex) {
                        System.out.println("Cantidad no válida.");
                        break;
                    }
                    if (cantidad <= 0) {
                        System.out.println("La cantidad debe ser > 0.");
                        break;
                    }

                    // Validación para SALIDA
                    if (tipoStr.equals("S") && p.getStock() < cantidad) {
                        System.out.println("Stock insuficiente. Stock actual: " + p.getStock());
                        break;
                    }

                    // Calcular y actualizar stock
                    int nuevoStock = tipoStr.equals("E") ? p.getStock() + cantidad : p.getStock() - cantidad;
                    pdao.actualizarStock(p.getId(), nuevoStock);

                    // Registrar movimiento
                    Movimiento m = new Movimiento();
                    m.setIdProducto(p.getId());
                    m.setTipo(tipoStr.equals("E") ? "ENTRADA" : "SALIDA");
                    m.setCantidad(cantidad);

                    MovimientosDAO mdao = new MovimientosDAO();
                    mdao.registrar(m);

                    System.out.println("Movimiento registrado. Stock nuevo: " + nuevoStock);
                    break;
                }
                case "4": {
                    System.out.println("\n--- LISTA DE MOVIMIENTOS ---"); // <-- NUEVO
                    MovimientosDAO mdao = new MovimientosDAO(); // <-- NUEVO
                    List<Movimiento> lista = mdao.listar(); // <-- NUEVO

                    if (lista.isEmpty()) { // <-- NUEVO
                        System.out.println("(No hay movimientos registrados)");
                    } else {
                        for (Movimiento m : lista) {
                            System.out.println("[" + m.getId() + "] "
                                    + m.getTipo() + " - "
                                    + m.getCantidad() + " unidades (producto "
                                    + m.getIdProducto() + ") - "
                                    + m.getFecha());
                        }
                    }
                    break;
                }
                case "0": {
                    System.out.println("Saliendo...");
                    salir = true;
                    break;
                }
                default: {
                    System.out.println("Opción no válida.");
                }
            }

        }
    }

    private void mostrarMenu() {
        System.out.println("\n=== MENÚ INVENTARIO ===");
        System.out.println("1) Listar productos");
        System.out.println("2) Insertar producto");
        System.out.println("3) Registrar movimiento (entrada/salida)");
        System.out.println("4) Ver movimientos");
        System.out.println("0) Salir");
    }
}
