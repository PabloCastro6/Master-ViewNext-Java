package com.almacen.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.almacen.modelo.Producto;
import com.almacen.modelo.Categoria;
import com.almacen.dao.ProductoDAO;


public class ProductoDAO {
    private static List<Producto> productos = new ArrayList<>();

    static {
        // Productos 
    	productos.add(new Producto("Ordenador", Categoria.ELECTRONICA, new BigDecimal("1200.50"), 10));
        productos.add(new Producto("Teléfono", Categoria.ELECTRONICA, new BigDecimal("650.00"), 20));
        productos.add(new Producto("Teclado", Categoria.ACCESORIOS, new BigDecimal("25.99"), 50));
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> listarProductos() {
        return productos;
    }

    public void eliminarProducto(String nombre) {
        productos.removeIf(p -> p.getNombre().equals(nombre)); 
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
    public Producto buscarProductoPorNombre(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equals(nombre))
                return p;
        }
        return null;
    }
}