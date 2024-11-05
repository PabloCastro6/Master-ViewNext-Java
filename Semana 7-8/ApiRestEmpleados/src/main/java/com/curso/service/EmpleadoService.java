package com.curso.service;

import java.util.List;

import com.curso.model.Empleado;

public interface EmpleadoService {
	  List<Empleado> getAllEmpleados();
	    Empleado getEmpleadoById(Long id);
	    Empleado createEmpleado(Empleado empleado);
	    Empleado updateEmpleado(Long id, Empleado empleadoDetails);
	    void deleteEmpleado(Long id);

}
