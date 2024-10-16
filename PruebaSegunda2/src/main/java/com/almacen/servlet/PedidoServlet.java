package com.almacen.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.almacen.dao.PedidoDAO;
import com.almacen.dao.ProductoDAO;
import com.almacen.modelo.Pedido;
import com.almacen.modelo.Producto;

/**
 * Servlet implementation class PedidoServlet
 */
public class PedidoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductoDAO productoDAO = new ProductoDAO();
	private PedidoDAO pedidoDAO = new PedidoDAO();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

        if ("crear".equals(action)) {
            crearPedido(request, response);
        } else if ("listar".equals(action)) {
            listarPedidos(request, response);
        }
    }

    private void crearPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        Producto producto = productoDAO.buscarProducto(nombre);

        if (producto != null) {
            String mensaje;
            if (producto.getStock() >= cantidad) {
                pedidoDAO.crearPedido(producto, cantidad);
                mensaje = "Pedido creado con éxito para " + cantidad + " unidades de " + producto.getNombre();
            } else {
                mensaje = "Stock insuficiente para " + producto.getNombre();
            }
            request.setAttribute("mensaje", mensaje);
        }

        // Redirigir de vuelta a crearPedido.jsp con el mensaje y la lista de productos
        request.setAttribute("productos", productoDAO.listarProductos());
        request.getRequestDispatcher("crearPedido.jsp").forward(request, response);
    }

    private void listarPedidos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener la lista de pedidos y enviarla a listarPedidos.jsp
        List<Pedido> pedidos = pedidoDAO.listarPedidos();
        request.setAttribute("pedidos", pedidos);
        request.getRequestDispatcher("listarPedidos.jsp").forward(request, response);
    }
}