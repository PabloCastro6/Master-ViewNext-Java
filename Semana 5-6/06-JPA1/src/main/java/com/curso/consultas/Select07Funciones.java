package com.curso.consultas;





import java.util.List;

import com.curso.model.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Select07Funciones {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca"); //El nombre se encuentra en la unidad de persistencia-unit del persistence.xml
		EntityManager em = emf.createEntityManager(); 
		
		TypedQuery<Libro> consulta = em.createQuery("SELECT UPPER(l.autor) FROM Libro l",Libro.class);
		List<Libro> autores = consulta.getResultList();
		
		for(Libro estring:autores) {
			System.out.println(estring);
		}
	}
}


