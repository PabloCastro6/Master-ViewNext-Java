package com.almacen.servlet;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import com.almacen.dao.ProductoDAO;
import com.almacen.modelo.Producto;
import com.almacen.servicio.ProductoServicio;
import com.almacen.modelo.Categoria;

public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDAO = new ProductoDAO();
	 private ProductoServicio productoServicio = new ProductoServicio();

	
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String action = request.getParameter("action");

		 switch (action) {
	        case "alta":
	            agregarProducto(request, response);
	            break;
	        case "modificar":
	            modificarProducto(request);
	            response.sendRedirect("menu.jsp");
	            break;
	        case "mostrarModificar":
	            mostrarFormularioModificar(request, response);
	            break;
	        case "mostrarEliminar":
	            mostrarFormularioEliminar(request, response);
	            break;
	        case "eliminar":
	            eliminarProducto(request);
	            response.sendRedirect("menu.jsp");
	            break;
	        
	        case "listar":
	            listarProductos(request, response);
	            break;
	        case "buscar":
	            buscarProducto(request, response);
	            break;
	        default:
	            response.sendRedirect("menu.jsp");
	            break;
	    }
	}
	private void agregarProducto(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    String nombre = request.getParameter("nombre");
	    String categoria = request.getParameter("categoria");
	    BigDecimal precio = new BigDecimal(request.getParameter("precio"));
	    int stock = Integer.parseInt(request.getParameter("stock"));

	    Producto nuevoProducto = new Producto(nombre, Categoria.valueOf(categoria.toUpperCase()), precio, stock);
	    productoServicio.agregarProducto(nuevoProducto);

	    // Establece el mensaje de confirmación y redirige de nuevo al formulario
	    request.setAttribute("mensaje", "Producto agregado correctamente.");
	    request.getRequestDispatcher("agregarProducto.jsp").forward(request, response);
	}

	    private void modificarProducto(HttpServletRequest request) {
	    	  String nombre = request.getParameter("nombre");
	    	    String campo = request.getParameter("campo");
	    	    String nuevoValor = request.getParameter("nuevoValor");

	    	    productoServicio.modificarCampoProducto(nombre, campo, nuevoValor);
	    	}
	    private void mostrarFormularioModificar(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        // Obtener la lista de productos
	        List<Producto> productos = productoServicio.listarProductos();
	        // Colocar la lista en el atributo "productos" del request
	        request.setAttribute("productos", productos);
	        // Redirigir a modificarProducto.jsp
	        request.getRequestDispatcher("modificarProducto.jsp").forward(request, response);
	    }

	    private void mostrarFormularioEliminar(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        // Obtener la lista de productos
	        List<Producto> productos = productoServicio.listarProductos();
	        // Colocar la lista en el atributo "productos" del request
	        request.setAttribute("productos", productos);
	        // Redirigir a borrarProducto.jsp
	        request.getRequestDispatcher("borrarProducto.jsp").forward(request, response);
	    }

	    private void eliminarProducto(HttpServletRequest request) {
	        String nombre = request.getParameter("nombre");
	        productoServicio.eliminarProducto(nombre);
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
	        Producto producto = productoServicio.buscarProducto(nombre);  // Busca el producto por nombre
	        request.setAttribute("producto", producto);

	        // Cargar la lista de productos para el <select> (por si el usuario desea buscar otro producto)
	        List<Producto> productos = productoServicio.listarProductos();
	        request.setAttribute("productos", productos);

	        // Redirigir a buscarProducto.jsp para mostrar el resultado
	        request.getRequestDispatcher("buscarProducto.jsp").forward(request, response);
	    }

	    
	    
	}