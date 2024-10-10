package com.curso.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.curso.modelo.PaginaWeb;
import com.curso.service.PaginaWebService;

public class BuscarPaginas extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Crear una instancia de PaginaWebService
        PaginaWebService servicio = new PaginaWebService();

        // Obtener la temática ingresada por el usuario
        String tematica = request.getParameter("tematica");

        // Buscar páginas relacionadas con la temática
        List<PaginaWeb> paginas = (List<PaginaWeb>) servicio.buscarPorTematica(tematica);

        if (paginas != null && !paginas.isEmpty()) {
            // Si se encuentran páginas, pasarlas como atributo a la solicitud
            request.setAttribute("paginas", paginas);

            // Redirigir al servlet MostrarResultados
            RequestDispatcher dispatcher = request.getRequestDispatcher("/MostrarResultados");
            dispatcher.forward(request, response);
        } else {
            // Si no se encuentran páginas, redirigir al ErrorServlet
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ErrorServlet");
            dispatcher.forward(request, response);
        }
    }
}
