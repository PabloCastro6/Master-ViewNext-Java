<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.almacen.modelo.Producto" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modificar Producto</title>
</head>
<body>
    <h1>Modificar Producto</h1>

    <!-- Formulario para buscar el producto por ID -->
    <form action="ProductoServlet" method="post">
        <input type="hidden" name="action" value="cargarProducto">
        ID del Producto: <input type="text" name="id" required>
        <button type="submit">Cargar Datos</button>
    </form>

    <%
        Producto producto = (Producto) request.getAttribute("producto");
        if (producto != null) {
    %>

    <!-- Formulario de modificación con los datos cargados del producto -->
    <form action="ProductoServlet" method="post">
        <input type="hidden" name="action" value="modificar">
        <input type="hidden" name="id" value="<%= producto.getId() %>">

        Nombre: <input type="text" name="nombre" value="<%= producto.getNombre() %>" required><br>
        
        Categoría: 
        <select name="categoria" required>
            <option value="ELECTRONICA" <%= "ELECTRONICA".equals(producto.getCategoria().name()) ? "selected" : "" %>>Electrónica</option>
            <option value="ROPA" <%= "ROPA".equals(producto.getCategoria().name()) ? "selected" : "" %>>Ropa</option>
            <option value="ALIMENTOS" <%= "ALIMENTOS".equals(producto.getCategoria().name()) ? "selected" : "" %>>Alimentos</option>
            <option value="JUGUETES" <%= "JUGUETES".equals(producto.getCategoria().name()) ? "selected" : "" %>>Juguetes</option>
            <option value="OTROS" <%= "OTROS".equals(producto.getCategoria().name()) ? "selected" : "" %>>Otros</option>
        </select><br>
        
        Precio: <input type="text" name="precio" value="<%= producto.getPrecio() %>" required><br>
        Stock: <input type="text" name="stock" value="<%= producto.getStock() %>" required><br>

        <input type="submit" value="Modificar Producto">
    </form>

    <%
        }
    %>

    <br>
    <a href="menu.jsp">Volver al Menú</a>
</body>
</html>
