package com.jacaranda.Control;

import java.time.LocalDate;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;

import com.jacaranda.Clases.Usuario;

public class CRUDUsuario {
	
	private static Session session = CRUDSession.getSession();
	
	public static String getMd5(String input) {
		String pass = null;
		if(input!=null) {
			pass = DigestUtils.md5Hex(input);
		}
		return pass;
	}
	
	public static void saveUser(String nombre,String apellidos, String password, String genero, LocalDate fecha) {
		Usuario usuario = new Usuario(nombre,apellidos,password,genero,fecha);
		session.getTransaction().begin();
		session.save(usuario);
		session.getTransaction().commit();
	}
	
	public static Usuario getUser(String nombre) {
		Usuario res =(Usuario) session.get(Usuario.class, nombre);
		return res;
	}
	
	public static void deleteUser(int id) {
		Usuario usuario = (Usuario) session.get(Usuario.class, id);
		session.getTransaction().begin();
		session.delete(usuario);
		session.getTransaction();
	}

}
