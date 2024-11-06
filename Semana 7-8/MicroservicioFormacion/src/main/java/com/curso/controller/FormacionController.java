package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.formacion.model.Formacion;
import com.curso.service.FormacionService;

@RestController
@RequestMapping("/formaciones")
public class FormacionController {
	

	    @Autowired
	    private FormacionService formacionService;

	    @GetMapping("/cursos")
	    public List<Formacion> obtenerCursos() {
	        return formacionService.obtenerFormaciones();
	    }

	    @PostMapping("/alta")
	    public String altaCurso(@RequestBody Formacion formacion) {
	        return formacionService.altaFormacion(formacion);
	    }
	}


