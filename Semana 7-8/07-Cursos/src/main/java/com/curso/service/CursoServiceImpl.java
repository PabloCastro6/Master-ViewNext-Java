package com.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.model.Curso;
import com.curso.repository.CursoRepository;
@Service
public class CursoServiceImpl implements CursoService {
	@Autowired
	CursoRepository repository;
	@Override
	public List<Curso> getCursos() {
		return repository.findAll();
	}

	@Override
	public Optional<Curso> buscarCurso(int codCurso) {
		return repository.findById(codCurso);
	}

	@Override
	public List<Curso> alta(Curso curso) {
		repository.save(curso);
		return repository.findAll();
	}

	@Override
	public List<Curso> eliminar(int codCurso) {
		repository.deleteById(codCurso);
		return repository.findAll();
	}

	@Override
	public void actualizar(int codCurso, int duracion) {
		Curso curso = repository.findById(codCurso).orElse(null);
		if (curso!=null) {
			curso.setDuracion(duracion);
			repository.save(curso);
		}
		
	}

	@Override
	public List<Curso> findByPrecioBetween(double precioMin , double precioMax ) {
		return repository.findByPrecioBetween(precioMax, precioMin);
	}
}
