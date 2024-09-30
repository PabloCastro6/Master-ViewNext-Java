package com.curso.figurasAbstractas;

public class Rectangulo extends Figura {
	protected double base;
	protected double altura;
	
	
	public Rectangulo(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}

	@Override
	public double calcularArea() {
		// TODO Auto-generated method stub
		return base * altura;
	}
	@Override
	public double calcularPerimetro() {
		// TODO Auto-generated method stub
		return 2 * (base + altura);
	}
	

}
