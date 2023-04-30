package com.teto.service;

import java.util.List;

import com.teto.dto.Piezas;


public interface IPiezasService {

	//Metodos del CRUD
	public List<Piezas> listarPiezas(); //Listar All 
	
	public Piezas guardarPieza(Piezas pieza);	//CREATE
	
	public Piezas piezaXID(int id); // READ
	
	public Piezas actualizarPieza(Piezas pieza); // UPDATE
	
	public void eliminarPieza(int id);// DELETE


}
