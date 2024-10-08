package com.curso.modelo;

import java.util.ArrayList;
import java.util.List;

public class Curso {

	private String nombre;
	
    private List<Alumno> alumnosMatriculados;

    public Curso(String nombre) {
        this.nombre = nombre;
        this.alumnosMatriculados = new ArrayList<>(); // Inicializar la lista de alumnos
    }

    public String getNombre() {
        return nombre;
    }

    public List<Alumno> getAlumnosMatriculados() {
        return alumnosMatriculados; // Retornar la lista de alumnos matriculados
    }

    public void agregarAlumno(Alumno alumno) {
        // Agregar el alumno a la lista de alumnos matriculados
        alumnosMatriculados.add(alumno);
    }
}
