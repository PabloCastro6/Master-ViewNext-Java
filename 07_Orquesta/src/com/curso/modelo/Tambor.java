package com.curso.modelo;

public class Tambor extends Instrumento {

	private String tamanio;
	
	public Tambor(String nombre, String tipo, String tamanio) {
		super(nombre, tipo);
		this.tamanio = tamanio;
	}
	
//	public void aporrear() {
//		System.out.println("Aporreando tambor" + nombre);
//	}

	// Hacer que el tambor se haga de alguna manera "AUTOMATIZADA", no que pongamos nosotros 
	//a mano que el tambor aporrea.
	
	@Override
	public void tocar() {
		System.out.println("Aporreando tambor: " + nombre);
	}
}
