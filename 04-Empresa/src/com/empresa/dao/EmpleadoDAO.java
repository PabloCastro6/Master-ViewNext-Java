package com.empresa.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.empresa.modelo.Empleado;

public class EmpleadoDAO {
	private String url = "jdbc:mysql://localhost:3306/bdempresa";
	private String user = "root";
	private String pwd = "root";

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, pwd);
	}

	public void mostrarTodosLosEmpleados() {
		String sql = "SELECT * FROM empleados";

		try (Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String apellido1 = rs.getString("apellido1");
				String apellido2 = rs.getString("apellido2");
				Date fechaNacimiento = rs.getDate("fecha_nacimiento");
				double salario = rs.getDouble("salario");

				System.out.println("ID: " + id + ", Nombre: " + nombre + " " + apellido1 + " " + apellido2
						+ ", Fecha de Nacimiento: " + fechaNacimiento + ", Salario: " + salario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertarEmpleado(Empleado empleado) {
		String sql = "INSERT INTO empleados (nombre, apellido1, apellido2, fecha_nacimiento, salario) VALUES (?, ?, ?, ?, ?)";

		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, empleado.getNombre());
			stmt.setString(2, empleado.getApellido1());
			stmt.setString(3, empleado.getApellido2());
			stmt.setDate(4, new java.sql.Date(empleado.getFechaNacimiento().getTime()));
			stmt.setDouble(5, empleado.getSalario());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void modificarEmpleado(Empleado empleado) {
		String sql = "UPDATE empleados SET nombre = ?, apellido1 = ?, apellido2 = ?, fecha_nacimiento = ?, salario = ? WHERE id = ?";

		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, empleado.getNombre());
			stmt.setString(2, empleado.getApellido1());
			stmt.setString(3, empleado.getApellido2());
			stmt.setDate(4, new java.sql.Date(empleado.getFechaNacimiento().getTime()));
			stmt.setDouble(5, empleado.getSalario());
			stmt.setInt(6, empleado.getId()); // Usamos el ID para identificar al empleado
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(); // Manejo de excepciones
		}
	}
}
