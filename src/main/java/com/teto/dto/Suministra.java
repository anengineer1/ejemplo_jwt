package com.teto.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "suministra") // en caso que la tabala sea diferente
public class Suministra {

	// Atributos de entidad registro_curso
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // busca ultimo valor e incrementa desde id final de db
	private int id;
	
	@Column(name = "precio")
	private int precio;

	@ManyToOne
	@JoinColumn(name = "codigopieza")
	private Piezas pieza;

	@ManyToOne
	@JoinColumn(name = "idproveedor")
	private Proveedores proveedor;

	// Constructores
	public Suministra() {

	}

	public Suministra(int id, int precio, Piezas pieza, Proveedores proveedor) {
		this.id = id;
		this.precio = precio;
		this.pieza = pieza;
		this.proveedor = proveedor;
	}

	// Getters and setters
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the pieza
	 */
	public Piezas getPieza() {
		return pieza;
	}

	/**
	 * @return the proveedor
	 */
	public Proveedores getProveedor() {
		return proveedor;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param pieza the pieza to set
	 */
	public void setPieza(Piezas pieza) {
		this.pieza = pieza;
	}

	/**
	 * @param proveedor the proveedor to set
	 */
	public void setProveedor(Proveedores proveedor) {
		this.proveedor = proveedor;
	}

	/**
	 * @return the precio
	 */
	public int getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Suministra [id=" + id + ", precio=" + precio + ", pieza=" + pieza + ", proveedor=" + proveedor + "]";
	}

}
