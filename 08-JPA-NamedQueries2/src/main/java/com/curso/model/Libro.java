package com.curso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity								
@Table(name="libros")
@NamedQueries({
	@NamedQuery(name="Libro.buscarTodos",query="SELECT l FROM Libro l"),
	@NamedQuery(name="Libro.buscarPorIsbn",query="SELECT l FROM Libro l WHERE isbn = :isbn"),
	@NamedQuery(name="Libro.buscarPorAutor",query="SELECT l FROM Libro l WHERE autor LIKE :autor"),
	@NamedQuery(name="Libro.buscarPorTitulo",query="SELECT l FROM Libro l WHERE titulo LIKE :titulo")
})
public class Libro {
	@Id
	private String isbn;
	private String titulo;
	private String autor;
	private int precio;
	
	public Libro() {
		super();
	}

	public Libro(String isbn) {
		super();
		this.isbn = isbn;
	}

	public Libro(String isbn, String titulo, String autor, int precio) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
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
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", precio=" + precio + "]";
	}
	
	
}
