package com.curso.orquesta;

public class Tambor extends Instrumento {

	private String tamaño;
	
	public Tambor(String nombre, String tipo, String tamaño) {
		super(nombre, tipo);
		this.tamaño = tamaño;
	}
	
	public void aporrear() {
		System.out.println("Aporreando tambor" + nombre);
	}

}
