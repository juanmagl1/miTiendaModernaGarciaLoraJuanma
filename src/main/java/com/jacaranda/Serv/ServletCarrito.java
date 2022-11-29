package com.jacaranda.Serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jacaranda.Clases.Carrito;
import com.jacaranda.Clases.Pedido;

/**
 * Servlet implementation class ServletCarrito
 */
@WebServlet("/ServletCarrito")
public class ServletCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCarrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		Carrito carrito = (Carrito) session.getAttribute("carrito");
		
		out.append(
				"<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<meta charset=\"UTF-8\">"
				+ "<link href='style.css' rel='stylesheet' type='text/css'>"
				+ "<title>"
				+ "Lista de Elementos"
				+ "</title>"
				+ "</head>"
				+ "<body>"
				+ "<table border='2'>"
				+ "<tr>"
				+ "<th id='id'> Elemento </th>"
				+ "<th id='nombre'> Cantidad </th>"
				+ "<th id='descripcion'> Precio </th>"
				+ "<th id='precio'></th>"
				
				//Añadir if para que solo los administradores puedan
				//añadir un nuevo elemento. En el else, este th se quedara
				//vacio
				
				+ "<th id='newElemento'><form action='ServletLog' method='post'><button type='submit'>Volver</button></form></th>"
				);
		
		List<Pedido> listaPedidos = carrito.getListaPedidos();
		
		for (Pedido pedido : listaPedidos) {
			out.append(
					"<tr>"
					+ "<td>" + pedido.getElemento().getNombre() + "</td>"
					+ "<td>" + pedido.getCantidad() + "</td>"
					+ "<td>" + pedido.getPrecio() + "</td>"
				    + "<td></td>"
				    + "</tr>"
					);
		}
		
	}

}
