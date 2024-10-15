<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.almacen.modelo.Producto" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Detalle del Producto</title>
</head>
<body>
    <h2>Detalle del Producto</h2>
    
    <%
        Producto producto = (Producto) request.getAttribute("producto");
        if (producto != null) {
    %>
        <table border="1">
            <tr>
                <th>Nombre</th>
                <td><%= producto.getNombre() %></td>
            </tr>
            <tr>
                <th>Categoría</th>
                <td><%= producto.getCategoria() %></td>
            </tr>
            <tr>
                <th>Precio</th>
                <td><%= producto.getPrecio() %></td>
            </tr>
            <tr>
                <th>Stock</th>
                <td><%= producto.getStock() %></td>
            </tr>
        </table>
    <%
        } else {
    %>
        <p>No se encontró ningún producto con el nombre proporcionado.</p>
    <%
        }
    %>

    <a href="menu.jsp">Volver al Menú</a>
</body>
</html>
