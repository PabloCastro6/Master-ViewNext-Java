package com.curso.calculadora.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.curso.calculadora.Calculadora;

public class CalculadoraTest {
	@Test
    public void testConvertirEurosAPesetas() {
        // Arrange: Configuración de las condiciones iniciales
        Calculadora calculadora = new Calculadora();
        double euros = 10.0; // Cantidad de euros a convertir
        double resultadoEsperado = euros * 166.386; // Resultado esperado de la conversión

        // Act: Ejecución de la acción a probar
        double resultado = calculadora.convertirEurosAPesetas(euros);
        
        // Assert: Verificación de los resultados
        assertEquals(resultadoEsperado, resultado, 0.001);
    }
	}
