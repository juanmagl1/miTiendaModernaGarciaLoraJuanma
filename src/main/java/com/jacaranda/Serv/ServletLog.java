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
import com.jacaranda.Clases.Elemento;
import com.jacaranda.Clases.Usuario;
import com.jacaranda.Control.CRUDElemento;
import com.jacaranda.Control.CRUDSession;
import com.jacaranda.Control.CRUDUsuario;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/ServletLog")
public class ServletLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLog() {
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
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		CRUDSession crs = new CRUDSession();
		
		String username;
		String password;
		
		HttpSession session = request.getSession();
		
		if(!session.getAttribute("login").equals("true")) {
			username = request.getParameter("username");
			password = CRUDUsuario.getMd5(request.getParameter("password"));
			Carrito carrito = new Carrito();
			session.setAttribute("carrito", carrito);
		}else {
			Usuario user = CRUDUsuario.getUser((String) session.getAttribute("usuario"));
			username = user.getNombre();
			password = user.getPassword();
		}
		//String password = crs.getMd5(request.getParameter("password"));
		
		if(username != null && password != null) {
			if(CRUDUsuario.getUser(username) != null && CRUDUsuario.getUser(username).getNombre().equals(username) && CRUDUsuario.getUser(username).getPassword().equals(password)) {
				session.setAttribute("login", "True");
				session.setAttribute("usuario", username);
				response.setContentType("text/html");
				
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
						+ "<th id='id'> Id </th>"
						+ "<th id='nombre'> Nombre </th>"
						+ "<th id='descripcion'> Descripcion </th>"
						+ "<th id='precio'> Precio </th>"
						+ "<th id='categoria'> Categoria </th>"
						
						//Añadir if para que solo los administradores puedan
						//añadir un nuevo elemento. En el else, este th se quedara
						//vacio
						
						+ "<th id='newElemento'><form action='ServletCarrito' method='post'><button type='submit'>Ver carrito</button></form></th>"
						);
				
				List<Elemento> listaElementos = CRUDElemento.getAllElemento();
				
				for (Elemento elemento : listaElementos) {
					session.setAttribute("elemento", elemento);
					session.setAttribute("precio", elemento.getPrecio());
					out.append(
							"<tr>"
							+ "<td>" + elemento.getId() + "</td>"
							+ "<td>" + elemento.getNombre() + "</td>"
							+ "<td>" + elemento.getDescripcion() + "</td>"
						    + "<td>" + elemento.getPrecio() + "</td>"
						    + "<td>" + elemento.getCategoria().getNombre() + "</td>"
						    + "<td><form action='ServletAdd' method='post'><button type='submit'>Add</button><input type='number' name='cantidad'></form></td>"
						    + "</tr>"
							);
				}
			}else {
				response.sendRedirect("Error.html");
			}
		}
	}

}
