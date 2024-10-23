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
        Connection conexion = null;
        try {
            // Usar la clase ConexionDB para obtener la conexión
            conexion = ConexionDB.obtenerConexion();
            // Aquí va el código para listar los productos usando la conexión
        } finally {
            if (conexion != null) {
                conexion.close();  // Asegúrate de cerrar la conexión después de usarla
            }
        }
		return null;
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
