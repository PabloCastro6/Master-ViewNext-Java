<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.almacen.modelo.Categoria" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar Producto</title>
</head>
<body>
    <h1>Agregar Producto</h1>
    <form action="productos" method="post">
        <input type="hidden" name="action" value="alta">
        Nombre: <input type="text" name="nombre"><br>
        Categoría:
        <select id="categoria" name="categoria" required>
            <%
                for (Categoria categoria : Categoria.values()) {
            %>
                <option value="<%= categoria.name() %>"><%= categoria.name() %></option>
            <%
                }
            %>
        </select><br>
        Precio: <input type="text" name="precio"><br>
        Stock: <input type="text" name="stock"><br>
        <input type="submit" value="Agregar">
    </form>
    <a href="menu.jsp">Volver al menú</a>
</body>
</html>
