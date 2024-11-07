package com.agencia.hoteles.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Hotel {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHotel;
	private String nombre;
	private String categoria;
	private Double precio; 
	private Boolean disponible;
	
	
	public Hotel() {
		super();
	}
	
	
	public Hotel(Integer idHotel, String nombre, String categoria, Double precio, Boolean disponible) {
		super();
		this.idHotel = idHotel;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.disponible = disponible;
	}


	public Integer getIdHotel() {
		return idHotel;
	}
	public void setIdHotel(Integer idHotel) {
		this.idHotel = idHotel;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Boolean getDisponible() {
		return disponible;
	}
	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}


	@Override
	public String toString() {
		return "Hotel [idHotel=" + idHotel + ", nombre=" + nombre + ", categoria=" + categoria + ", precio=" + precio
				+ ", disponible=" + disponible + "]";
	}
	
	
	
}
