<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.almacen.modelo.Producto"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eliminar Producto</title>
</head>
<body>
	<h1>Eliminar Producto</h1>

	<form action="productos" method="post">
		<input type="hidden" name="action" value="eliminar"> <label
			for="id">Selecciona el ID del producto a eliminar:</label> <select
			id="id" name="id" required>
			<%
                // Suponiendo que la lista de productos ya esté disponible como atributo "productos" desde el Servlet
                List<Producto> productos = (List<Producto>) request.getAttribute("productos");
                for (Producto producto : productos) {
            %>
			<option value="<%= producto.getId() %>">
				<%= producto.getId() %> -
				<%= producto.getNombre() %>
			</option>
			<%
                }
            %>
		</select> <br> <br> <input type="submit" value="Eliminar">
	</form>

	<br>
	<a href="menu.jsp">Volver al menú</a>
</body>
</html>
