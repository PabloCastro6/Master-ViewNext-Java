package com.curso.figurasGeometricas;

public class Rectangulo implements IFigura {
	protected double base;
	protected double altura;
	
	  public Rectangulo(double base, double altura) {
	        this.base = base;
	        this.altura = altura;
	    }
	  
	  // Implementación de los métodos de la interfaz
	    @Override
	    public double calcularArea() {
	        return base * altura;
	    }

	    @Override
	    public double calcularPerimetro() {
	        return 2 * (base + altura);
	    }
	}