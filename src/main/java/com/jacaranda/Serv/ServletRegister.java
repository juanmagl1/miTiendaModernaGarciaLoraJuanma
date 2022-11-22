package com.jacaranda.Serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jacaranda.Control.CRUDSession;

/**
 * Servlet implementation class ServletRegister
 */
@WebServlet("/ServletRegister")
public class ServletRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegister() {
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
		CRUDSession crs = new CRUDSession();
		
		String username = request.getParameter("username");
		String lastname = request.getParameter("last_name");
		String password = request.getParameter("password");
		String password_con = request.getParameter("password_con");
		
		LocalDate fechaNacimiento=null;
		
		try {
			 fechaNacimiento = LocalDate.parse(request.getParameter("fechaNacimiento"));
			
		}catch (Exception e) {
			response.sendRedirect("Error.html");
		}
		
		String gender = request.getParameter("gender");
		
		if(username != null && (password != null && password_con != null
				&& password.equals(password_con)) && fechaNacimiento != null
				&& gender != null){
			
			HttpSession session = request.getSession();
			session.setAttribute("login", "True");
			session.setAttribute("usuario", username);
			response.setContentType("text/html");
			
			String passwordEncode = crs.getMd5(password);
			
			crs.saveUser(username, lastname, passwordEncode, gender, fechaNacimiento);
			
			//HTML INTERMEDIO PARA CONFIRMAR AL USUARIO QUE SU USUARIO HA SIDO
			//CREADO CON EXITO, CON UN BOTON PARA MANDARLO DE VUELTA AL INDEX Y
			//QUE DESDE AHI INICIE SESION
			
			response.sendRedirect("confRegister.html");
			
			//A FALTA DE SABER REDIRIGIRLE A LA PAGINA LISTA MANTENIENDO EL USER
			
		}else {
			response.sendRedirect("Error.html");
		}
		
	}

}
