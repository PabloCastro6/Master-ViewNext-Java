<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.curso.modelo.PaginaWeb" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Resultados de Búsqueda</title>
</head>
<body>
    <h1>Resultados de la Búsqueda</h1>

    <%
        List<PaginaWeb> paginas = (List<com.curso.modelo.PaginaWeb>) request.getAttribute("paginas");
        if (paginas != null && !paginas.isEmpty()) {
            for (com.curso.modelo.PaginaWeb pagina : paginas) {
    %>
                <div>
                    <p>Dirección: <a href="<%= pagina.getDireccion() %>"><%= pagina.getDireccion() %></a></p>
                    <p>Descripción:<%= pagina.getDescripcion() %></p>
                </div>
                <hr>
    <%
            }
        } else {
    %>
        <p>No se encontraron resultados para la búsqueda.</p>
    <%
        }
    %>

    <a href="busqueda.jsp">Volver al buscador</a>
</body>
</html>
