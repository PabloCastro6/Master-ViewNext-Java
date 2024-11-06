package com.curso.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.formacion.model.Curso;
import com.curso.formacion.model.Formacion;

@Service
public class FormacionServiceImpl implements FormacionService {

    @Autowired
    RestTemplate restTemplate;

    private String urlCursos = "http://localhost:8080/cursos";

    @Override
    public List<Formacion> nuevaFormacion(Formacion formacion) {
        // Verificar si el curso ya existe
        Curso[] cursosExistentes = restTemplate.getForObject(urlCursos, Curso[].class);
        boolean existeCurso = Arrays.stream(cursosExistentes)
                .anyMatch(curso -> curso.getNombre().equalsIgnoreCase(formacion.getCurso()));

        if (!existeCurso) {
            // Crear un nuevo curso en el microservicio de cursos
            Curso nuevoCurso = new Curso(formacion.getCurso(), formacion.getAsignaturas() * 10);
            restTemplate.postForLocation(urlCursos, nuevoCurso);
        }

        // Devolver la lista actualizada de formaciones
        return Arrays.asList(restTemplate.getForObject(urlCursos, Formacion[].class));
    }
}