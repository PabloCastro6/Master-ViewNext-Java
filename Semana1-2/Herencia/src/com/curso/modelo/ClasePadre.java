package com.curso.modelo;

import javax.annotation.processing.SupportedSourceVersion;

public class ClasePadre {
	private String mensaje;

	public ClasePadre() {
		super();
		this.mensaje = "Saludo1 desde la clase del padre";
	}

	public ClasePadre(String s) {
		super();
		this.mensaje = s;
	}
	
	public void imprimir() {
		System.out.println("Saludo2 desde la clase del padre");
		System.out.println(mensaje); 
	}
	
	

}
