//package com.jacaranda.Control;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.hibernate.Session;
//
//import com.jacaranda.Clases.Elemento;
//import com.jacaranda.Clases.Pedido;
//import com.jacaranda.Clases.Usuario;
//
//public class CRUDPedido {
//	
//	private static Session session = CRUDSession.getSession();
//	
//	public static void savePedido(Usuario user, Elemento elemento, int cantidad, double precio, LocalDateTime fecha) {
//		Pedido pedido = new Pedido(cantidad,precio,fecha,user,elemento);
//		session.getTransaction().begin();
//		session.save(pedido);
//		session.getTransaction().commit();
//	}
//	
//	public static Pedido getPedido(int id) {
//		Pedido res = session.get(Pedido.class, id);
//		return res;
//	}
//	
//	public static List<Pedido> getAllPedido(){
//		List<Pedido> listaCompras = new ArrayList<>();
//		Pedido compra;
//		int id = 1;
//		do {
//			compra = session.get(Pedido.class, id);
//			if(compra != null) {
//				listaCompras.add(compra);
//			}
//			id++;
//		}while(compra != null);
//		return listaCompras;
//	}
//	
//	public static void deleteCompra(int id) {
//		Pedido compra = session.get(Pedido.class, id);
//		session.getTransaction().begin();
//		session.delete(compra);
//		session.getTransaction().commit();
//	}
//
//}
