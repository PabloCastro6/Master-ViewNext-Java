package com.almacen.servicio;

import com.almacen.dao.ProductoDAO;
import com.almacen.modelo.Producto;

import java.sql.SQLException;
import java.util.List;

public class ProductoServicio {
	private ProductoDAO productoDAO;

	public ProductoServicio() {
		this.productoDAO = new ProductoDAO();
	}

	public void agregarProducto(Producto producto) throws SQLException {
		productoDAO.agregarProducto(producto);
	}

	public List<Producto> listarProductos() throws SQLException {
		return productoDAO.listarProductos();
	}

	public void eliminarProducto(int id) throws SQLException {
		productoDAO.eliminarProducto(id);
	}

	public void actualizarProducto(Producto producto) throws SQLException {
		productoDAO.actualizarProducto(producto);
	}

	public Producto buscarProducto(int id) throws SQLException {
		return productoDAO.buscarProducto(id);
	}
}
