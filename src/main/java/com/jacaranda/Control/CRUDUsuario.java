package com.jacaranda.Control;
import java.time.LocalDate;

import org.hibernate.Session;


import com.jacaranda.Clases.Usuario;


public class CRUDUsuario {
	
	
	public CRUDUsuario() {
		super();
	
	}
	
	public static boolean validateUser(String login, String password) {
		Session session=CRUDSession.getSession();
		boolean valid = false;
		Usuario u = (Usuario) session.get(Usuario.class,login);
		if (u==null) {
			u=new Usuario();
		}else {
			valid=true;
			
		}
		return valid;
	}
	public static boolean addUser(Usuario u) {
		Session session=CRUDSession.getSession();
		boolean valid=false;
		try {
			session.getTransaction().begin();
			session.saveOrUpdate(u);
			session.getTransaction().commit();
			valid=true;
		}catch (Exception e) {
			e.getMessage();
		}
		return valid;

	}
	public static Usuario findUser(String user) {
		Session session=CRUDSession.getSession();
		Usuario aux=session.get(Usuario.class, user);
		return aux;
	}


}
