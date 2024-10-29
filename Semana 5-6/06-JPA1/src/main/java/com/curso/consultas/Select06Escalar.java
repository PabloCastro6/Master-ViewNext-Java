package com.curso.consultas;





import java.util.List;import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Select06Escalar {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca"); //El nombre se encuentra en la unidad de persistencia-unit del persistence.xml
		EntityManager em = emf.createEntityManager(); 
		
		//Una propiedad determinada
		TypedQuery<String> consulta = em.createQuery("SELECT l.autor FROM Libro l",String.class );
			
		
		
		
		
		List<String> autores = consulta.getResultList();
		
		for(String estring:autores) {
			System.out.println(estring);
		}
	}
}
