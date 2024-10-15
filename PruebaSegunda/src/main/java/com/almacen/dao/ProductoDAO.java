package com.almacen.dao;

import java.util.ArrayList;
import java.util.List;
import com.almacen.modelo.Producto;
import com.almacen.modelo.Categoria;

public class ProductoDAO {
    private static List<Producto> productos = new ArrayList<>();

    static {
        // Productos 
        productos.add(new Producto("Ordenador", Categoria.ELECTRONICA, 1200.50, 10));
        productos.add(new Producto("Teléfono", Categoria.ELECTRONICA, 650.00, 20));
        productos.add(new Producto("Teclado", Categoria.ACCESORIOS, 25.99, 50));
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> listarProductos() {
        return productos;
    }

    public void eliminarProducto(String nombre) {
    	// System.out.println("Intentando eliminar producto con nombre: " + nombre);
        productos.removeIf(p -> p.getNombre().equals(nombre));
      //  System.out.println("Productos después de eliminar: " + productos.size());
    }

    public void actualizarProducto(Producto producto) {
        for (Producto p : productos) {
            if (p.getNombre().equals(producto.getNombre())) {
                p.setCategoria(producto.getCategoria());
                p.setPrecio(producto.getPrecio());
                p.setStock(producto.getStock());
                break;
            }
        }
    }

    public Producto buscarProducto(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equals(nombre))
                return p;
        }
        return null;
    }
}
