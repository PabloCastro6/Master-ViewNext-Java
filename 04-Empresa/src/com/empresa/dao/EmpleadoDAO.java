package com.empresa.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.empresa.modelo.Empleado;
import com.empresa.util.ConexionBD;

public class EmpleadoDAO {
	
	


	public void mostrarTodosLosEmpleados() {
		String sql = "SELECT * FROM empleados";

		try (Connection conn = ConexionBD.getConnection();PreparedStatement stmt = conn.prepareStatement(sql);ResultSet rs = stmt.executeQuery()) {
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

		try (Connection conn = ConexionBD.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
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

	//Varios metodos de modificarCampo dependiendo del campo elegido
	public void modificarCampoDelEmpleado(int id, String campo, String valor) {
	    String sql = "UPDATE empleados SET " + campo + " = ? WHERE id = ?";

	    try (Connection conn = ConexionBD.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, valor);
	        stmt.setInt(2, id);
	        stmt.executeUpdate();
	        System.out.println("Campo " + campo + " modificado correctamente.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void modificarCampoDelEmpleado(int id, String campo, Date valor) {
	    String sql = "UPDATE empleados SET " + campo + " = ? WHERE id = ?";

	    try (Connection conn = ConexionBD.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setDate(1, new java.sql.Date(valor.getTime()));
	        stmt.setInt(2, id);
	        stmt.executeUpdate();
	        System.out.println("Campo " + campo + " modificado correctamente.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void modificarCampoDelEmpleado(int id, String campo, double valor) {
	    String sql = "UPDATE empleados SET " + campo + " = ? WHERE id = ?";

	    try (Connection conn = ConexionBD.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setDouble(1, valor);
	        stmt.setInt(2, id);
	        stmt.executeUpdate();
	        System.out.println("Campo " + campo + " modificado correctamente.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	public void buscarEmpleadosPorApellido1(String apellido1) {
		String sql = "SELECT * FROM empleados WHERE apellido1 = ?";

		try (Connection conn = ConexionBD.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, apellido1);
			ResultSet rs = stmt.executeQuery();

			boolean encontrado = false; // Verificar si hay resultados
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id") + ", Nombre: " + rs.getString("nombre") + " "
						+ rs.getString("apellido1") + " " + rs.getString("apellido2") + ", Fecha de Nacimiento: "
						+ rs.getDate("fecha_nacimiento") + ", Salario: " + rs.getDouble("salario"));
			}
			// Si no se encontraron resultados
			if (!encontrado) {
				System.out.println("Apellido no encontrado.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void eliminarEmpleadoPorId(int id) {
		String sql = "DELETE FROM empleados WHERE id = ?";

		try (Connection conn = ConexionBD.getConnection();PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			int filasAfectadas = stmt.executeUpdate();

			if (filasAfectadas > 0) {
				System.out.println("Empleado con ID " + id + " eliminado correctamente.");
			} else {
				System.out.println("El empleado con ID " + id + " no se ha encontrado.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void calcularSalarioMedio() {
		String sql = "SELECT AVG(salario) AS salario_medio FROM empleados";

		try (Connection conn = ConexionBD.getConnection();PreparedStatement stmt = conn.prepareStatement(sql);ResultSet rs = stmt.executeQuery()) {
			if (rs.next()) {
				double salarioMedio = rs.getDouble("salario_medio");
				System.out.println("El salario medio de los empleados es: " + salarioMedio);
			} else {
				System.out.println("No hay empleados registrados.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
