package com.curso.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.curso.modelo.PaginaWeb;

/**
 * Servlet implementation class MostrarResultados
 */
public class MostrarResultados extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String tematica = (String) request.getAttribute("tematica");
		List<PaginaWeb> resultados = (List<PaginaWeb>) request.getAttribute("resultados");

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Resultados de la Búsqueda</title>");
		out.println("</head>");
		out.println("<body>");

		out.println("<h1>Resultados para la temática: " + tematica + "</h1>");

		if (resultados.isEmpty()) {
			out.println("<p>No se encontraron páginas para la temática: " + tematica + "</p>");
		} else {
			for (PaginaWeb pagina : resultados) {
				out.println("<h2>" + pagina.getTematica() + "</h2>");
				out.println("<p><strong>Dirección:</strong> <a href='" + pagina.getDireccion() + "'>"
						+ pagina.getDireccion() + "</a></p>");
				out.println("<p><strong>Descripción:</strong> " + pagina.getDescripcion() + "</p>");
				out.println("<hr>");
			}
		}

		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
