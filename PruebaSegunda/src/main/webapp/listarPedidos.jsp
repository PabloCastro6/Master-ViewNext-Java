<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.almacen.modelo.Pedido"%>
<%@ page import="com.almacen.modelo.Producto"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Listado de Pedidos</title>
</head>
<body>
	<h2>Pedidos Realizados</h2>
	<table border="1">
		<tr>
			<th>Producto</th>
			<th>Categoría</th>
			<th>Precio</th>
			<th>Cantidad</th>
			<th>Estado</th>
		</tr>
		<%
		List<Pedido> pedidos = (List<Pedido>) request.getAttribute("pedidos");
		if (pedidos != null && !pedidos.isEmpty()) {
			for (Pedido pedido : pedidos) {
				Producto producto = pedido.getProducto();
		%>
		<tr>
			<td><%=producto.getNombre()%></td>
			<td><%=producto.getCategoria()%></td>
			<td><%=producto.getPrecio()%></td>
			<td><%=pedido.getCantidad()%></td>
			<td><%=pedido.getEstado()%></td>
		</tr>
		<%
		}
		} else {
		%>
		<tr>
			<td colspan="5">No hay pedidos realizados.</td>
		</tr>
		<%
		}
		%>
	</table>

	<a href="menu.jsp">Volver al Menú</a>
</body>
</html>
