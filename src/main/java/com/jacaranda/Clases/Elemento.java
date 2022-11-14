package com.jacaranda.Clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="elemento")
public class Elemento {
	
	@Id
	private int id;
	private String nombre;
	private String descripcion;
	private double precio;
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Categoria categoria;
	@OneToMany(mappedBy="id",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Compra> listaCompra;
	
	public Elemento() {
		super();
	}
	
	public Elemento(String nombre, String descripcion, double precio, Categoria categoria) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.categoria = categoria;
		this.listaCompra = new ArrayList<Compra>();
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	//HASHCODE & EQUALSs

	@Override
	public int hashCode() {
		return Objects.hash(descripcion, id, categoria, nombre, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Elemento other = (Elemento) obj;
		return Objects.equals(descripcion, other.descripcion) && id == other.id && categoria == other.categoria
				&& Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio);
	}
}
