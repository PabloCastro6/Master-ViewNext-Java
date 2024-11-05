package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.curso.model.Empleado;
import com.curso.service.EmpleadoService;

import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/empleados")
@Tag(name = "Empleado Controller", description = "Gestión de empleados")
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;
	
	

	@GetMapping
	@Operation(summary = "Obtener todos los empleados", description = "Retorna una lista de todos los empleados.")
	public List<Empleado> getAllEmpleados() {
		return empleadoService.getAllEmpleados();
	}

	@GetMapping("/{id}")
	@Operation(summary = "Obtener empleado por ID", description = "Retorna un empleado específico según el ID proporcionado.")
	public Empleado getEmpleadoById(@PathVariable Long id) {
		return empleadoService.getEmpleadoById(id);
	}

	@PostMapping
	@Operation(summary = "Crear un nuevo empleado", description = "Crea un nuevo empleado en la base de datos.")
	public Empleado createEmpleado(@RequestBody Empleado empleado) {
		return empleadoService.createEmpleado(empleado);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Actualizar un empleado", description = "Actualiza los datos de un empleado específico.")
	public Empleado updateEmpleado(@PathVariable Long id, @RequestBody Empleado empleadoDetails) {
		return empleadoService.updateEmpleado(id, empleadoDetails);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Eliminar un empleado", description = "Elimina un empleado de la base de datos.")
	public String deleteEmpleado(@PathVariable Long id) {
		empleadoService.deleteEmpleado(id);
		return "Empleado eliminado correctamente";
	}
}
