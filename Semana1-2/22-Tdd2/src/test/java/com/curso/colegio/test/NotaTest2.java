package com.curso.colegio.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.curso.colegio.Nota;

class NotaTest2 {
	
	Nota nota1 = null;
	Nota nota2 = null;
	Nota nota3  = null;
	Nota nota4 = null;
	Nota nota5 = null;

	@BeforeEach
	public void setup() {
	 nota1 = new Nota(8, "lengua");
	 nota2 = new Nota(7, "lengua");
	 nota3 = new Nota(9, "Sociales");
	 nota4 = new Nota(8, "lengua");
	 nota5 = new Nota(8, "sociales");
	
	}
	@Test
	void esMismaAsignaturaTest() {
		assertTrue(nota1.esMismaAsignatura(nota4));
		assertFalse(nota3.esMismaAsignatura(nota4));
	}
	
	@Test
	void testIgualdadNotasTest() {
		assertTrue( nota1.equals(nota5));
		
		
	}
	
	@Test
	void NoIgualdadNotasTest() {
		assertFalse( nota1.equals(nota2));
		
		
	}
	
	@Test
	void NotaNoEsMayorOtraTest() {

		assertThrows(RuntimeException.class,()->nota1.esMayor(nota3));
	}
	
	
	

}
