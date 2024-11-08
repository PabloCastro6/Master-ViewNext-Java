package com.curso.service;	

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.model.Pedido;
import com.curso.repository.PedidosRepository;
@Service
public class PedidosServiceImpl implements PedidosService {
@Autowired
	PedidosRepository pedidosRepository;
@Autowired 
RestTemplate restTemplate;
private final String URL_MICROSERVICIO_PRODUCTOS = "http://localhost:8080";
	@Override
	public List<Pedido> pedidos() {
		return pedidosRepository.findAll();
	}

	@Override
	public void altaPedido(Pedido pedido) {
		pedido.setFechaPedido(LocalDate.now());
		pedido.setTotal(pedido.getUnidades()*obtenerPrecio(pedido.getCodigoProducto()));
		pedidosRepository.save(pedido);	
		actualizarStock(pedido.getCodigoProducto(),pedido.getUnidades());
	}
	
	private double obtenerPrecio(int codigoProducto) {
		return Double.parseDouble(restTemplate.getForObject(URL_MICROSERVICIO_PRODUCTOS.concat("/precio/{codigo}"), String.class,codigoProducto));
	}
	//Como ProductosController se enarga de hacer la actualización del stock, solo hago la llamada
	//El segundo parámetro es null porque el cuerpo no manda nada
	private void actualizarStock(int codigoProducto, int unidades) {
		restTemplate.put(URL_MICROSERVICIO_PRODUCTOS.concat("/productos/{codigo}/{unidades}"), null, codigoProducto,unidades);
	}
}
