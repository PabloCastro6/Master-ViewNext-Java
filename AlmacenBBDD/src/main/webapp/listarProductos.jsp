<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.almacen.modelo.Producto" %>
<%@ page import= "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Productos</title>
</head>
<body>
    <h1>Lista de Productos</h1>

    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Categoría</th>
                <th>Precio</th>
                <th>Stock</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Producto> productos = (List<Producto>) request.getAttribute("productos");
                if (productos == null) {
                    productos = new ArrayList<>(); // Inicializar como lista vacía
                }
                System.out.println("Número de productos en JSP: " + productos.size()); // Depuración
                if (!productos.isEmpty()) {
                    for (Producto producto : productos) {
            %>
            <tr>
                <td><%= producto.getId() %></td>
                <td><%= producto.getNombre() %></td>
                <td><%= producto.getCategoria() %></td>
                <td><%= producto.getPrecio() %></td>
                <td><%= producto.getStock() %></td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="5">No hay productos disponibles.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>

    <br>
    <a href="menu.jsp">Volver al Menú</a>
</body>
</html>
