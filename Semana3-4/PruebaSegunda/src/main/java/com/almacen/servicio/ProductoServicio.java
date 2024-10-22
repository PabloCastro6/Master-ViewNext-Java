package com.almacen.servicio;

import java.math.BigDecimal;
import java.util.List;

import com.almacen.dao.ProductoDAO;
import com.almacen.modelo.Categoria;
import com.almacen.modelo.Producto;


public class ProductoServicio {
	private ProductoDAO productoDAO = new ProductoDAO();
	 

	public void agregarProducto(Producto producto) {
		productoDAO.agregarProducto(producto);
	}

	public void eliminarProducto(String nombre) {
		 productoDAO.eliminarProducto(nombre); // Usar el nombre directamente
    }

	public Producto buscarProducto(String nombre) {
		return productoDAO.buscarProductoPorNombre(nombre);
	}

	public List<Producto> listarProductos() {
		return productoDAO.listarProductos();
	}

	public void modificarProducto(String nombre, Producto nuevoProducto) {
		Producto producto = productoDAO.buscarProductoPorNombre(nombre);
		if (producto != null) {
			producto.setNombre(nuevoProducto.getNombre());
			producto.setCategoria(nuevoProducto.getCategoria());
			producto.setPrecio(nuevoProducto.getPrecio());
			producto.setStock(nuevoProducto.getStock());
		}
	}

	public void modificarCampoProducto(String nombre, String campo, String nuevoValor) {
		Producto producto = productoDAO.buscarProductoPorNombre(nombre);
	    if (producto != null) {
	        switch (campo) {
	            case "nombre":
	                producto.setNombre(nuevoValor);
	                break;
	            case "categoria":
	                producto.setCategoria(Categoria.valueOf(nuevoValor.toUpperCase()));
	                break;
	            case "precio":
	                producto.setPrecio(new BigDecimal(nuevoValor));
	                break;
	            case "stock":
	                producto.setStock(Integer.parseInt(nuevoValor));
	                break;
	            default:
	                System.out.println("Campo no válido");
	                break;
	        }
	    }
	}
}