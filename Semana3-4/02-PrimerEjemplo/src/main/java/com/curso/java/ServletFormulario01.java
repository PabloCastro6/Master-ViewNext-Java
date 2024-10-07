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
public class ServletFormulario01 extends HttpServlet {
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
		out.println("<title>Servler ECO DATOS</title>");
		out.println("</head>");
		out.println("<body>");
		
		//Coger parametros del formulario
		String nombre = request.getParameter("nombre");
        String edad = request.getParameter("edad");
        String numero = request.getParameter("numero");
		
		//Convertir el numeroUsuario a entero
		int numeroU = Integer.parseInt(numero);
		//Otra forma: int tope= Integer.parseInt(request.getParameter("numero"));
		
		//imprimir tantas veces
		for(int i = 0; i < numeroU; i++) {
			out.println("<p>" + nombre + " tiene " + edad + " años.</p>");
		}
		
		
		
		out.println("</body>");
		out.println("</html>");


		out.close();
		
		
		
		
	}
	

}
