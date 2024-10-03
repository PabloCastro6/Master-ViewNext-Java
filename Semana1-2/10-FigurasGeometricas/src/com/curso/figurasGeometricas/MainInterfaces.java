package com.curso.figurasGeometricas;

import com.curso.figurasAbstractas.Figura;

public class MainInterfaces {

	public static void main(String[] args) {
		    Rectangulo rectangulo = new Rectangulo(5, 3);
	        Cuadrado cuadrado = new Cuadrado(4);
	        Circulo circulo = new Circulo(2.5);

	        System.out.println("Área del rectángulo: " + rectangulo.calcularArea());
	        System.out.println("Perímetro del rectángulo: " + rectangulo.calcularPerimetro());

	        System.out.println("Área del cuadrado: " + cuadrado.calcularArea());
	        System.out.println("Perímetro del cuadrado: " + cuadrado.calcularPerimetro());

	        System.out.println("Área del círculo: " + circulo.calcularArea());
	        System.out.println("Perímetro del círculo: " + circulo.calcularPerimetro());
	    }

	}


