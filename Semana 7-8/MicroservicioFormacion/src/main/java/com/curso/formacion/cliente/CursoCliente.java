package com.curso.formacion.cliente;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.curso.formacion.model.Curso;

@FeignCliente(name = "curso-service", url = "http://localhost:8080") 
public interface CursoCliente {
    @GetMapping("/cursos")
    List<Curso> obtenerCursos();

    @PostMapping("/cursos")
    void altaCurso(@RequestBody Curso curso);
}
