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
import com.jacaranda.Clases.Pedido;
import com.jacaranda.Clases.Elemento;
import com.jacaranda.Clases.Usuario;

public class CRUDSession {

	private StandardServiceRegistry sr;
	private SessionFactory sf;
	private static Session session;

	public CRUDSession() {
		sr = new StandardServiceRegistryBuilder().configure().build();
		sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		session = sf.openSession();
	}
	
	public static Session getSession() {
		return session;
	}
	
	//CONTROL DE USUARIOS
	
	//CONTROL DE CATEGORIAS
	
	//CONTROL DE ELEMENTOS
	
	//CONTROL DE PEDIDOS
	
}
