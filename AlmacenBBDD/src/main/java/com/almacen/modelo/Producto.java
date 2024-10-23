package com.almacen.modelo;

import java.math.BigDecimal;

public class Producto {
	private int id;
	private String nombre;
	private Categoria categoria; // Usar el enum Categoria en lugar de String
	private BigDecimal precio;
	private int stock;

	public Producto(String nombre, Categoria categoria, BigDecimal precio, int stock) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.stock = stock;
	}

	public Producto(int id, String nombre, Categoria categoria, BigDecimal precio, int stock) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.stock = stock;
	}

	// Getters y setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
}