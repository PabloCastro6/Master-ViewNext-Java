package com.curso.prueba;

import java.sql.Connection;

import com.curso.conexion.ConexionBD;

public class ProbarConexion {

	public static void main(String[] args) {
		Connection conex = null;
		ConexionBD cbd = new ConexionBD();
		conex =cbd.conexion();
		if(conex!=null) {
			System.out.println("Conectado correctamente");
		}else {
			System.out.println("No se ha podido conectar");			
		}

	}

}
