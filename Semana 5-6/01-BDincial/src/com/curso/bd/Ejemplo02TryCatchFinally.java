package com.curso.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejemplo02TryCatchFinally {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/bdcurso";
		String user = "root";
		String pwd = "root";
		String query = "INSERT INTO personas (nombre, apellido, edad) VALUES('Pepito','Grillo',32)";
		Connection conexion = null;
		Statement sentencia = null;
 
		try {
			conexion = DriverManager.getConnection(url, user, pwd);
			System.out.println("Conexion con la BD establecida");
			sentencia = conexion.createStatement();
			sentencia.executeUpdate(query);
			System.out.println("Eco de sentencia.executeUpdate(query) = " + sentencia.executeUpdate(query));
			System.out.println("Registro insertado");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (sentencia != null)
				try {
					sentencia.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			if (conexion != null) {

			}
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
