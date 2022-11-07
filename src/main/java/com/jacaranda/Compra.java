package com.jacaranda;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="compra")
public class Compra {
	
	@Id
	private int id_user;
	private int id_elemento;
	private int cantidad;
	private double precio;
	private LocalDateTime fecha;
	@ManyToOne
	@JoinColumn(name="user")
	private Usuario user;
	@ManyToOne
	@JoinColumn(name="elemento")
	private Elemento elemento;
	
	public Compra() {
		super();
	}
	
	public Compra(Usuario user, Elemento elemento, int cantidad, double precio, LocalDateTime fecha) {
		super();
		this.id_user = user.getId();
		this.id_elemento = elemento.getId();
		this.cantidad = cantidad;
		this.precio = precio;
		this.fecha = fecha;
	}
	
	//GETTERS & SETTERS

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public int getId_elemento() {
		return id_elemento;
	}

	public void setId_elemento(int id_elemento) {
		this.id_elemento = id_elemento;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	//HASHCODE & EQUALS

	@Override
	public int hashCode() {
		return Objects.hash(cantidad, fecha, id_elemento, id_user, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		return cantidad == other.cantidad && Objects.equals(fecha, other.fecha) && id_elemento == other.id_elemento
				&& id_user == other.id_user && Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio);
	}

}
