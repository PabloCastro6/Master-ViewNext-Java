package com.almacen.servlet;

import com.almacen.modelo.Categoria;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ProductoServlet")
public class ProductoServlet extends HttpServlet {
	private ProductoServicio productoServicio = new ProductoServicio();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		try {
			switch (action) {
			case "alta":
				agregarProducto(request, response);
				break;
			case "cargarProducto":
                cargarProducto(request, response);
                break;s
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
		// Obtener los parámetros del formulario
		String nombre = request.getParameter("nombre");
		String categoriaStr = request.getParameter("categoria");
		Categoria categoria = Categoria.valueOf(categoriaStr.toUpperCase()); // Convertimos el String a enum
		BigDecimal precio = new BigDecimal(request.getParameter("precio"));
		int stock = Integer.parseInt(request.getParameter("stock"));

		// Crear el producto
		Producto nuevoProducto = new Producto(nombre, categoria, precio, stock);

		// Agregar el producto a la base de datos
		productoServicio.agregarProducto(nuevoProducto);

		// Redirigir de vuelta al menú
		response.sendRedirect("menu.jsp");
	}

	private void cargarProducto(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Producto producto = productoServicio.buscarProducto(id);
		request.setAttribute("producto", producto);
		request.getRequestDispatcher("modificarProducto.jsp").forward(request, response);
	}

	private void modificarProducto(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		Categoria categoria = Categoria.valueOf(request.getParameter("categoria").toUpperCase());
		BigDecimal precio = new BigDecimal(request.getParameter("precio"));
		int stock = Integer.parseInt(request.getParameter("stock"));

		Producto productoModificado = new Producto(id, nombre, categoria, precio, stock);
		productoServicio.actualizarProducto(productoModificado);

		// Redirigir a una página de confirmación o de listado después de modificar
		response.sendRedirect("ProductoServlet?action=listar");
	}

	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id")); // Obtener el ID del producto a eliminar
		productoServicio.eliminarProducto(id); // Llama al servicio para eliminar el producto
		response.sendRedirect("menu.jsp"); // Redirige de vuelta al menú después de eliminar
	}

	private void listarProductos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Producto> productos = productoServicio.listarProductos();

			// Si productos es null, inicializamos con una lista vacía
			if (productos == null) {
				productos = new ArrayList<>();
			}

			System.out.println("Número de productos en ProductoServlet: " + productos.size()); // Depuración

			request.setAttribute("productos", productos);
			request.getRequestDispatcher("listarProductos.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException("Error al listar productos", e);
		}
	}

	private void buscarProducto(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Producto producto = productoServicio.buscarProducto(id);
		request.setAttribute("producto", producto);
		request.getRequestDispatcher("buscarProducto.jsp").forward(request, response);
	}
}
