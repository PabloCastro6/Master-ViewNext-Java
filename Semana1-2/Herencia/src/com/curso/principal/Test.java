package com.curso.principal;

import com.curso.modelo.ClaseHija;
import com.curso.modelo.ClasePadre;

public class Test {

	public static void main(String[] args) {
		ClasePadre padre = new ClasePadre();
		ClaseHija hija = new ClaseHija();
		ClaseHija hija2 = new ClaseHija("Hola mundo", "desde una clase hija");
		
		padre.imprimir();
		hija.imprimir();
		hija2.imprimir();

	}

}
