package com.teto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teto.dto.Piezas;
import com.teto.service.PiezasServiceImpl;

@RestController
@RequestMapping("/api")
public class PiezasController {
	
	@Autowired
	PiezasServiceImpl piezasServiceImpl;
	
	@GetMapping("/piezas")
	public List<Piezas> listarPiezas(){
		return piezasServiceImpl.listarPiezas();
	}
	
	
	@PostMapping("/piezas")
	public Piezas salvarPieza(@RequestBody Piezas pieza) {
		
		return piezasServiceImpl.guardarPieza(pieza);
	}
	
	
	@GetMapping("/piezas/{id}")
	public Piezas piezaXID(@PathVariable(name="id") int id) {
		
		Piezas pieza_xid= new Piezas();
		
		pieza_xid=piezasServiceImpl.piezaXID(id);
		
		System.out.println("Curso XID: "+pieza_xid);
		
		return pieza_xid;
	}
	
	@PutMapping("/piezas/{id}")
	public Piezas actualizarPieza(@PathVariable(name="id")int id,@RequestBody Piezas pieza) {
		
		Piezas pieza_seleccionada= new Piezas();
		Piezas pieza_actualizada= new Piezas();
		
		pieza_seleccionada= piezasServiceImpl.piezaXID(id);
		
		pieza_seleccionada.setNombre(pieza.getNombre());
		
		pieza_actualizada = piezasServiceImpl.actualizarPieza(pieza_seleccionada);
		
		System.out.println("El Curso actualizado es: "+ pieza_actualizada);
		
		return pieza_actualizada;
	}
	
	@DeleteMapping("/piezas/{id}")
	public void eliminarPieza(@PathVariable(name="id")int id) {
		piezasServiceImpl.eliminarPieza(id);
	}
	
	
}
