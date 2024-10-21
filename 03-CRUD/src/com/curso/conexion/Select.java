package com.curso.conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {

	public static void main(String[] args) {
		Connection conex = null;
		String query = "SELECT * FROM personas";
		ConexionBD cbd = new ConexionBD();
		conex = cbd.conexion();
		if (conex != null) {
			System.out.println("Conectado correctamente");
			try (Statement sentencia = conex.createStatement()) {
				ResultSet rs = sentencia.executeQuery(query);
				while (rs.next()) {
					System.out.print(rs.getString("apellido") + " ");
					System.out.print(rs.getString("nombre") + " ");
					System.out.println(rs.getInt("edad"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("No se ha podido conectar");
		}
	}

}
