package com.curso.java;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ServletFormulario01
 */
public class ServletFormulario03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Elegir cursos </title>");
		out.println("</head>");
		out.println("<body>");
		
		//Recuperacion de datos 
		if (request.getParameter("yoga") != null) {
			out.println("Has marcado el cuso de yoga");
		};
		if (request.getParameter("pilates") != null) {
			out.println("Has marcado el cuso de pilates");
		};
		if (request.getParameter("manualidades") != null) {
			out.println("Has marcado el cuso de manualidades");
		};
		out.println("<p>otra forma</p>");
		
		if (request.getParameter("yoga") != null) {
			out.println("Has pulsado" + request.getParameter("yoga"));
		};
		if (request.getParameter("pilates") != null) {
			out.println("Has pulsado" + request.getParameter("pilates"));
		};
		if (request.getParameter("manualidades") != null) {
			out.println("Has pulsado" + request.getParameter("manualidades"));
		};
		

		out.println("</body>");
		out.println("</html>");


		out.close();
		
		
		
	}
	

}
