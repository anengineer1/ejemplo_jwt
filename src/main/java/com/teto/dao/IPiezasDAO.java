package com.teto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teto.dto.Piezas;




/**
 * @author Francisco
 *
 */
public interface IPiezasDAO extends JpaRepository<Piezas, Integer>{
	
}