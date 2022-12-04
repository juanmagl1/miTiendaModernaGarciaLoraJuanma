//package com.jacaranda.Clases;
//
//import java.time.LocalDateTime;
//import java.util.Objects;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.IdClass;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//
//@Entity(name="compra")
//@IdClass(IdPedido.class)
//public class Pedido {
//	
//
//	private int cantidad;
//	private double precio;
//	@Id
//	private LocalDateTime fecha;
//	@Id
//	@ManyToOne
//	@JoinColumn(name="id_user")
//	private Usuario user;
//	@Id
//	@ManyToOne
//	@JoinColumn(name="id_elemento")
//	private Elemento elemento;
//	
//	public Pedido() {
//		super();
//	}
//	
//	public Pedido(int cantidad, double precio, LocalDateTime fecha, Usuario user, Elemento elemento) {
//		this.user = user;
//		this.elemento = elemento;
//	}
//
//	public int getCantidad() {
//		return cantidad;
//	}
//
//	public void setCantidad(int cantidad) {
//		this.cantidad = cantidad;
//	}
//
//	public double getPrecio() {
//		return precio;
//	}
//
//	public void setPrecio(double precio) {
//		this.precio = precio;
//	}
//
//	public LocalDateTime getFecha() {
//		return fecha;
//	}
//
//	public void setFecha(LocalDateTime fecha) {
//		this.fecha = fecha;
//	}
//
//	public Usuario getUser() {
//		return user;
//	}
//
//	public void setUser(Usuario user) {
//		this.user = user;
//	}
//
//	public Elemento getElemento() {
//		return elemento;
//	}
//
//	public void setElemento(Elemento elemento) {
//		this.elemento = elemento;
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(cantidad, elemento, fecha, precio, user);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Pedido other = (Pedido) obj;
//		return cantidad == other.cantidad && Objects.equals(elemento, other.elemento)
//				&& Objects.equals(fecha, other.fecha)
//				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio)
//				&& Objects.equals(user, other.user);
//	}
//
//	
//	
//	//HASHCODE & EQUALS
//
//
//}
