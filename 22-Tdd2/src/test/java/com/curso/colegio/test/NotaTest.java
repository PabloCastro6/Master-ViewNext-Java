package com.curso.colegio.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.curso.colegio.Nota;

class NotaTest {

	@Test
	void esMismaAsignaturaTest() {
		//Arrange
		Nota nota1 = new Nota(8, "lengua");
		Nota nota2 = new Nota(7, "lengua");
		Nota nota3 = new Nota(9, "Sociales");
		
		
		
		//Act
		boolean esMisma = nota1.esMismaAsignatura(nota2);
		boolean esDistinta = nota1.esMismaAsignatura(nota3);
	
			
		//Assert
		assertTrue(esMisma);
		// asserTrue (nota1.esMismaAsignatura(nota2)
		assertFalse(esDistinta);
	}
	
	@Test
	void testIgualdadNotasTest() {
		Nota nota1 = new Nota(8, "lengua");
		Nota nota2 = new Nota(8, "lengua");
		
		
		boolean iguales = nota1.equals(nota2);
		
		assertTrue(iguales);
		
	}
	
	@Test
	void NoIgualdadNotasTest() {
		Nota nota1 = new Nota(8, "lengua");
		Nota nota2 = new Nota(9, "lengua");
		
		
		boolean NoIguales = nota1.equals(nota2);
		
		assertFalse(NoIguales);
		
	}
	
	@Test
	void NotaNoEsMayorOtraTest() {
		Nota nota1 = new Nota(8, "Lengua");
		Nota nota2 = new Nota(8, "Sociales");
		
		assertThrows(RuntimeException.class,()->nota1.esMayor(nota2));
	}
	
	
	/*
	@Test
	void test() {
		fail("Not yet implemented");
	}
	*/
	

}
