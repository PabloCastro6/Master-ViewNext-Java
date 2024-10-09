package com.curso.java;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String pwd = request.getParameter("pwd");
		
		
		if(usuario.equals("admin") && pwd.equals("admin")) {
			LocalDate date = LocalDate.now();
			request.setAttribute("fecha",date);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Entrada");
			dispatcher.forward(request, response);
			
		}else {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			
			out.println("<h2>Los datos no son correctos");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.html");
			dispatcher.include(request, response);
			
		}
		
	}

}
