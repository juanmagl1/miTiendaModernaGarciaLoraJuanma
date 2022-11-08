package com.jacaranda;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class CRUDSession {

	private StandardServiceRegistry sr;
	private SessionFactory sf;
	private Session session;

	public CRUDSession() {
		sr = new StandardServiceRegistryBuilder().configure().build();
		sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		session = sf.openSession();
	}
	
	//CONTROL DE USUARIOS
	
	public void saveUser(String nombre,String apellidos, String password, String genero, LocalDateTime fecha) {
		Usuario usuario = new Usuario(nombre,apellidos,password,genero,fecha);
		session.getTransaction().begin();
		session.save(usuario);
		session.getTransaction().commit();
	}
	
	public Usuario getUser(int id) {
		Usuario res = session.get(Usuario.class, id);
		return res;
	}
	
	public List<Usuario> getAllUser(){
		List<Usuario> listaUsuarios = new ArrayList<>();
		Usuario usuario;
		int id = 1;
		do {
			usuario = session.get(Usuario.class, id);
			if(usuario != null) {
				listaUsuarios.add(usuario);
			}
			id++;
		}while(usuario != null);
		return listaUsuarios;
	}
	
	public void deleteUser(int id) {
		Usuario usuario = (Usuario) session.get(Usuario.class, id);
		session.getTransaction().begin();
		session.delete(usuario);
		session.getTransaction();
	}
	
	//CONTROL DE CATEGORIAS
	
	//CONTROL DE ELEMENTOS
	
	//CONTROL DE COMPRAS
	
}
