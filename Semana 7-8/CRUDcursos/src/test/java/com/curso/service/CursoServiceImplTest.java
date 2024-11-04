package com.curso.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.curso.model.Curso;

public class CursoServiceImplTest {

    private CursoService cursoService;

    @BeforeEach
    public void setUp() {
        cursoService = new CursoServiceImpl();
    }

    @Test
    public void testObtenerCursos() {
        List<Curso> cursos = cursoService.obtenerCursos();
        assertNotNull(cursos, "La lista de cursos no debería ser null");
        assertEquals(3, cursos.size(), "Deberían existir 3 cursos iniciales");
    }

    @Test
    public void testBuscarCurso() {
        Curso curso = cursoService.buscarCurso(1);
        assertNotNull(curso, "El curso con codCurso=1 debería existir");
        assertEquals("Java Básico", curso.getNombre(), "El nombre del curso debería ser:  'Java Básico'");
    }

    @Test
    public void testAltaCurso() {
        Curso nuevoCurso = new Curso(4, "Python Avanzado", 50, 400.0);
        List<Curso> cursos = cursoService.altaCurso(nuevoCurso);

        assertEquals(4, cursos.size(), "Debería haber 4 cursos después de agregar uno nuevo");
        assertTrue(cursos.contains(nuevoCurso), "El curso nuevo debería estar en la lista");
    }

    @Test
    public void testActualizarDuracion() {
        int nuevaDuracion = 45;
        cursoService.actualizarDuracion(1, nuevaDuracion);

        Curso curso = cursoService.buscarCurso(1);
        assertEquals(nuevaDuracion, curso.getDuracion(), "La duración del curso debería actualizarse a " + nuevaDuracion);
    }

    @Test
    public void testEliminarCurso() {
        List<Curso> cursos = cursoService.eliminarCurso(1);

        assertEquals(2, cursos.size(), "Debería haber 2 cursos después de la eliminación");
        assertNull(cursoService.buscarCurso(1), "El curso con codCurso=1 debería haber sido eliminado");
    }

    @Test
    public void testCursosPorPrecio() {
        List<Curso> cursosEnRango = cursoService.cursosPorPrecio(100, 300);

        assertEquals(2, cursosEnRango.size(), "Debería haber 2 cursos en el rango de precios entre 100 y 300");
        assertTrue(cursosEnRango.stream().allMatch(c -> c.getPrecio() >= 100 && c.getPrecio() <= 300), 
                   "Todos los cursos en el rango deberían tener un precio entre 100 y 300");
    }
}
