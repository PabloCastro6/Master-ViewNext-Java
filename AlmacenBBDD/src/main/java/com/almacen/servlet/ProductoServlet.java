package com.almacen.servlet;

import com.almacen.modelo.Producto;
import com.almacen.servicio.ProductoServicio;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/productos")
public class ProductoServlet extends HttpServlet {
	private ProductoServicio productoServicio = new ProductoServicio();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		try {
			switch (action) {
			case "alta":
				agregarProducto(request, response);
				break;
			case "modificar":
				modificarProducto(request, response);
				break;
			case "eliminar":
				eliminarProducto(request, response);
				break;
			case "listar":
				listarProductos(request, response);
				break;
			case "buscar":
				buscarProducto(request, response);
				break;
			}
		} catch (SQLException e) {
			throw new ServletException("Error en la base de datos", e);
		}
	}

	private void agregarProducto(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String categoria = request.getParameter("categoria");
		BigDecimal precio = new BigDecimal(request.getParameter("precio"));
		int stock = Integer.parseInt(request.getParameter("stock"));

		Producto producto = new Producto(nombre, categoria, precio, stock);
		productoServicio.agregarProducto(producto);

		response.sendRedirect("menu.jsp");
	}

	private void modificarProducto(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String categoria = request.getParameter("categoria");
		BigDecimal precio = new BigDecimal(request.getParameter("precio"));
		int stock = Integer.parseInt(request.getParameter("stock"));

		Producto producto = new Producto(nombre, categoria, precio, stock);
		producto.setId(id);
		productoServicio.actualizarProducto(producto);

		response.sendRedirect("menu.jsp");
	}

	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		productoServicio.eliminarProducto(id);

		response.sendRedirect("menu.jsp");
	}

	private void listarProductos(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		List<Producto> productos = productoServicio.listarProductos();
		request.setAttribute("productos", productos);
		request.getRequestDispatcher("listarProductos.jsp").forward(request, response);
	}

	private void buscarProducto(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Producto producto = productoServicio.buscarProducto(id);
		request.setAttribute("producto", producto);
		request.getRequestDispatcher("buscarProducto.jsp").forward(request, response);
	}
}
