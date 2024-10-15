<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
    <%@ page import="java.util.List" %>
  <%@ page import="com.almacen.modelo.Pedido" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Productos</title>
</head>
<body>
 <h2>Listado de Pedidos</h2>
    
    <table border="1">
        <tr>
            <th>Producto</th>
            <th>Cantidad</th>
            <th>Estado</th>
        </tr>
        <%
            // Obtener la lista de pedidos desde el request
            List<Pedido> pedidos = (List<Pedido>) request.getAttribute("pedidos");
            if (pedidos != null && !pedidos.isEmpty()) {
                for (Pedido pedido : pedidos) {
        %>
        <tr>
            <td><%= pedido.getProducto().getNombre() %></td>
            <td><%= pedido.getCantidad() %></td>
            <td><%= pedido.getEstado() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="3">No hay pedidos registrados.</td>
        </tr>
        <%
            }
        %>
    </table>
    
    <a href="menu.jsp">Volver al Menú</a>

</body>
</html>