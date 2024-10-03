package com.curso.modelo;

public class ClaseHija extends ClasePadre {
	private String otroMensaje;
	
	public ClaseHija() {
		super("Desde la clase hija");
	}

	public ClaseHija(String s, String otro) {
		super(s);
		this.otroMensaje = otro;
		
	}

	@Override
	public void imprimir() {
		System.out.println("En la clase hija antes de super.imprimir");
		super.imprimir();
		System.out.println("En la clase hija despues de super.imprimir");
		System.out.println("Eco de " + otroMensaje);
	}
	
	

	
	
	

}
