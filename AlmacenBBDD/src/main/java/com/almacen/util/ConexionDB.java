package com.almacen.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
	private static final String URL = "jdbc:mysql://localhost:3306/bdalmacen";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	public static Connection obtenerConexion() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			throw new SQLException("Error al cargar el driver de MySQL", e);
		}
	}
}
