package com.curso.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.curso.modelo.Perfil;
import com.curso.service.ValidacionService;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ValidacionService service;
       
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");
		String pwd = request.getParameter("pwd");
		
		
		service = new ValidacionService();
		Perfil validado = service.autenticar(usuario, pwd);
		if(validado != null) {
			
			request.setAttribute("perfil", validado);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Entrada");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Error");
			dispatcher.forward(request, response);
			
		}
	}

}
