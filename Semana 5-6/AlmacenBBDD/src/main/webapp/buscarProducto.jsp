<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Buscar Producto</title>
</head>
<body>
    <h1>Buscar Producto por ID</h1>

    <form action="ProductoServlet" method="post">
        <input type="hidden" name="action" value="buscar">
        
        <label for="id">ID del Producto:</label>
        <input type="number" name="id" id="id" required>

        <button type="submit">Buscar</button>
    </form>

    <!-- Mostrar el producto encontrado, si existe -->
    <%
        com.almacen.modelo.Producto producto = (com.almacen.modelo.Producto) request.getAttribute("producto");
        if (producto != null) {
    %>
        <h2>Detalles del Producto</h2>
        <p><strong>ID:</strong> <%= producto.getId() %></p>
        <p><strong>Nombre:</strong> <%= producto.getNombre() %></p>
        <p><strong>Categoría:</strong> <%= producto.getCategoria() %></p>
        <p><strong>Precio:</strong> <%= producto.getPrecio() %></p>
        <p><strong>Stock:</strong> <%= producto.getStock() %></p>
    <%
        } else if (request.getParameter("id") != null) {
    %>
        <p>No se encontró un producto con el ID proporcionado.</p>
    <%
        }
    %>

    <br>
    <a href="menu.jsp">Volver al Menú</a>
</body>
</html>
