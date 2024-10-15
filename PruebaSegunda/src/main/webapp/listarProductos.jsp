<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.almacen.modelo.Producto" %>
<%@ page import="com.almacen.dao.ProductoDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de Productos</title>
</head>
<body>
    <h2>Listado de Productos</h2>
    
    <table border="1">
        <tr>
            <th>Nombre</th>
            <th>Categoría</th>
            <th>Precio</th>
            <th>Stock</th>
        </tr>
        <%
            // Obtener la lista de productos desde el request
            ProductoDAO service = new ProductoDAO();
       
            List<Producto> productos = service.listarProductos();
            request.setAttribute("productos", productos);
            
            if (productos != null && !productos.isEmpty()) {
                for (Producto producto : productos) {
        %>
        <tr>
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
            <td colspan="4">No hay productos disponibles.</td>
        </tr>
        <%
            }
        %>
    </table>
    
    <a href="menu.jsp">Volver al Menú</a>
</body>
</html>
