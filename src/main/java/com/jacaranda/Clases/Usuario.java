package com.jacaranda.Clases;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="usuario")
public class Usuario {
	
	@Id
	private String nombre;
	private String apellidos;
	private String password;
	private LocalDateTime fecha;
	private String genero;
	@OneToMany(mappedBy="id",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Compra> listaCompra;
	
	
	public Usuario() {
		super();
	}
	
	public Usuario(String nombre, String apellidos, String password, String genero, LocalDateTime fecha) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.password = password;
		this.fecha = fecha;
		this.genero = genero;
		this.listaCompra = new ArrayList<Compra>();
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

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public List<Compra> getListaCompra() {
		return listaCompra;
	}

	public void setListaCompra(List<Compra> listaCompra) {
		this.listaCompra = listaCompra;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, fecha, genero, listaCompra, nombre, password);
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
				&& Objects.equals(genero, other.genero) && Objects.equals(listaCompra, other.listaCompra)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(password, other.password);
	}

}
