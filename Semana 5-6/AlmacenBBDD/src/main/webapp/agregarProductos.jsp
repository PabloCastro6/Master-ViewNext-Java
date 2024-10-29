<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Producto</title>
</head>
<body>
	<h1>Agregar Producto</h1>

	<!-- Formulario para agregar un nuevo producto -->
	<form action="productos" method="post">
		<!-- Se envía la acción 'alta' al servlet para indicar que estamos agregando un producto -->
		<input type="hidden" name="action" value="alta">

		<!-- Campo para ingresar el nombre del producto -->
		Nombre: <input type="text" name="nombre" required><br> <br>

		<!-- Campo de selección para la categoría del producto -->
		Categoría: <select name="categoria" required>
			<option value="ELECTRONICA">Electrónica</option>
			<option value="ACCESORIOS">Accesorios</option>
			<option value="HOGAR">Hogar</option>
			<option value="OTROS">Otros</option>
		</select><br> <br>

		<!-- Campo para ingresar el precio del producto -->
		Precio: <input type="text" name="precio" required><br> <br>

		<!-- Campo para ingresar el stock del producto -->
		Stock: <input type="text" name="stock" required><br> <br>

		<!-- Botón para enviar el formulario -->
		<input type="submit" value="Agregar Producto">
	</form>

	<br>
	<!-- Enlace para volver al menú principal -->
	<a href="menu.jsp">Volver al Menú</a>
</body>
</html>
