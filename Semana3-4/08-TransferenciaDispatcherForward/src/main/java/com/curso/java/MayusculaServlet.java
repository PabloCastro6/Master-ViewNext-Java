package com.curso.java;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class MayusculaServlet
 */
public class MayusculaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Convertir la frase a Mayuscula y no genera contenido. Eso se lo deja otro Servlet: se llama: FinalServlet
		
		String frase = request.getParameter("frase");
		request.setAttribute("frase", frase.toUpperCase());
		
		RequestDispatcher despachador = request.getRequestDispatcher("FinalServlet");
		despachador.forward(request, response);
	
	}
}
