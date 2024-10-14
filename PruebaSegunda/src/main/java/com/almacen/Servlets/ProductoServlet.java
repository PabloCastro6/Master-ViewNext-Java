package com.almacen.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.almacen.dao.ProductoDAO;
import com.almacen.modelo.Producto;

/**
 * Servlet implementation class ProductoServlet
 */
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private ProductoDAO productoDAO = new ProductoDAO();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String action = request.getParameter("action");
		
		 if ("alta".equals(action)) {
	            Producto producto = new Producto(
	                request.getParameter("nombre"),
	                request.getParameter("categoria"),
	                Double.parseDouble(request.getParameter("precio")),
	                Integer.parseInt(request.getParameter("stock"))
	            );
	            productoDAO.agregarProducto(producto);
	            System.out.println("Producto añadido: " + producto.getNombre());
	            listarProductos(request, response); // Llama a listarProductos después de agregar el producto

	        } else if ("eliminar".equals(action)) {
	            productoDAO.eliminarProducto(request.getParameter("nombre"));
	            listarProductos(request, response);

	        } else if ("modificar".equals(action)) {
	            Producto producto = new Producto(
	                request.getParameter("nombre"),
	                request.getParameter("categoria"),
	                Double.parseDouble(request.getParameter("precio")),
	                Integer.parseInt(request.getParameter("stock"))
	            );
	            productoDAO.actualizarProducto(producto);
	            listarProductos(request, response);

	        } else if ("buscar".equals(action)) {
	            Producto producto = productoDAO.buscarProducto(request.getParameter("nombre"));
	            request.setAttribute("producto", producto);
	            request.getRequestDispatcher("detalleProducto.jsp").forward(request, response);

	        } else if ("listar".equals(action)) {
	            listarProductos(request, response);
	        }
	    }

	    private void listarProductos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        List<Producto> productos = productoDAO.listarProductos();
	        request.setAttribute("productos", productos);
	        request.getRequestDispatcher("productos.jsp").forward(request, response);
	    }
	}