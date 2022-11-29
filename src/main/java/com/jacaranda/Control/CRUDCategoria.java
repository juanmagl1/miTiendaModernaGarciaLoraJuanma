package com.jacaranda.Control;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.jacaranda.Clases.Categoria;

public class CRUDCategoria {
	
	private static Session session = CRUDSession.getSession();
	
	public static void saveCategoria(String nombre, String descripcion) {
		Categoria categoria = new Categoria(nombre,descripcion);
		session.getTransaction().begin();
		session.save(categoria);
		session.getTransaction().commit();
	}
	
	public static Categoria getCategoria(int id) {
		Categoria res = session.get(Categoria.class, id);
		return res;
	}
	
	public static Categoria getCategoria(String nombre) {
		List<Categoria> listaCategorias = getAllCategoria();
		Categoria res = new Categoria();
		for (Categoria categoria:listaCategorias) {
			if(categoria.getNombre().equals(nombre)) {
				res = categoria;
			}
		}
		return res;
	}
	
	public static List<Categoria> getAllCategoria(){
		List<Categoria> listaCategorias = new ArrayList<>();
		Categoria categoria;
		int id = 1;
		do {
			categoria = session.get(Categoria.class, id);
			if(categoria != null) {
				listaCategorias.add(categoria);
			}
			id++;
		}while(categoria != null);
		return listaCategorias;
	}
	
	public static void deleteCategoria(int id) {
		Categoria categoria = session.get(Categoria.class, id);
		session.getTransaction().begin();
		session.delete(categoria);
		session.getTransaction().commit();
	}

}
