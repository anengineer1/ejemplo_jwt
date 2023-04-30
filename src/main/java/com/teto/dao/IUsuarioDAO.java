package com.teto.dao;

import com.teto.dto.Usuarios;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioDAO extends JpaRepository<Usuarios, Long> {

	Usuarios findByUsername(String username);
}