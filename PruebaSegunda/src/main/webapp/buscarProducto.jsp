<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ page import="java.util.List" %>
<%@ page import="com.almacen.modelo.Producto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buscar Producto</title>
</head>
<body>
    <h2>Buscar Producto</h2>
    <form action="ProductoServlet" method="post">
        <input type="hidden" name="action" value="buscar"/>
        
        <label for="producto">Seleccione un Producto:</label>
        <select id="producto" name="nombre" required>
            <%
                // Obtener la lista de productos desde el request
                List<Producto> productos = (List<Producto>) request.getAttribute("productos");
                if (productos != null && !productos.isEmpty()) {
                    for (Producto producto : productos) {
            %>
                        <option value="<%= producto.getNombre() %>"><%= producto.getNombre() %></option>
            <%
                    }
                } else {
            %>
                <option value="">No hay productos disponibles</option>
            <%
                }
            %>
        </select>
        
        <button type="submit">Buscar</button>
    </form>

    <%
        // Mostrar el resultado de la búsqueda si se ha encontrado un producto
        Producto producto = (Producto) request.getAttribute("producto");
        if (producto != null) {
    %>
        <h3>Resultado de la Búsqueda</h3>
        <table border="1">
            <tr>
                <th>Nombre</th>
                <th>Categoría</th>
                <th>Precio</th>
                <th>Stock</th>
            </tr>
            <tr>
                <td><%= producto.getNombre() %></td>
                <td><%= producto.getCategoria() %></td>
                <td><%= producto.getPrecio() %></td>
                <td><%= producto.getStock() %></td>
            </tr>
        </table>
    <%
        } else if (request.getAttribute("producto") != null) {
    %>
        <p>No se encontró ningún producto con ese nombre.</p>
    <%
        }
    %>

    <a href="menu.jsp">Volver al Menú</a>
</body>
</html>
