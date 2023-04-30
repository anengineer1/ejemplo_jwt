package com.teto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teto.dto.Proveedores;


/**
 * @author Francisco
 *
 */
public interface IProveedoresDAO extends JpaRepository<Proveedores, String>{
	
}