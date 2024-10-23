package com.almacen.dao;

import com.almacen.modelo.Categoria;
import com.almacen.modelo.Producto;
import com.almacen.util.ConexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

	public void agregarProducto(Producto producto) throws SQLException {
		String query = "INSERT INTO productos (nombre, categoria, precio, stock) VALUES (?, ?, ?, ?)";
		try (Connection conexion = ConexionDB.obtenerConexion();
				PreparedStatement ps = conexion.prepareStatement(query)) {
			ps.setString(1, producto.getNombre());
			ps.setString(2, producto.getCategoria().name()); // Convertimos el enum a String
			ps.setBigDecimal(3, producto.getPrecio());
			ps.setInt(4, producto.getStock());
			ps.executeUpdate();
		}
	}

	public List<Producto> listarProductos() throws SQLException {
	    List<Producto> productos = new ArrayList<>();
	    String query = "SELECT * FROM productos";  // Consulta SQL para recuperar todos los productos

	    try (Connection conexion = ConexionDB.obtenerConexion();
	         Statement st = conexion.createStatement();
	         ResultSet rs = st.executeQuery(query)) {

	        while (rs.next()) {
	            // Recuperar los valores del ResultSet y convertirlos a un objeto Producto
	            Categoria categoria = Categoria.valueOf(rs.getString("categoria"));  // Convierte el valor de la base de datos a enum
	            Producto producto = new Producto(
	                rs.getInt("id"),               // ID del producto
	                rs.getString("nombre"),        // Nombre del producto
	                categoria,                     // Categoría (enum)
	                rs.getBigDecimal("precio"),    // Precio del producto
	                rs.getInt("stock")             // Stock del producto
	            );
	            productos.add(producto);  // Agrega el producto a la lista
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw e;  // Vuelve a lanzar la excepción en caso de error
	    }

	    return productos;  // Devuelve la lista de productos
	}




	public void eliminarProducto(int id) throws SQLException {
		String query = "DELETE FROM productos WHERE id = ?";
		try (Connection conexion = ConexionDB.obtenerConexion();
				PreparedStatement ps = conexion.prepareStatement(query)) {
			ps.setInt(1, id);
			ps.executeUpdate();
		}
	}

	public void actualizarProducto(Producto producto) throws SQLException {
		String query = "UPDATE productos SET nombre = ?, categoria = ?, precio = ?, stock = ? WHERE id = ?";
		try (Connection conexion = ConexionDB.obtenerConexion();
				PreparedStatement ps = conexion.prepareStatement(query)) {
			ps.setString(1, producto.getNombre());
			ps.setString(2, producto.getCategoria().name()); // Convertir el enum a String
			ps.setBigDecimal(3, producto.getPrecio());
			ps.setInt(4, producto.getStock());
			ps.setInt(5, producto.getId()); // Usar el ID para modificar el producto correcto
			ps.executeUpdate();
		}
	}
}

//
//	public Producto buscarProducto(int id) throws SQLException {
//		String query = "SELECT * FROM productos WHERE id = ?";
//		try (Connection conexion = ConexionDB.obtenerConexion();
//				PreparedStatement ps = conexion.prepareStatement(query)) {
//			ps.setInt(1, id);
//			try (ResultSet rs = ps.executeQuery()) {
//				if (rs.next()) {
//					return new Producto(rs.getString("nombre"), rs.getString("categoria"), rs.getBigDecimal("precio"),
//							rs.getInt("stock"));
//				}
//			}
//		}
//		return null;
//	}
//}
