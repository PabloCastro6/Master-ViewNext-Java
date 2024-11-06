package com.curso.service;

import com.curso.formacion.model.CursoAux;
import com.curso.formacion.model.Formacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FormacionServiceImpl implements FormacionService {

    @Autowired
    private RestTemplate restTemplate;

    private String urlCursos = "http://localhost:8080/cursos";

    @Override
    public List<Formacion> nuevaFormacion(Formacion formacion) {
        CursoAux[] cursosExistentes = restTemplate.getForObject(urlCursos, CursoAux[].class);

        boolean existeCurso = false;
        for (CursoAux curso : cursosExistentes) {
            if (curso.getNombre().equalsIgnoreCase(formacion.getCurso())) {
                existeCurso = true;
                break;
            }
        }

        if (!existeCurso) {
            CursoAux nuevoCurso = new CursoAux();
            nuevoCurso.setNombre(formacion.getCurso());
            nuevoCurso.setDuracion(formacion.getAsignaturas() * 10);
            restTemplate.postForLocation(urlCursos, nuevoCurso);
        }

        return convertirCursosAFormaciones(cursosExistentes);
    }



    @Override
    public List<Formacion> obtenerListaFormaciones() {
        
        
        List<Formacion> formaciones = new ArrayList<>();
        try {
            List<CursoAux> cursos = Arrays.asList(restTemplate.getForObject(urlCursos, CursoAux[].class));
            

            for (CursoAux curso : cursos) {
                int asignaturas = (curso.getDuracion() >= 50) ? 10 : 5;
                formaciones.add(new Formacion(curso.getNombre(), asignaturas, curso.getPrecio()));
            }
        } catch (Exception e) {
           
        }

        return formaciones;
    }


    
    
    private List<Formacion> convertirCursosAFormaciones(CursoAux[] cursos) {
        List<Formacion> formaciones = new ArrayList<>();
        for (CursoAux curso : cursos) {
            int asignaturas = (curso.getDuracion() >= 50) ? 10 : 5;
            formaciones.add(new Formacion(curso.getNombre(), asignaturas, curso.getPrecio()));
        }
        return formaciones;
    }
}