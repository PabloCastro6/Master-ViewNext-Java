package com.almacen.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import com.almacen.dao.ProductoDAO;
import com.almacen.modelo.Producto;
import com.almacen.modelo.Categoria;

public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDAO = new ProductoDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String action = request.getParameter("action");

	        switch (action) {
	            case "alta":
	                agregarProducto(request);
	                response.sendRedirect("menu.jsp");
	                break;
	            case "modificar":
	                modificarProducto(request);
	                response.sendRedirect("menu.jsp");
	                break;
	            case "eliminar":
	                eliminarProducto(request);
	                response.sendRedirect("menu.jsp");
	                break;
	            case "listar":
	                listarProductos(request, response);
	                break;
	            case "buscar":
	            	List<Producto> productos = productoDAO.listarProductos();
	                request.setAttribute("productos", productos);
	                request.getRequestDispatcher("buscarProducto.jsp").forward(request, response);
	                break;
	           
	            default:
	                response.sendRedirect("menu.jsp");
	                break;
	        }
	    }

	    private void agregarProducto(HttpServletRequest request) {
	        Producto producto = new Producto(
	                request.getParameter("nombre"),
	                Categoria.valueOf(request.getParameter("categoria").toUpperCase()),
	                new BigDecimal(request.getParameter("precio")),
	                Integer.parseInt(request.getParameter("stock"))
	        );
	        productoDAO.agregarProducto(producto);
	    }

	    private void modificarProducto(HttpServletRequest request) {
	        Producto producto = new Producto(
	                request.getParameter("nombre"),
	                Categoria.valueOf(request.getParameter("categoria").toUpperCase()),
	                new BigDecimal(request.getParameter("precio")),
	                Integer.parseInt(request.getParameter("stock"))
	        );
	        productoDAO.actualizarProducto(producto);
	    }

	    private void eliminarProducto(HttpServletRequest request) {
	        productoDAO.eliminarProducto(request.getParameter("nombre"));
	    }

	    private void listarProductos(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        List<Producto> productos = productoDAO.listarProductos();
	        request.setAttribute("productos", productos);
	        request.getRequestDispatcher("listarProductos.jsp").forward(request, response);
	    }

	    private void buscarProducto(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String nombre = request.getParameter("nombre");
	        Producto producto = productoDAO.buscarProducto(nombre);
	        request.setAttribute("producto", producto);
	        request.getRequestDispatcher("detalleProducto.jsp").forward(request, response);
	    }
	    

	    
	    
	}