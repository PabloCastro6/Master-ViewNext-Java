package com.cursojava.ejemplo01;

public class Biblioteca {

	public static void main(String[] args) {
		Libro libro1 = new Libro();
		libro1.isbn = 12345;
		libro1.titulo = "El mundo de java";
		libro1.autor = "Pepito";
		libro1.numeroPaginas = 345;
		
		//syso+Ctrl+barraEspaciadora
		System.out.println("Libro 1: " + libro1.titulo);

	
	Libro libro2 = new Libro(67890);
	System.out.println("Libro 2: " + libro2.isbn);
	
	libro1.titulo="Esto es un desastre";
	System.out.println("Libro 1: " + libro1.titulo);
	}

}