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
import java.util.List;

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

	private void modificarProducto(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// Obtener los parámetros del formulario
		int id = Integer.parseInt(request.getParameter("id")); // El ID del producto a modificar
		String nombre = request.getParameter("nombre");
		String categoriaStr = request.getParameter("categoria");
		Categoria categoria = Categoria.valueOf(categoriaStr.toUpperCase()); // Convertir el String a enum
		BigDecimal precio = new BigDecimal(request.getParameter("precio"));
		int stock = Integer.parseInt(request.getParameter("stock"));

		// Crear un objeto Producto con los nuevos valores
		Producto productoModificado = new Producto(id, nombre, categoria, precio, stock); // Asegúrate de tener este
																							// constructor

		// Llamar al servicio para modificar el producto en la base de datos
		productoServicio.actualizarProducto(productoModificado);

		// Redirigir de vuelta al menú
		response.sendRedirect("menu.jsp");
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
	        // Llama al servicio para obtener la lista de productos
	        List<Producto> productos = productoServicio.listarProductos();
	        
	        // Mensaje de depuración para verificar que se están obteniendo productos
	        System.out.println("Número de productos recuperados: " + productos.size());

	        // Coloca la lista de productos en el request
	        request.setAttribute("productos", productos);
	        
	        // Despacha al JSP
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
