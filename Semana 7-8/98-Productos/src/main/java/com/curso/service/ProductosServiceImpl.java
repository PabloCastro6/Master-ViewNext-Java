package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.model.Producto;
import com.curso.repository.ProductosRepository;
@Service
public class ProductosServiceImpl implements ProductosService {
	@Autowired
	ProductosRepository productosRepository;
	@Override
	public List<Producto> getAll() {
		return productosRepository.findAll();
	}

	@Override
	public double getPrice(int codigoProducto) {
		Producto producto = productosRepository.findById(codigoProducto).orElse(null);		//orElseThrow(() -> new IllegalArgumentException("Codigo no valido"));
		return producto!=null? producto.getPrecioUnitario():0;
	}

	@Override
	public void actualizarStock(int codigoProducto, int unidades) {
		Producto producto=productosRepository.findById(codigoProducto).orElse(null);
		if(producto!=null&&producto.getStock()>unidades) {
			producto.setStock(producto.getStock()-unidades);
			productosRepository.save(producto);
		}
}
}
