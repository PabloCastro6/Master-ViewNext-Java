package com.curso.colegio;

import java.util.Objects;

import javax.management.RuntimeErrorException;

public class Nota {
	private double valor;
	private String asignatura;
	
	public Nota() {
		super();
	}
	public Nota(double valor, String asignatura) {
		super();
		this.valor = valor;
		this.asignatura = asignatura;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(asignatura, valor);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nota other = (Nota) obj;
		return Objects.equals(asignatura, other.asignatura)
				&& Double.doubleToLongBits(valor) == Double.doubleToLongBits(other.valor);
	}
	
	//Cambiar las variables dependiendo si es nota/asignatura
	public boolean esMismaAsignatura(Nota otra) {
		if(this.getAsignatura().equals(otra.getAsignatura())) {
			return true;
		}else {
			return false;
		}
		
	}

	public boolean esMayor(Nota otra) {
		
		if(this.esMismaAsignatura(otra)) {
			if(this.getAsignatura().equals(otra.getAsignatura())) {
				return true;
			}else {
				return false;
			}
		}else {
			throw new RuntimeException("Las notas no son comparables porque no son de la misma asignatura");
		}
	}
	
}
