package com.curso.principal;

import com.curso.consultas.Consulta;
import com.curso.model.Libro;

public class Principal {

	public static void main(String[] args) {
		Consulta consulta = new Consulta();

		// BUSCAR TODOS
		System.out.println("=========>>>TODOS==============");
		for (Libro libro : consulta.buscarTodos()) {
			System.out.println(libro);
		}

		// BUSCAR POR ISBN
		System.out.println("========>>>>>POR ISBN===");
		for (Libro libro : consulta.buscarPorIsbn("1A")) {
			System.out.println(libro);
		}
		
		// BUSCAR POR AUTOR
		System.out.println("========>>>>>POR AUTOR===");
		for (Libro libro : consulta.buscarPorAutor("Sebas")) {
			System.out.println(libro);
		}
		// BUSCAR POR TITULO
		System.out.println("========>>>>>POR TITULO===");
		for (Libro libro : consulta.buscarPorTitulo("Java")) {
			System.out.println(libro);
		}
		
	}

}
