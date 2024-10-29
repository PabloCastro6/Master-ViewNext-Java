package com.curso.principal;

import java.util.List;

import com.curso.model.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Principal {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");//el nombre de la unidad de persistencia del persistence.xml
		EntityManager em = emf.createEntityManager();
/*		
		TypedQuery<Libro> consulta= em.createQuery("SELECT l FROM Libro l",Libro.class);
		List<Libro> libros = consulta.getResultList();
		System.out.println("=======>>>TODOS LOS LIBROS==========");
		for (Libro libro:libros) {
			System.out.println(libro);
		}
*/
		
		//Usando NamedQuery
		
		TypedQuery<Libro> consulta1 =em.createNamedQuery("buscarTodos", Libro.class);
		List<Libro> libros = consulta1.getResultList();
		System.out.println("=======>>>TODOS LOS LIBROS==========");
		for (Libro libro:libros) {
			System.out.println(libro);
		}
		
		
		TypedQuery<Libro> consulta2 =em.createNamedQuery("buscarPorIsbn", Libro.class);
		consulta2.setParameter("isbn", "1A");
		List<Libro> libros2 = consulta2.getResultList();
		System.out.println("=======>>>TODOS LOS LIBROS==========");
		for (Libro libro:libros2) {
			System.out.println(libro);
		}
		
		
	}

}
