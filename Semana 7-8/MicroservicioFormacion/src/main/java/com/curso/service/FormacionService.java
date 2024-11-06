package com.curso.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.formacion.cliente.CursoCliente;
import com.curso.formacion.model.Curso;
import com.curso.formacion.model.Formacion;
import com.curso.formacion.repository.FormacionRepository;

@Service
public class FormacionService {

    @Autowired
    private FormacionRepository formacionRepository;

    @Autowired
    private CursoCliente cursoClient;

    public List<Formacion> obtenerFormaciones() {
        List<Curso> cursos = cursoCliente.obtenerCursos();
        return cursos.stream().map(curso -> {
            Formacion formacion = new Formacion();
            formacion.setCurso(curso.getNombre());
            formacion.setAsignaturas(curso.getDuracion() >= 50 ? 10 : 5);
            return formacion;
        }).collect(Collectors.toList());
    }

    public String altaFormacion(Formacion formacion) {
        if (!formacionRepository.existsByCurso(formacion.getCurso())) {
            Curso nuevoCurso = new Curso();
            nuevoCurso.setNombre(formacion.getCurso());
            nuevoCurso.setDuracion(formacion.getAsignaturas() * 10);
            cursoClient.altaCurso(nuevoCurso);
            formacionRepository.save(formacion);
            return "Curso dado de alta con éxito.";
        } else {
            return "El curso ya existe y no se ha dado de alta.";
        }
    }
}