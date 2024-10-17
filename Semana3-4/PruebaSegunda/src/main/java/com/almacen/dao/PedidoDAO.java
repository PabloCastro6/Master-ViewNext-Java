package com.almacen.dao;

import java.util.ArrayList;
import java.util.List;
import com.almacen.modelo.Pedido;

public class PedidoDAO {
    private List<Pedido> pedidos = new ArrayList<>();

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidos;
    }
}
