package com.empresa.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

	private static final String URL = "jdbc:mysql://localhost:3306/bdempresa";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	// Método para obtener la conexión
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
