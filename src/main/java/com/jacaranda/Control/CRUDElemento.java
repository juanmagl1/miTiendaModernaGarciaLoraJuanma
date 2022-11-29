package com.jacaranda.Control;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.jacaranda.Clases.Categoria;
import com.jacaranda.Clases.Elemento;

public class CRUDElemento {
	
	private static Session session = CRUDSession.getSession();
	
	public static void saveElemento(String nombre, String descripcion, double precio, Categoria categoria) {
		Elemento elemento = new Elemento(nombre,descripcion,precio,categoria);
		session.getTransaction().begin();
		session.save(elemento);
		session.getTransaction().commit();
	}
	
	public static Elemento getElemento(int id) {
		Elemento res = session.get(Elemento.class, id);
		return res;
	}
	
	public static List<Elemento> getAllElemento(){
		List<Elemento> listaElementos = new ArrayList<>();
		Elemento elemento;
		int id = 1;
		do {
			elemento = session.get(Elemento.class, id);
			if(elemento != null) {
				listaElementos.add(elemento);
			}
			id++;
		}while(elemento != null);
		return listaElementos;
	}
	
	public static void deleteElemento(int id) {
		Elemento elemento = session.get(Elemento.class, id);
		session.getTransaction().begin();
		session.delete(elemento);
		session.getTransaction().commit();
	}
	

}
