package com.curso.crud;

import com.curso.model.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Merge04Actualizar {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca"); //El nombre se encuentra en la unidad de persistencia-unit del persistence.xml
		EntityManager em = emf.createEntityManager(); 
		
		Libro libro = em.find(Libro.class, "1A");
		
		em.getTransaction().begin();
		libro.setAutor("Pepito");
		libro.setPrecio(222);
		em.merge(libro);
		
		
		em.getTransaction().commit();

	}

}
