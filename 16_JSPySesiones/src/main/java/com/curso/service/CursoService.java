package com.curso.service;

import java.util.ArrayList;
import java.util.List;

import com.curso.model.Curso;

public class CursoService {
	private static List<Curso> listaCursos = new ArrayList<Curso>();
	
	static {
		Curso c1 = new Curso("esperanto", 1);
		Curso c2 = new Curso("chino", 2);
		Curso c3 = new Curso("japones", 3);
		
		listaCursos.add(c3);
	}
	
	public List<Curso> buscarTodos() {
		return listaCursos;
	}
	
	public Curso buscarUno(String nombre) {
		for(Curso c:listaCursos) {
			if(c.getNombre().equals(nombre)) {
				return c;
			}
		}
		
		return null;
	}

}
