<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.almacen.modelo.Categoria" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Producto</title>
</head>
<body>
    <h2>Agregar Producto</h2>
    <form action="ProductoServlet" method="post">
        <input type="hidden" name="action" value="alta"/>

        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required/><br>

        <label for="categoria">Categoría:</label>
        <select id="categoria" name="categoria" required>
            <% 
                for (Categoria categoria : Categoria.values()) {
            %>
                <option value="<%= categoria.name() %>"><%= categoria.name() %></option>
            <% 
                }
            %>
        </select><br>

        <label for="precio">Precio:</label>
        <input type="number" step="0.01" id="precio" name="precio" required/><br>

        <label for="stock">Stock:</label>
        <input type="number" id="stock" name="stock" required/><br>

        <button type="submit">Agregar Producto</button>
    </form>

    <%-- Mostrar mensaje de confirmación si existe --%>
    <%
        String mensaje = (String) request.getAttribute("mensaje");
        if (mensaje != null) {
    %>
        <p style="color: green;"><%= mensaje %></p>
    <%
        }
    %>

    <a href="menu.jsp">Volver al Menú</a>
</body>
</html>