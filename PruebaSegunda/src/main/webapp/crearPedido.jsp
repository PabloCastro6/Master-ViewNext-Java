<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %> 
<%@ page import="com.almacen.modelo.Producto" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear Pedido</title>
</head>
<body>
	<h2>Crear Pedido</h2>

	<form action="PedidoServlet" method="post">
		<input type="hidden" name="action" value="crear" /> 
		<label	for="producto"> Seleccione un Producto:</label> 
		<select id="producto"name="nombre" required>
			<%
			// Obtener la lista de productos desde el request
			List<Producto> productos = (List<Producto>) request.getAttribute("productos");
			if (productos != null) {
				for (Producto producto : productos) {
			%>
			<option value="<%=producto.getNombre()%>"><%=producto.getNombre()%>
				(Stock:
				<%=producto.getStock()%>)
			</option>
			<%
			}
			}
			%>
		</select> <br>
		<br> <label for="cantidad">Cantidad:</label> 
		<input type="number" id="cantidad" name="cantidad" min="1" required /> <br>
		<br>
		<button type="submit"> Crear Pedido</button>
	</form>

	<%
	// Mostrar el resultado del pedido
	String mensaje = (String) request.getAttribute("mensaje");
	if (mensaje != null) {
	%>
	<p><%=mensaje%></p>
	<%
	}
	%>

	<a href="menu.jsp">Volver al Menú</a>

</body>
</html>