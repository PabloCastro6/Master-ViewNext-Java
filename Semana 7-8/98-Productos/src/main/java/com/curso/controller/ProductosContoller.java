package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Producto;
import com.curso.service.ProductosService;

@RestController
public class ProductosContoller {
	@Autowired
	ProductosService productosService;
	@GetMapping(value="productos",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> productos(){
		return productosService.getAll();
	}
	@PutMapping(value="productos/{codigo}/{unidades}")
	public void actualizarStock(@PathVariable int codigo,@PathVariable int unidades) {
		productosService.actualizarStock(codigo, unidades);
	}
	@GetMapping(value="precio/{codigo}",produces=MediaType.TEXT_PLAIN_VALUE)
	public String precioProducto(@PathVariable int codigo) {
		return String.valueOf(productosService.getPrice(codigo));
	}
}

