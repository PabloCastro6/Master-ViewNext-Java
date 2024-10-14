package com.almacen.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.almacen.dao.ProductoDAO;
import com.almacen.modelo.Producto;
import com.almacen.modelo.Categoria;

public class ProductoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductoDAO productoDAO = new ProductoDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("alta".equals(action)) {
            agregarProducto(request);
            listarProductos(request, response);

        } else if ("eliminar".equals(action)) {
            productoDAO.eliminarProducto(request.getParameter("nombre"));
            listarProductos(request, response);

        } else if ("modificar".equals(action)) {
            agregarProducto(request);
            listarProductos(request, response);

        } else if ("buscar".equals(action)) {
            Producto producto = productoDAO.buscarProducto(request.getParameter("nombre"));
            request.setAttribute("producto", producto);
            request.getRequestDispatcher("detalleProducto.jsp").forward(request, response);

        } else if ("listar".equals(action)) {
            listarProductos(request, response);
        }
    }

    private void agregarProducto(HttpServletRequest request) {
        String nombre = request.getParameter("nombre");
        Categoria categoria = Categoria.valueOf(request.getParameter("categoria").toUpperCase());
        double precio = Double.parseDouble(request.getParameter("precio"));
        int stock = Integer.parseInt(request.getParameter("stock"));

        Producto producto = new Producto(nombre, categoria, precio, stock);
        productoDAO.agregarProducto(producto);
    }

    private void listarProductos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Producto> productos = productoDAO.listarProductos();
        request.setAttribute("productos", productos);
        request.getRequestDispatcher("productos.jsp").forward(request, response);
    }
}