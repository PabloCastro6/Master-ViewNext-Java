package com.curso.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.curso.modelo.Producto;

/**
 * Servlet implementation class LeerSesionProducti
 */
public class LeerSesionProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		Producto producto = (Producto) sesion.getAttribute("producto");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Leer Producto usando Sesion</title>");
		out.println("</head>");
		out.println("<body>");
		 
		if(producto!=null) {
			out.println("<p>id: "+ producto.getId()+ " producto: " + producto.getNombre()+ " precio: " + producto.getPrecio()+"</p>");
		}else {
			out.println("<p> Sesion finalizada </p>");
		}
		
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

	

}