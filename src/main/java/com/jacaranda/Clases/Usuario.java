package com.jacaranda.Clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="usuario")
public class Usuario {
	
	@Id
	@Column(name="nombre")
	private String nombre;
	private String apellidos;
	private String password;
	private LocalDate fecha;
	private String genero;
//	@OneToMany(mappedBy="nombre",cascade = CascadeType.ALL,orphanRemoval = true)
//	private List<Pedido> listaCompra;
	
	
	public Usuario() {
		super();
	}
	
	public Usuario(String nombre, String apellidos, String password, String genero, LocalDate fecha) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.password = password;
		this.fecha = fecha;
		this.genero = genero;
//		this.listaCompra = new ArrayList<Pedido>();
	}
	
	//GETTERS & SETTERS

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

//	public List<Pedido> getListaCompra() {
//		return listaCompra;
//	}
//
//	public void setListaCompra(List<Pedido> listaCompra) {
//		this.listaCompra = listaCompra;
//	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, fecha, genero, nombre, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(genero, other.genero) 
				&& Objects.equals(nombre, other.nombre) && Objects.equals(password, other.password);
	}

}
