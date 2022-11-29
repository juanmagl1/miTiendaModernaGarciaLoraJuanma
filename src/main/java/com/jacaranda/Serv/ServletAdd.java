package com.jacaranda.Serv;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jacaranda.Clases.Carrito;
import com.jacaranda.Clases.Elemento;
import com.jacaranda.Clases.Pedido;
import com.jacaranda.Clases.Usuario;
import com.jacaranda.Control.CRUDPedido;
import com.jacaranda.Control.CRUDUsuario;

/**
 * Servlet implementation class ServletAdd
 */
@WebServlet("/ServletAdd")
public class ServletAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdd() {
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
		
		HttpSession session = request.getSession();
		Usuario user = CRUDUsuario.getUser((String) session.getAttribute("usuario"));
		Elemento elemento = (Elemento) session.getAttribute("elemento");
		int cantidad = Integer.valueOf(request.getParameter("cantidad"));
		double precio = (double) session.getAttribute("precio")*cantidad;
		
		Pedido pedido = new Pedido(cantidad, precio, LocalDateTime.now(),user,elemento);
		
		CRUDPedido.savePedido(user, elemento, cantidad, precio, LocalDateTime.now());
		
		Carrito carrito = (Carrito) session.getAttribute("carrito");
		carrito.addPedido(pedido);
		
		response.sendRedirect("ServletLog");
		
	}

}
