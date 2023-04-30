package com.teto.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedores") // en caso que la tabala sea diferente
public class Proveedores {

	// Atributos de entidad estudiante
	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "nombre")
	private String nombre;

	@OneToMany(mappedBy = "proveedor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Suministra> suministra;

	// Constructores

	public Proveedores() {

	}

	public Proveedores(String id, String nombre, String apellido, String telefono, List<Suministra> suministra) {
		this.id = id;
		this.nombre = nombre;
		this.suministra = suministra;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the suministra
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "proveedor")
	public List<Suministra> getSuministra() {
		return suministra;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param suministra the suministra to set
	 */
	public void setSuministra(List<Suministra> suministra) {
		this.suministra = suministra;
	}

	@Override
	public String toString() {
		return "Proveedores [id=" + id + ", nombre=" + nombre + ", suministra=" + suministra + "]";
	}

}
