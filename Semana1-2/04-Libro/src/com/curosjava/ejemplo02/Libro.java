package com.curosjava.ejemplo02;

import java.util.Objects;

public class Libro {
	private int isbn;
	private String titulo;
	private String autor;
	private int  numeroPaginas;
	
	
	//Constructor permite inicializar el objeto 
/*	public Libro() {
	}
*/

	public Libro(int isbn) {
		super();
		this.isbn = isbn;
	}


	public Libro(int isbn, String titulo, String autor, int numeroPaginas) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.numeroPaginas = numeroPaginas;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}


	public int getIsbn() {
		return isbn;
	}


	public String getTitulo() {
		return titulo;
	}


	public String getAutor() {
		return autor;
	}


	public int getNumeroPaginas() {
		return numeroPaginas;
	}


//	@Override
//	public String toString() {
//		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", numeroPaginas=" + numeroPaginas
//				+ "]";
//	}
	
	// Método toString
    @Override
    public String toString() {
        return "El libro con ISBN " + isbn + " escrito por " + autor + " tiene " + numeroPaginas + " páginas.";
    }
    
	// Método para comparar páginas
    public String compararPaginas(Libro otroLibro) {
        if (this.numeroPaginas > otroLibro.getNumeroPaginas()) {
            return this.titulo + " tiene más páginas que " + otroLibro.getTitulo();
        } else if (this.numeroPaginas < otroLibro.getNumeroPaginas()) {
            return otroLibro.getTitulo() + " tiene más páginas que " + this.titulo;
        } else {
            return "Ambos libros tienen el mismo número de páginas.";
        }
    }
    
	@Override
	public int hashCode() {
		return Objects.hash(isbn, titulo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return isbn == other.isbn && Objects.equals(titulo, other.titulo);
	}

	
	
	
	

}
