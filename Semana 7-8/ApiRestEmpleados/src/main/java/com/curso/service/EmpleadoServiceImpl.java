package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.model.Empleado;
import com.curso.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Override
	public List<Empleado> getAllEmpleados() {
		return empleadoRepository.findAll();
	}

	@Override
	public Empleado getEmpleadoById(Long id) {
		return empleadoRepository.findById(id).orElse(null);
	}

	@Override
	public Empleado createEmpleado(Empleado empleado) {
		return empleadoRepository.save(empleado);
	}

	@Override
	public Empleado updateEmpleado(Long id, Empleado empleadoDetails) {
		Empleado empleado = empleadoRepository.findById(id).orElse(null);
		if (empleado != null) {
			empleado.setNombre(empleadoDetails.getNombre());
			empleado.setApellido(empleadoDetails.getApellido());
			empleado.setEmail(empleadoDetails.getEmail());
			return empleadoRepository.save(empleado);
		}
		return null;
	}

	@Override
	public void deleteEmpleado(Long id) {
		empleadoRepository.deleteById(id);
	}
}
