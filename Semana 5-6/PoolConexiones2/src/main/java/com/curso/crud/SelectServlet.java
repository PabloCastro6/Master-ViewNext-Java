package com.curso.crud;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.curso.service.MiService;

/**
 * Servlet implementation class SelectServlet
 */
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MiService miService = new MiService();
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		miService.mostraDatos();
		//SIN QUE SIRVA DE EJEMPLO
	}

}
