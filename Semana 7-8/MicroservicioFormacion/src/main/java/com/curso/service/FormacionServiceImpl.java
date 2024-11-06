package com.curso.service;

import com.curso.formacion.model.Curso;
import com.curso.formacion.model.Formacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FormacionServiceImpl implements FormacionService {

    @Autowired
    private RestTemplate restTemplate;

    private String urlCursos = "http://localhost:8080/cursos";

    @Override
    public List<Formacion> nuevaFormacion(Formacion formacion) {
        Curso[] cursosExistentes = restTemplate.getForObject(urlCursos, Curso[].class);

        boolean existeCurso = false;
        for (Curso curso : cursosExistentes) {
            if (curso.getNombre().equalsIgnoreCase(formacion.getCurso())) {
                existeCurso = true;
                break;
            }
        }

        if (!existeCurso) {
            Curso nuevoCurso = new Curso();
            nuevoCurso.setNombre(formacion.getCurso());
            nuevoCurso.setDuracion(formacion.getAsignaturas() * 10);
            restTemplate.postForLocation(urlCursos, nuevoCurso);
        }

        return convertirCursosAFormaciones(cursosExistentes);
    }

    @Override
    public List<Formacion> obtenerListaFormaciones() {
        Curso[] cursosExistentes = restTemplate.getForObject(urlCursos, Curso[].class);
        return convertirCursosAFormaciones(cursosExistentes);
    }

    private List<Formacion> convertirCursosAFormaciones(Curso[] cursos) {
        List<Formacion> listaFormaciones = new ArrayList<>();
        for (Curso curso : cursos) {
            Formacion f = new Formacion();
            f.setCurso(curso.getNombre());
            f.setAsignaturas(curso.getDuracion() >= 50 ? 10 : 5);
            listaFormaciones.add(f);
        }
        return listaFormaciones;
    }
}
