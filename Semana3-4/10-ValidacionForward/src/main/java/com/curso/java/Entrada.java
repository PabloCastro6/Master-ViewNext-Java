package com.curso.java;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

/**
 * Servlet implementation class Entrada
 */
public class Entrada extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LocalDate fecha = (LocalDate) request.getAttribute("fecha");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		
		String usuario = request.getParameter("usuario");
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Datos correctos</title>");
		out.println("</head>");
		out.println("<body>");

		out.println("<h2>Bienvenid@ " + usuario + "</h2>");
		out.println("<h2> Has conectado el " + fecha + "</h2>");
		out.println("<p>Bla, bla, bla </p>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
