package com.teto.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="piezas")//en caso que la tabala sea diferente
public class Piezas {

	//Atributos de entidad curso
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	@Column(name = "codigo")
	private int codigo;
	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany(mappedBy = "pieza", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Suministra> suministra;
	
	//Constructores
	
	public Piezas() {
	
	}

	/**
	 * @param id
	 * @param nombre
	 * @param suministra
	 */
	public Piezas(int id, String nombre, List<Suministra> suministra) {
		this.codigo = id;
		this.nombre = nombre;
		this.suministra = suministra;
	}

	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
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
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pieza")
	public List<Suministra> getSuministra() {
		return suministra;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
		return "Piezas [codigo=" + codigo + ", nombre=" + nombre + ", suministra=" + suministra + "]";
	}
	
}