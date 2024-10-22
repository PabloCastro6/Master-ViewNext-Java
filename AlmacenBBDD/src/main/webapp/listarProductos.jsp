<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de Productos</title>
</head>
<body>
	<h1>Listado de Productos</h1>

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
			<c:forEach var="producto" items="${productos}">
				<tr>
					<td>${producto.id}</td>
					<td>${producto.nombre}</td>
					<td>${producto.categoria}</td>
					<td>${producto.precio}</td>
					<td>${producto.stock}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<br>
	<a href="menu.jsp">Volver al menú</a>
</body>
</html>
