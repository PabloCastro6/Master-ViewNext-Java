package com.curso.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.curso.modelo.PaginaWeb;
import com.curso.service.PaginaWebService;

/**
 * Servlet implementation class BuscarPaginas
 */
public class BuscarPaginas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private PaginaWebService servicio;
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		// Inicializa el servicio si aún no está inicializado
	    if (servicio == null) {
	        servicio = new PaginaWebService();
	    }

	    // Obtener la temática ingresada por el usuario
	    String tematica = request.getParameter("tematica");

	    // Buscar la página por temática
	    PaginaWeb pagina = servicio.buscarPorTematica(tematica);

	   
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    
	    out.println("<!DOCTYPE html>");
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<meta charset=\"UTF-8\">");
	    out.println("<title>Resultados de Búsqueda</title>");
	    out.println("</head>");
	    out.println("<body>");

	    if (pagina != null) {
	        out.println("<h1>Resultados de Búsqueda</h1>");
	        out.println("<p>Dirección: <a href='" + pagina.getDireccion() + "'>" + pagina.getDireccion() + "</a></p>");
	        out.println("<p>Temática: " + pagina.getTematica() + "</p>");
	        out.println("<p>Descripción: " + pagina.getDescripcion() + "</p>");
	    } else {
	        out.println("<h1>No se encontraron resultados para la temática: " + tematica + "</h1>");
	    }

	    out.println("</body>");
	    out.println("</html>");
	    out.close();
	}
}