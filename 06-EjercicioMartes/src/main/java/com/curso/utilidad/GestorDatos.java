package com.curso.utilidad;

import java.util.HashMap;
import java.util.Map;

import com.curso.modelo.Alumno;
import com.curso.modelo.Curso;

public class GestorDatos {
	//Mapa para almacenar los alumnos por nombre 
	private static Map<String, Alumno> alumnos = new HashMap<>();
	
	 // Mapa para almacenar los cursos disponibles
    private static Map<String, Curso> cursos = new HashMap<>();

	//Registrar alumnos si no existe
    public static void registrarAlumno(String nombre) {
        if (!alumnos.containsKey(nombre)) {
            alumnos.put(nombre, new Alumno(nombre));
        }
    }

    //Obtener un alumno por su nombre 
    public static Alumno obtenerAlumno(String nombre) {
        return alumnos.get(nombre);
    }

   // Método para registrar un curso si no existe
    public static void registrarCurso(String nombreCurso) {
        if (!cursos.containsKey(nombreCurso)) {
            cursos.put(nombreCurso, new Curso(nombreCurso));
        }
    }

    // Método para obtener un curso por su nombre
    public static Curso obtenerCurso(String nombreCurso) {
        return cursos.get(nombreCurso);
    }

    // Método para obtener todos los cursos disponibles
    public static Map<String, Curso> obtenerCursos() {
        return cursos;
    }
}

