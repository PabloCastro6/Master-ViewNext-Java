package com.almacen.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import com.almacen.dao.PedidoDAO;
import com.almacen.dao.ProductoDAO;
import com.almacen.modelo.Categoria;
import com.almacen.modelo.Pedido;
import com.almacen.modelo.Producto;

public class PedidoServlet extends HttpServlet {
    private PedidoDAO pedidoDAO = new PedidoDAO();
    private ProductoDAO productoDAO = new ProductoDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("crear".equals(action)) {
            crearPedido(request, response);
        } else if ("mostrarFormularioPedido".equals(action)) {
            mostrarFormularioPedido(request, response);
        } else if ("listarPedidos".equals(action)) {
            listarPedidos(request, response);
        }
    }
  
    private void listarPedidos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Pedido> pedidos = pedidoDAO.listarPedidos();  // Obtiene la lista de pedidos
        request.setAttribute("pedidos", pedidos);  // Coloca la lista en el request
        request.getRequestDispatcher("listarPedidos.jsp").forward(request, response);  // Redirige a la JSP
    }

    private void mostrarFormularioPedido(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lista de productos, simulada aquí o pasada desde la base de datos o DAO
        List<Producto> productos = productoDAO.listarProductos();
        request.setAttribute("productos", productos);
        request.getRequestDispatcher("realizarPedido.jsp").forward(request, response);
    }

    private void crearPedido(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreProducto = request.getParameter("nombreProducto");
        String categoria = request.getParameter("categoria");
        BigDecimal precio = new BigDecimal(request.getParameter("precio"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));

        // Convierte la categoría de String a Categoria (enum)
        Categoria categoriaEnum = Categoria.valueOf(categoria.toUpperCase());

        // Crea el producto usando el constructor correcto
        Producto producto = new Producto(nombreProducto, categoriaEnum, precio, stock);

        // Lógica para verificar stock y crear el pedido
        String estado;
        if (stock >= cantidad) {
            producto.setStock(stock - cantidad);  // Reduce el stock
            estado = "Confirmado";
        } else {
            estado = "Stock insuficiente";
        }

        Pedido pedido = new Pedido(producto, cantidad, estado);
        pedidoDAO.agregarPedido(pedido);

        request.setAttribute("mensaje", "Pedido de " + cantidad + " unidades de " + nombreProducto + " ha sido " + estado);

        // Redirigir o mostrar mensaje de confirmación
        List<Producto> productos = productoDAO.listarProductos();
        request.setAttribute("productos", productos);
        request.getRequestDispatcher("realizarPedido.jsp").forward(request, response);
    }
}
