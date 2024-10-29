package com.empresa.main;

import com.empresa.dao.EmpleadoDAO;
import com.empresa.modelo.Empleado;

import java.util.Date;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmpleadoDAO empleadoDAO = new EmpleadoDAO();
		
		 // Insertar el empleado por defecto sin hacer comprobaciones
        Empleado empleadoPorDefecto = new Empleado("Pablo", "Castro", "Morato", java.sql.Date.valueOf("2000-12-26"), 3000.0);
        empleadoDAO.insertarEmpleado(empleadoPorDefecto);

		while (true) {
			System.out.println("Selecciona una opción:");
			System.out.println("1. Insertar empleado");
			System.out.println("2. Modificar empleado");
			System.out.println("3. Listar todos los empleados");
			System.out.println("4. Buscar los empleados por 1apellido");
			System.out.println("5. Eliminar empleado");
			System.out.println("6. Calcular salario medio");
			System.out.println("7. Salir");

			int opcion = sc.nextInt();
			sc.nextLine(); // Limpiar el buffer

			switch (opcion) {
			case 1:
				// Llamada al método insertarEmpleado
				System.out.println("Introduce el nombre del empleado:");
				String nombre = sc.nextLine();

				System.out.println("Introduce el primer apellido:");
				String apellido1 = sc.nextLine();

				System.out.println("Introduce el segundo apellido:");
				String apellido2 = sc.nextLine();

				System.out.println("Introduce la fecha de nacimiento (YYYY-MM-DD):");
				String fechaNacimientoStr = sc.nextLine();
				Date fechaNacimiento = java.sql.Date.valueOf(fechaNacimientoStr);

				System.out.println("Introduce el salario:");
				double salario = sc.nextDouble();
				sc.nextLine(); // Limpiar el buffer

				Empleado nuevoEmpleado = new Empleado(nombre, apellido1, apellido2, (java.sql.Date) fechaNacimiento,
						salario);
				empleadoDAO.insertarEmpleado(nuevoEmpleado);
				System.out.println("Empleado insertado correctamente.");
				break;

			case 2:
			    // Solicita el ID del empleado a modificar
			    System.out.println("Introduce el ID del empleado que deseas modificar:");
			    int idModificar = sc.nextInt();
			    sc.nextLine(); // Limpiar el buffer

			    // Submenú para elegir qué campo modificar
			    System.out.println("¿Qué campo deseas modificar?");
			    System.out.println("1. Nombre");
			    System.out.println("2. Primer Apellido");
			    System.out.println("3. Segundo Apellido");
			    System.out.println("4. Fecha de Nacimiento");
			    System.out.println("5. Salario");

			    int opcionModificar = sc.nextInt();
			    sc.nextLine(); // Limpiar el buffer

			    // Dependiendo de la opción seleccionada, se modifica un campo específico
			    switch (opcionModificar) {
			        case 1:
			            System.out.println("Introduce el nuevo nombre:");
			            String nuevoNombre = sc.nextLine();
			            empleadoDAO.modificarCampoDelEmpleado(idModificar, "nombre", nuevoNombre);
			            break;
			        case 2:
			            System.out.println("Introduce el nuevo primer apellido:");
			            String nuevoApellido1 = sc.nextLine();
			            empleadoDAO.modificarCampoDelEmpleado(idModificar, "apellido1", nuevoApellido1);
			            break;
			        case 3:
			            System.out.println("Introduce el nuevo segundo apellido:");
			            String nuevoApellido2 = sc.nextLine();
			            empleadoDAO.modificarCampoDelEmpleado(idModificar, "apellido2", nuevoApellido2);
			            break;
			        case 4:
			            System.out.println("Introduce la nueva fecha de nacimiento (YYYY-MM-DD):");
			            String nuevaFechaNacimientoStr = sc.nextLine();
			            
			         // Convertir el String a java.sql.Date directamente
			            java.sql.Date nuevaFechaNacimiento = java.sql.Date.valueOf(nuevaFechaNacimientoStr);
			            
			            empleadoDAO.modificarCampoDelEmpleado(idModificar, "fecha_nacimiento", nuevaFechaNacimiento);
			            break;
			        case 5:
			            System.out.println("Introduce el nuevo salario:");
			            double nuevoSalario = sc.nextDouble();
			            empleadoDAO.modificarCampoDelEmpleado(idModificar, "salario", nuevoSalario);
			            break;
			        default:
			            System.out.println("Opción no válida.");
			    }
			    break;

			case 3:
				// Llamada al método listar todos los empleados
				empleadoDAO.mostrarTodosLosEmpleados();
				break;

			case 4:
				// Llamada al metodo buscar
				System.out.println("Introduce el primer apellido del empleado que deseas buscar:");
				String apellidoBuscar = sc.nextLine();
				empleadoDAO.buscarEmpleadosPorApellido1(apellidoBuscar);
				break;
			case 5:
				System.out.println("Introduce el ID del empleado que deseas eliminar:");
				int idEliminar = sc.nextInt();
				empleadoDAO.eliminarEmpleadoPorId(idEliminar);
				break;
			case 6:
				// Llamada al metodo salario medio
				empleadoDAO.calcularSalarioMedio();
				break;

			case 7:
				System.out.println("Saliendo...");
				sc.close();
				return; // Sale del bucle y finaliza el programa

			default:
				System.out.println("Opción no válida.");
			}
		}
	}
}
