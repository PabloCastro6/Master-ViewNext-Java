package com.curso.modelos;

import com.curso.interfaces.Imprime;

public class Pagina implements Imprime {
	//Constantes que haya que declarar
	private int nPaginas;
	private int nLineas;

	
	public Pagina(int nPaginas, int nLineas) {
		super();
		this.nPaginas = nPaginas;
		this.nLineas = nLineas;
	}

	@Override
	public void informeLargo() {
		System.out.println("INFORME LARGO " + nPaginas + " páginas con " +nLineas + "lineas.") ;

	}

	@Override
	public void informeCorto() {
		System.out.println("INFORME CORTO " + nPaginas + " páginas");

	}

}
