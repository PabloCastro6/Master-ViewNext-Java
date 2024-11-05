package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Empleado;
import com.curso.repository.EmpleadoRepository;
import com.curso.service.EmpleadoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public List<Empleado> getAllEmpleados() {
        return empleadoService.getAllEmpleados();
    }

    @GetMapping("/{id}")
    public Empleado getEmpleadoById(@PathVariable Long id) {
        return empleadoService.getEmpleadoById(id);
    }

    @PostMapping
    public Empleado createEmpleado(@RequestBody Empleado empleado) {
        return empleadoService.createEmpleado(empleado);
    }

    @PutMapping("/{id}")
    public Empleado updateEmpleado(@PathVariable Long id, @RequestBody Empleado empleadoDetails) {
        return empleadoService.updateEmpleado(id, empleadoDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteEmpleado(@PathVariable Long id) {
        empleadoService.deleteEmpleado(id);
        return "Empleado eliminado correctamente";
    }
}

