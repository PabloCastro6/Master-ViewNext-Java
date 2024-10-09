package com.curso.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
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
		 
        String tematica = request.getParameter("tematica"); // Obtener la temática del formulario

        
        List<PaginaWeb> paginasEncontradas = servicio.buscarPorTematica(tematica); // Llamar al servicio para buscar páginas por temática

        if (paginasEncontradas != null && !paginasEncontradas.isEmpty()) {
            // Si se encuentran páginas, redirigir a la página de resultados
            request.setAttribute("paginas", paginasEncontradas);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/MostrarResultados");
            dispatcher.forward(request, response);
        } else {
            // Si no se encuentran páginas, redirigir a la página de error
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ErrorServlet");
            dispatcher.forward(request, response);
        }
    }
}
	