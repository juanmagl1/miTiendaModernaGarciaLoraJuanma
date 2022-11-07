package com.jacaranda;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="categoria")
public class Categoria {
	
	@Id
	private int id;
	private String nombre;
	private String descripcion;
	@OneToMany(mappedBy="id",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Elemento> listaElemento;
	
	public Categoria() {
		super();
	}
	
	public Categoria(int id, String nombre, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.listaElemento = new ArrayList<Elemento>();
	}
	
	//GETTERS & SETTERS

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Elemento> getListaElemento() {
		return listaElemento;
	}

	public void setListaElemento(List<Elemento> listaElemento) {
		this.listaElemento = listaElemento;
	}
	
	//HASHCODE & EQUALS

	@Override
	public int hashCode() {
		return Objects.hash(descripcion, id, listaElemento, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(descripcion, other.descripcion) && id == other.id
				&& Objects.equals(listaElemento, other.listaElemento) && Objects.equals(nombre, other.nombre);
	}

}
