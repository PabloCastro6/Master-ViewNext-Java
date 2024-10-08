package com.curso.modelo;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String nombre;
    private List<Curso> cursosMatriculados;

    public Alumno(String nombre) {
        this.nombre = nombre;
        this.cursosMatriculados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Curso> getCursosMatriculados() {
        return cursosMatriculados;
    }

    public void matricularEnCurso(Curso curso) {
        cursosMatriculados.add(curso);
    }
}
