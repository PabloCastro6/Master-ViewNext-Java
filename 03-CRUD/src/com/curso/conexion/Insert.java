package com.curso.conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {

	public static void main(String[] args) {
		Connection conex = null;
		String query = "INSERT INTO personas (nombre,apellido,edad) VALUES('Eva','Solana',21)";
		ConexionBD cbd = new ConexionBD();
		conex =cbd.conexion();
		if(conex!=null) {
			System.out.println("Conectado correctamente");			
			try (Statement sentencia = conex.createStatement()) {				
				sentencia.executeUpdate(query);
				System.out.println("Registro insertado");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}						
		}else {
			System.out.println("No se ha podido conectar");			
		}
	}

	

}
