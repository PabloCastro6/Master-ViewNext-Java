package com.curso.calculadora.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.curso.calculadora.Calculadora;

public class CalculadoraTest {
	 @Test
	    public void testConvertirEurosAPesetas() {
	        Calculadora calculadora = new Calculadora();
	        double euros = 10.0;
	        double resultadoEsperado = 10.0 * 166.386; // 1663.86 pesetas
	        double resultado = calculadora.convertirEurosAPesetas(euros);
	        
	        // Comparar resultado con una tolerancia de 0.001 para evitar problemas de precisión en coma flotante
	        assertEquals(resultadoEsperado, resultado, 0.001);
	    }

	
	}
