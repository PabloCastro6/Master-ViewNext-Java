package com.curso.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import com.curso.modelo.PaginaWeb;

public class MostrarResultados extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Resultados de Búsqueda</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Resultados de la búsqueda</h1>");

        // Recuperar la lista de páginas desde el atributo de solicitud
        List<PaginaWeb> paginas = (List<PaginaWeb>) request.getAttribute("paginas");
        if (paginas != null && !paginas.isEmpty()) {
            for (PaginaWeb pagina : paginas) {
                out.println("<p><strong>Dirección:</strong> <a href='" + pagina.getDireccion() + "'>" + pagina.getDireccion() + "</a></p>");
                out.println("<p><strong>Descripción:</strong> " + pagina.getDescripcion() + "</p>");
                out.println("<hr>");
            }
        }

        out.println("<a href=\"busqueda.html\">Volver al buscador</a>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}
