package com.curso.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.formacion.model.Formacion;
import com.curso.service.FormacionService;

@RestController
@RequestMapping("/formacion")
public class FormacionController {

	@Autowired
	FormacionService service;

	@PostMapping(value = "/alta/{curso}/{asignaturas}/{precio}")
	public List<Formacion> altaFormacion(@PathVariable String curso, @PathVariable int asignaturas,
			@PathVariable BigDecimal precio) {

		Formacion formacion = new Formacion(curso, asignaturas, precio);
		return service.nuevaFormacion(formacion);
	}
	
	// Este método asegura que puedas acceder a la lista de cursos/formaciones
    @GetMapping("/cursos")
    public List<Formacion> obtenerCursos() {
        return service.obtenerListaFormaciones();
    }
}
