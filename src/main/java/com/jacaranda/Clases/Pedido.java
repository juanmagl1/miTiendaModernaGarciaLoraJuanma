package com.jacaranda.Clases;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="pedido")
@IdClass(IdPedido.class)
public class Pedido {
	
	@Id
	private int cantidad;
	@Id
	private double precio;
	@Id
	private LocalDateTime fecha;
	@Id
	@ManyToOne
	@JoinColumn(name="user")
	private Usuario user;
	@Id
	@ManyToOne
	@JoinColumn(name="elemento")
	private Elemento elemento;
	
	public Pedido() {
		super();
	}
	
	public Pedido(int cantidad, double precio, LocalDateTime fecha, Usuario user, Elemento elemento) {
		this.user = user;
		this.elemento = elemento;
	}

	//GETTERS & SETTERS

	
	
	//HASHCODE & EQUALS


}
