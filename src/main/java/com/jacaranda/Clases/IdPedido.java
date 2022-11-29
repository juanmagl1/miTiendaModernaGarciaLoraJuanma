package com.jacaranda.Clases;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class IdPedido implements Serializable{
	
	private int cantidad;
	private double precio;
	private LocalDateTime fecha;
	private String user;
	private Integer elemento;

	public IdPedido() {
		
	}
	
	public IdPedido(int cantidad, double precio, LocalDateTime fecha, Usuario user, Elemento elemento) {
		this.setCantidad(cantidad);
		this.setPrecio(precio);
		this.setFecha(fecha);
		this.user = user.getNombre();
		this.elemento = elemento.getId();
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getElemento() {
		return elemento;
	}

	public void setElemento(int elemento) {
		this.elemento = elemento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(elemento, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdPedido other = (IdPedido) obj;
		return elemento == other.elemento && Objects.equals(user, other.user);
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

}
