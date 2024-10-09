package com.curso.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.curso.modelo.Perfil;

/**
 * Servlet implementation class Entrada
 */
public class Entrada extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		Perfil perfil = (Perfil) request.getAttribute("perfil");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Entrada</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Bienvenid@ " + usuario + "a mi página</h1>");
		out.println("<h2>Direccion email " + perfil.getCorreo()+ "</h2>");
		out.println("<h2>Edad " + perfil.getEdad() + "");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
