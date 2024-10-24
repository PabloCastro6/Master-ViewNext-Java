package com.curso.consultas;

import java.util.List;

import com.curso.model.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Consulta {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca1");
	private EntityManager em;
	private TypedQuery<Libro> libro;
	
	public List<Libro>buscarTodos(){
		em = emf.createEntityManager();
		libro = em.createNamedQuery("Libro.buscarTodos", Libro.class);
		return libro.getResultList();
	}
	
	public List<Libro> buscarPorIsbn(String isbn) {
		em = emf.createEntityManager();
		em.createNamedQuery("Libro.buscarPorIsbn", Libro.class);
		libro.setParameter("isbn", isbn);
		return libro.getResultList();
	}
	
	public List<Libro> buscarPorAutor(String autor) {
		em = emf.createEntityManager();
		em.createNamedQuery("Libro.buscarPorAutor", Libro.class);
		libro.setParameter("autor", autor);
		return libro.getResultList();
	}
	
	public List<Libro> buscarPorTitulo(String titulo) {
		em = emf.createEntityManager();
		em.createNamedQuery("Libro.buscarPorTitulo", Libro.class);
		libro.setParameter("titulo", titulo);
		return libro.getResultList();
	}
	
}
