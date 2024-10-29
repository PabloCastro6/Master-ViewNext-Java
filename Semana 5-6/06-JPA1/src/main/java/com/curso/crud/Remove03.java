package com.curso.crud;

import com.curso.model.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Remove03 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca"); //El nombre se encuentra en la unidad de persistencia-unit del persistence.xml
		EntityManager em = emf.createEntityManager(); 
		
		Libro libro = em.find(Libro.class, "1B"); //Comprobaciones
		
		
		em.getTransaction().begin();
		em.remove(libro);
		em.getTransaction().commit();
	}

}
