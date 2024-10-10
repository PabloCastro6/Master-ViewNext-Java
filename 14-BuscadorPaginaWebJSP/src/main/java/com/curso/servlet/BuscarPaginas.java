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
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PaginaWebService servicio = new PaginaWebService();
        String tematica = request.getParameter("tematica");

        List<PaginaWeb> paginas = servicio.buscarPorTematica(tematica);

        if (paginas != null && !paginas.isEmpty()) {
            request.setAttribute("paginas", paginas);
            RequestDispatcher dispatcher = request.getRequestDispatcher("resultados.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }
    }
}
