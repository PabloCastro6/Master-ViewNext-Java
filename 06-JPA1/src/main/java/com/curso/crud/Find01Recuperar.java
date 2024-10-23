package com.curso.crud;

import com.curso.model.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Find01Recuperar {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca"); //El nombre se encuentra en la unidad de persistencia-unit del persistence.xml
		EntityManager em = emf.createEntityManager(); 
		
		Libro libro =  em.find(Libro.class, "1A");  //valor de la clase primaria - nombre del libro
		
		if(libro != null) {
			System.out.println(libro.getIsbn());
			System.out.println(libro.getTitulo());
			System.out.println(libro.getAutor());
			System.out.println(libro.getPrecio());
		} else {
			System.out.println("Libro no encontrado");
		}
		
		
		
	}
}
