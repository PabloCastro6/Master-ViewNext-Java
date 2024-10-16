package com.almacen.dao;

import java.util.ArrayList;
import java.util.List;

import com.almacen.modelo.Pedido;
import com.almacen.modelo.Producto;

public class PedidoDAO {
	private static List<Pedido> pedidos = new ArrayList<>();

	// Método para crear un pedido
	public String crearPedido(Producto producto, int cantidad) {
		// Verificar si hay stock suficiente para el pedido
		if (producto.getStock() >= cantidad) {
			// Reducir el stock del producto
			producto.setStock(producto.getStock() - cantidad);

			// Crear el pedido y añadirlo a la lista de pedidos
			Pedido pedido = new Pedido(producto, cantidad);
			pedido.setEstado("CONFIRMADO");
			pedidos.add(pedido);

			return "Pedido creado con éxito para " + cantidad + " unidades de " + producto.getNombre();
		} else {
			// Stock insuficiente
			return "Stock insuficiente para el pedido de " + producto.getNombre();
		}
	}

	// Método para listar todos los pedidos
	public List<Pedido> listarPedidos() {
		return pedidos;
	}
}