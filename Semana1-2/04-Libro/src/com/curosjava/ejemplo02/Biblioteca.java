package com.curosjava.ejemplo02;

public class Biblioteca {

	public static void main(String[] args) {

		Libro libro1 = new Libro(12345);
		libro1.setTitulo("El mundo de java");
		libro1.setAutor("Pepito");
		libro1.setNumeroPaginas(345);
		
	

		System.out.println("Libro1: " + libro1.getTitulo());
		System.out.println(libro1);
		System.out.println(libro1.toString());

		Libro libro2 = new Libro(67890);
		libro2.setTitulo("Spiderman");
		libro2.setAutor("Juanito");
		libro2.setNumeroPaginas(340);

		System.out.println("Libro 2: " + libro2.getTitulo());
		System.out.println("Libro 2: " + libro2.getNumeroPaginas());
		

		
//		if (libro1.getNumeroPaginas() > libro2.getNumeroPaginas()) {
//			System.out.println(libro1.getTitulo() + " tiene más páginas.");
//		} else if (libro1.getNumeroPaginas() < libro2.getNumeroPaginas()) {
//			System.out.println(libro2.getTitulo() + " tiene más páginas.");
//		} else {
//			System.out.println("Tienen el mismo número de páginas.");
//		}
	}
}
