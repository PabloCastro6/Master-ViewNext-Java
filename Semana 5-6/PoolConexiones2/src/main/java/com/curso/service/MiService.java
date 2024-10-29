package com.curso.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.curso.model.Persona;

public class MiService {
	private DataSource ds;

	public MiService() {
		try {
			Context initContext = new InitialContext();
			Context envContext =  (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/MiDataSource");
		} catch (NamingException e) {
			
			e.printStackTrace();
		}
	}
	
	public void insertarDatos(String nombre, String apellido, int edad) {
		String sql = "INSERT INTO personas (nombre,apelluido,edad) VALUES (?,?,?)";
		
		try (Connection conn = ds.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void eliminarPorNombre(String nombre) {
		
	}

	public void modificarEdadPorNombre(int edad, String nombre) {
		
	}
	
	public List<Persona> mostraDatos() {
		List<Persona> personas = new ArrayList<Persona>();
		String sql = "SELECT * FROM personas";
		
		try (Connection conn = ds.getConnection();
			Statement pstmt = conn.createStatement();
			ResultSet rs = pstmt.executeQuery(sql);
			) {
			while(rs.next()) {
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				int edad = rs.getInt("edad");
				Persona persona = new Persona(nombre, apellido, edad);
				personas.add(persona);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return personas;
	}
}

