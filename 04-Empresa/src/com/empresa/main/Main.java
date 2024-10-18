package com.empresa.main;

import com.empresa.dao.EmpleadoDAO;
import com.empresa.modelo.Empleado;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();

        while (true) {
            System.out.println("Selecciona una opción:");
            System.out.println("1. Insertar empleado");
            System.out.println("2. Modificar empleado");
            System.out.println("3. Listar todos los empleados");
            System.out.println("4. Salir");

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

                    Empleado nuevoEmpleado = new Empleado(nombre, apellido1, apellido2, (java.sql.Date) fechaNacimiento, salario);
                    empleadoDAO.insertarEmpleado(nuevoEmpleado);
                    System.out.println("Empleado insertado correctamente.");
                    break;

                case 2:
                    // Llamada al método modificarEmpleado
                    System.out.println("Introduce el ID del empleado que deseas modificar:");
                    int id = sc.nextInt();
                    sc.nextLine(); // Limpiar el buffer

                    System.out.println("Introduce el nuevo nombre del empleado:");
                    String nuevoNombre = sc.nextLine();

                    System.out.println("Introduce el nuevo primer apellido:");
                    String nuevoApellido1 = sc.nextLine();

                    System.out.println("Introduce el nuevo segundo apellido:");
                    String nuevoApellido2 = sc.nextLine();

                    System.out.println("Introduce la nueva fecha de nacimiento (YYYY-MM-DD):");
                    String nuevaFechaNacimientoStr = sc.nextLine();
                    Date nuevaFechaNacimiento = java.sql.Date.valueOf(nuevaFechaNacimientoStr);

                    System.out.println("Introduce el nuevo salario:");
                    double nuevoSalario = sc.nextDouble();
                    sc.nextLine(); // Limpiar el buffer

                    Empleado empleadoModificado = new Empleado(id, nuevoNombre, nuevoApellido1, nuevoApellido2, (java.sql.Date)nuevaFechaNacimiento, nuevoSalario);
                    empleadoDAO.modificarEmpleado(empleadoModificado);
                    System.out.println("Empleado modificado correctamente.");
                    break;

                case 3:
                    // Llamada al método listar todos los empleados
                    empleadoDAO.mostrarTodosLosEmpleados();
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    sc.close();
                    return; // Sale del bucle y finaliza el programa

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
