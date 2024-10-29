package com.curso.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {

	public static void main(String[] args) {
		// private static final String URL = "jdbc:mysql://localhost:3306/bdcurso"; //Pensar si esto seria mejor 
		String url = "jdbc:mysql://localhost:3306/bdcurso";
		String user = "root";
		String pwd = "root";
		String query = "INSERT INTO personas (nombre, apellido, edad) VALUES('Ana','Pacios',25)";

		try (Connection conexion = DriverManager.getConnection(url, user, pwd);
				Statement sentencia = conexion.createStatement();) {

			sentencia.executeUpdate(query);
			//System.out.println("Eco de sentencia.executeUpdate(query" + sentencia.executeUpdate(query));
			System.out.println("Registro insertado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
