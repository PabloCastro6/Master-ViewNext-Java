package com.curso.prepared;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.curso.crud.ConexionBD;

public class SelectPrepared {
	public static void main(String[] args) {
		Connection conex = null;
		String query = "SELECT * personas";
		ConexionBD cbd = new ConexionBD();
		 conex = cbd.conexion();
		if (conex != null) {
			System.out.println("Conectado correctamente");

			try (Statement sentencia = conex.createStatement()) {
				ResultSet rs = sentencia.executeQuery(query);
				while (rs.next()) {
					System.out.println(rs.getString("apellido") + " ");
					System.out.println(rs.getString("nombre") + " ");
					System.out.println(rs.getString("edad"));
				}

			} catch (SQLException e) {
				e.printStackTrace();

			}
		} else {
			System.out.println("No se ha podido conectar");

		}

	}

}

//organizar el paquetes, y hacer metodos por ejemplo para invocar al empleado
//Hacer una clase modelo 