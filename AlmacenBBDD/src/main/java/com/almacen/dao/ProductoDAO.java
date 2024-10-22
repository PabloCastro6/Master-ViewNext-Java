package com.almacen.dao;

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
			ps.setString(2, producto.getCategoria());
			ps.setBigDecimal(3, producto.getPrecio());
			ps.setInt(4, producto.getStock());
			ps.executeUpdate();
		}
	}

	public List<Producto> listarProductos() throws SQLException {
		List<Producto> productos = new ArrayList<>();
		String query = "SELECT * FROM productos";
		try (Connection conexion = ConexionDB.obtenerConexion();
				Statement st = conexion.createStatement();
				ResultSet rs = st.executeQuery(query)) {
			while (rs.next()) {
				Producto producto = new Producto(rs.getString("nombre"), rs.getString("categoria"),
						rs.getBigDecimal("precio"), rs.getInt("stock"));
				producto.setId(rs.getInt("id"));
				productos.add(producto);
			}
		}
		return productos;
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
			ps.setString(2, producto.getCategoria());
			ps.setBigDecimal(3, producto.getPrecio());
			ps.setInt(4, producto.getStock());
			ps.setInt(5, producto.getId());
			ps.executeUpdate();
		}
	}

	public Producto buscarProducto(int id) throws SQLException {
		String query = "SELECT * FROM productos WHERE id = ?";
		try (Connection conexion = ConexionDB.obtenerConexion();
				PreparedStatement ps = conexion.prepareStatement(query)) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return new Producto(rs.getString("nombre"), rs.getString("categoria"), rs.getBigDecimal("precio"),
							rs.getInt("stock"));
				}
			}
		}
		return null;
	}
}
