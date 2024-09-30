package com.cuso.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.curso.Calculadora;

class CalculadoraTest {

	@Test
	void sumarTest() {
		//Arrange--organizar
		Calculadora calculadora = new Calculadora();
		
		//Act-----actuar, ejecutar
		double suma = calculadora.sumar(2.5, 4.5);
		
		
		
		//Assert -- aseverar
		assertEquals(7.0,suma);
	}
	
	@Test
	void restarTest() {
		//
		Calculadora calculadora = new Calculadora();
		
		
		 double resta = calculadora.restar(5.0,0);
		 assertEquals(5.0, resta);
		 
		 
		 
	//assertTrue 
	//assertFalse
	//assertNotEquals	
		
	}

}
