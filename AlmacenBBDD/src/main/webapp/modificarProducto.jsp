<form action="productos" method="post">
	<input type="hidden" name="action" value="modificar">
	<!-- Acci�n que se env�a al Servlet -->
	ID del Producto: <input type="text" name="id" required><br>
	<!-- Campo para el ID del producto -->
	Nombre: <input type="text" name="nombre" required><br>
	Categor�a: <select name="categoria" required>
		<option value="ELECTRONICA">Electr�nica</option>
		<option value="ACCESORIOS">Accesorios</option>
		<option value="HOGAR">Hogar</option>
		<option value="OTROS">Otros</option>
	</select><br> Precio: <input type="text" name="precio" required><br>
	Stock: <input type="text" name="stock" required><br> <input
		type="submit" value="Modificar Producto">
</form>
