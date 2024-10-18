package com.curso.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {

	public static void main(String[] args) {
		// private static final String URL = "jdbc:mysql://localhost:3306/bdcurso"; //
		// Pensar si esto sería mejor
		String url = "jdbc:mysql://localhost:3306/bdcurso";
		String user = "root";
		String pwd = "root";
		String query = "UPDATE  personas SET edad = 33  WHERE apellido = 'Pacios'";

		try (Connection conexion = DriverManager.getConnection(url, user, pwd);
				Statement sentencia = conexion.createStatement();) {
		if(	sentencia.executeUpdate(query)>0) {
			System.out.println("Registro actualizado");
		}else {
			System.out.println("Ningún registro cumple la condición");	
		}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
