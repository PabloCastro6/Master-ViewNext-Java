package com.masterjava.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cursos")
/**
 * Clase modelo que implementa las funciones básicas de un Curso.
 * 
 * @author Pablo Castro Morato
 * @version 1.0 31/10/2024
 */
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Esto asegura que `codCurso` se autogenere si es
														// autoincremental
	@Column(name = "cod_curso") // Asegura que se mapee exactamente con la columna en la BBDD
	private int codCurso;

	@Column(name = "nombre") // Mapea el atributo `nombre` con la columna `nombre` en la base de datos
	private String nombre;

	@Column(name = "duracion") // Mapea el atributo `duracion` con la columna `duracion` en la base de datos
	private int duracion;

	@Column(name = "precio") // Mapea el atributo `precio` con la columna `precio` en la base de datos
	private double precio;

	public Curso() {
	}

	public Curso(int codCurso, String nombre, int duracion, double precio) {
		this.codCurso = codCurso;
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
	}

	public int getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codCurso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return codCurso == other.codCurso;
	}

	@Override
	public String toString() {
		return "Curso [codCurso=" + codCurso + ", nombre=" + nombre + ", duracion=" + duracion + ", precio=" + precio
				+ "]";
	}

}
