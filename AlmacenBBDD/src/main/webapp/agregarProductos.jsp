<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Producto</title>
</head>
<body>
	<h1>Agregar Producto</h1>
	<form action="productos" method="post">
		<input type="hidden" name="action" value="alta"> <label
			for="nombre">Nombre:</label> <input type="text" name="nombre"><br>

		<label for="categoria">Categoria:</label> <input type="text"
			name="categoria"><br> <label for="precio">Precio:</label>
		<input type="text" name="precio"><br> <label for="stock">Stock</label>
		<input type="text" name="stock"><br> <input type="submit"
			value="Agregar">
	</form>
	<a href="menu.jsp">Volver al menú</a>
</body>
</html>
