//package com.jacaranda.Clases;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//public class Carrito {
//	
//	private List<Pedido> listaPedidos = new ArrayList<>();
//
//	public Carrito() {
//		// TODO Auto-generated constructor stub
//	}
//	
//	public void addPedido(Pedido pedido) {
//		this.listaPedidos.add(pedido);
//	}
//
//	public List<Pedido> getListaPedidos() {
//		return listaPedidos;
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(listaPedidos);
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
//		Carrito other = (Carrito) obj;
//		return Objects.equals(listaPedidos, other.listaPedidos);
//	}
//
//}
