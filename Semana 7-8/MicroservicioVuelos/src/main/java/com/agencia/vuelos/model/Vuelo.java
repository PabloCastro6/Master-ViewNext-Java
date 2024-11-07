package com.agencia.vuelos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVuelo;
    private String compañia;
    private String fechaVuelo;
    private Double precio;
    private Integer plazasDisponibles;
    
    
	public Vuelo() {
		super();
	}


	public Vuelo(Integer idVuelo, String compañia, String fechaVuelo, Double precio, Integer plazasDisponibles) {
		super();
		this.idVuelo = idVuelo;
		this.compañia = compañia;
		this.fechaVuelo = fechaVuelo;
		this.precio = precio;
		this.plazasDisponibles = plazasDisponibles;
	}


	public Integer getIdVuelo() {
		return idVuelo;
	}


	public void setIdVuelo(Integer idVuelo) {
		this.idVuelo = idVuelo;
	}


	public String getCompañia() {
		return compañia;
	}


	public void setCompañia(String compañia) {
		this.compañia = compañia;
	}


	public String getFechaVuelo() {
		return fechaVuelo;
	}


	public void setFechaVuelo(String fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}


	public Double getPrecio() {
		return precio;
	}


	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	public Integer getPlazasDisponibles() {
		return plazasDisponibles;
	}


	public void setPlazasDisponibles(Integer plazasDisponibles) {
		this.plazasDisponibles = plazasDisponibles;
	}
    
    
    
    
}
