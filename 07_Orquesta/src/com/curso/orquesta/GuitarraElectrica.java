package com.curso.orquesta;

public class GuitarraElectrica extends Guitarra {
	private int potencia;

	public GuitarraElectrica(String nombre, String tipo, int numeroCuerdas, int potencia) {
		super(nombre, tipo, numeroCuerdas);
		this.potencia = potencia;
	}
	
	@Override
	public void tocar() {
		System.out.println("Tocando la guitarra electrica");
	}

}
