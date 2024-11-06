package com.curso.formacion.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;


@Entity
public class Formacion {
	    private String curso;
	    private int asignaturas;
	    private BigDecimal precio;
		public Formacion() {
			super();
		}
		public Formacion(String curso, int asignaturas, BigDecimal precio) {
			super();
			this.curso = curso;
			this.asignaturas = asignaturas;
			this.precio = precio;
		}
		public String getCurso() {
			return curso;
		}
		public void setCurso(String curso) {
			this.curso = curso;
		}
		public int getAsignaturas() {
			return asignaturas;
		}
		public void setAsignaturas(int asignaturas) {
			this.asignaturas = asignaturas;
		}
		public BigDecimal getPrecio() {
			return precio;
		}
		public void setPrecio(BigDecimal precio) {
			this.precio = precio;
		}
		@Override
		public String toString() {
			return "Formacion [curso=" + curso + ", asignaturas=" + asignaturas + ", precio=" + precio + "]";
		}

	    
}
