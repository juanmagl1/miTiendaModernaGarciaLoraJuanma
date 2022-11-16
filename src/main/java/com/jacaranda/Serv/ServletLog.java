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

import com.jacaranda.Clases.Elemento;
import com.jacaranda.Control.CRUDSession;

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
		
		String username = request.getParameter("username");
		String password = crs.getMd5(request.getParameter("password"));
		//String password = crs.getMd5(request.getParameter("password"));
		
		if(username != null && password != null) {
			if(crs.getUser(username) != null && crs.getUser(username).getNombre().equals(username) && crs.getUser(username).getPassword().equals(password)) {
				HttpSession session = request.getSession();
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
						);
				
				List<Elemento> listaElementos = crs.getAllElemento();
				
				for (Elemento elemento : listaElementos) {
					out.append(
							"<tr>"
							+ "<td>" + elemento.getId() + "</td>"
							+ "<td>" + elemento.getNombre() + "</td>"
							+ "<td>" + elemento.getDescripcion() + "</td>"
						    + "<td>" + elemento.getPrecio() + "</td>"
						    + "<td>" + elemento.getCategoria().getNombre() + "</td>"
						    + "</tr>"
							);
				}
			}else {
				response.sendRedirect("Error.html");
			}
		}
	}

}
