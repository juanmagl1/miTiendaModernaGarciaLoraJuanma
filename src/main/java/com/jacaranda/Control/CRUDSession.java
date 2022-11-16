package com.jacaranda.Control;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.jacaranda.Clases.Categoria;
import com.jacaranda.Clases.Compra;
import com.jacaranda.Clases.Elemento;
import com.jacaranda.Clases.Usuario;

public class CRUDSession {

	private StandardServiceRegistry sr;
	private SessionFactory sf;
	private Session session;

	public CRUDSession() {
		sr = new StandardServiceRegistryBuilder().configure().build();
		sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		session = sf.openSession();
	}
	
	public String getMd5(String input) {
		String pass = null;
		if(input!=null) {
			pass = DigestUtils.md5Hex(input);
		}
		return pass;
	}
	
	//CONTROL DE USUARIOS
	
	public void saveUser(String nombre,String apellidos, String password, String genero, LocalDate fecha) {
		Usuario usuario = new Usuario(nombre,apellidos,password,genero,fecha);
		session.getTransaction().begin();
		session.save(usuario);
		session.getTransaction().commit();
	}
	
	public Usuario getUser(String nombre) {
		Usuario res =(Usuario) session.get(Usuario.class, nombre);
		return res;
	}
	
	public void deleteUser(int id) {
		Usuario usuario = (Usuario) session.get(Usuario.class, id);
		session.getTransaction().begin();
		session.delete(usuario);
		session.getTransaction();
	}
	
	//CONTROL DE CATEGORIAS
	
	public void saveCategoria(String nombre, String descripcion) {
		Categoria categoria = new Categoria(nombre,descripcion);
		session.getTransaction().begin();
		session.save(categoria);
		session.getTransaction().commit();
	}
	
	public Categoria getCategoria(int id) {
		Categoria res = session.get(Categoria.class, id);
		return res;
	}
	
	public Categoria getCategoria(String nombre) {
		List<Categoria> listaCategorias = getAllCategoria();
		Categoria res = new Categoria();
		for (Categoria categoria:listaCategorias) {
			if(categoria.getNombre().equals(nombre)) {
				res = categoria;
			}
		}
		return res;
	}
	
	public List<Categoria> getAllCategoria(){
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
	
	public void deleteCategoria(int id) {
		Categoria categoria = session.get(Categoria.class, id);
		session.getTransaction().begin();
		session.delete(categoria);
		session.getTransaction().commit();
	}
	
	//CONTROL DE ELEMENTOS
	
	public void saveElemento(String nombre, String descripcion, double precio, Categoria categoria) {
		Elemento elemento = new Elemento(nombre,descripcion,precio,categoria);
		session.getTransaction().begin();
		session.save(elemento);
		session.getTransaction().commit();
	}
	
	public Elemento getElemento(int id) {
		Elemento res = session.get(Elemento.class, id);
		return res;
	}
	
	public List<Elemento> getAllElemento(){
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
	
	public void deleteElemento(int id) {
		Elemento elemento = session.get(Elemento.class, id);
		session.getTransaction().begin();
		session.delete(elemento);
		session.getTransaction().commit();
	}
	
	//CONTROL DE COMPRAS
	
	public void saveCompra(Usuario user, Elemento elemento, int cantidad, double precio, LocalDateTime fecha) {
		Compra compra = new Compra(user,elemento,cantidad,precio,fecha);
		session.getTransaction().begin();
		session.save(compra);
		session.getTransaction().commit();
	}
	
	public Compra getCompra(int id) {
		Compra res = session.get(Compra.class, id);
		return res;
	}
	
	public List<Compra> getAllCompra(){
		List<Compra> listaCompras = new ArrayList<>();
		Compra compra;
		int id = 1;
		do {
			compra = session.get(Compra.class, id);
			if(compra != null) {
				listaCompras.add(compra);
			}
			id++;
		}while(compra != null);
		return listaCompras;
	}
	
	public void deleteCompra(int id) {
		Compra compra = session.get(Compra.class, id);
		session.getTransaction().begin();
		session.delete(compra);
		session.getTransaction().commit();
	}
	
}
