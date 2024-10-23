package com.almacen.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
	private static final String URL = "jdbc:mysql://localhost:3306/bdalmacen";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	// Método para obtener la conexión a la base de datos
    public static Connection obtenerConexion() throws SQLException {
        Connection conexion = null;
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión a la base de datos establecida.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error al cargar el driver de MySQL.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en la conexión con la base de datos.");
            throw e;  // Vuelve a lanzar la excepción si ocurre un error en la conexión
        }
        return conexion;
    }
}