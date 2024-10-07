package com.curso.java;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ServletFormulario04
 */
public class ServletFormulario04 extends HttpServlet {
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
		out.println("<p>otra forma</p>");
		
		if (request.getParameter("curso") != null) {
			out.println("Has seleccionado" + request.getParameter("curso"));
		};
		
		request.getParameter("curso");
		
		String cursoSeleccionado = request.getParameter("curso");
		switch(cursoSeleccionado) {
			case"yoga" : 
			//
			case"pilates" :
			//
			case "manualidades" :
				//
				default :
					//por seguridad
					
		}
		
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}

}
