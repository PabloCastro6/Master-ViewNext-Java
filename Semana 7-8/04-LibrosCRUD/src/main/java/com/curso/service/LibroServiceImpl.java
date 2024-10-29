package com.curso.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.curso.model.Libro;

@Service
public class LibroServiceImpl implements LibroService {
	public List<Libro> libros;

	public LibroServiceImpl() {
		libros = new ArrayList<Libro>(
				List.of(new Libro(1, "Grecia", "guia viaje"), new Libro(2, "Italia", "guia viaje"),
						new Libro(3, "Perla Negra", "misterio"), new Libro(4, "Días de lluvia", "teatro")));
	}

	@Override
	public List<Libro> libros() {
		return libros;
	}

	@Override
	//Recorre la lista con un for y devuelve el libro que coincida con el ISBN; si no se encuentra, retorna null.
	public Libro buscarLibro(int isbn) {
		for (Libro libro : libros) {
			if (libro.getIsbn() == isbn) {
				return libro;
			}
		}
		return null;
	}

	@Override
	//Usa un for para verificar si ya existe un libro con el mismo ISBN antes de añadirlo.
	public void altaLibro(Libro libro) {
		if (libro != null) {
			boolean existe = false;
			for (Libro l : libros) {
				if (l.getIsbn() == libro.getIsbn()) {
					existe = true;
					break;
				}
			}
			if (!existe) {
				libros.add(libro);
			}
		}

	}

	@Override
	//Encuentra el libro con el ISBN correspondiente y actualiza sus datos.
	public void actualizarLibro(Libro libro) {
		for (Libro l : libros) {
			if (l.getIsbn() == libro.getIsbn()) {
				l.setTitulo(libro.getTitulo());
				l.setTematica(libro.getTematica());
				break;
			}
		}

	}

	@Override
	//Recorre la lista y elimina el primer libro que coincide con el ISBN, devolviendo la lista actualizada.
	public List<Libro> eliminarLibro(int isbn) {
		for (int i = 0; i < libros.size(); i++) {
			if (libros.get(i).getIsbn() == isbn) {
				libros.remove(i);
				break;
			}
		}
		return libros;
	}
}
