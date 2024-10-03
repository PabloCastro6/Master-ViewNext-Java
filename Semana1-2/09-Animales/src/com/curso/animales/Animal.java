package com.curso.animales;

public abstract class Animal {
	protected int numeroDePatas;
	
	public Animal (int numeroDePatas) {
		this.numeroDePatas = numeroDePatas;
	}
	
	public void andar() {
		System.out.println( "Este animal anda sobre " + numeroDePatas + " patas");
		
	}

	public abstract void comer();
}
