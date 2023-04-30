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

import com.teto.dto.Proveedores;
import com.teto.service.ProveedoresServiceImpl;

@RestController
@RequestMapping("/api")
public class ProveedoresController {
	
	@Autowired
	ProveedoresServiceImpl proveedoresServiceImpl;
	
	@GetMapping("/proveedores")
	public List<Proveedores> listarProveedores(){
		return proveedoresServiceImpl.listarProveedores();
	}
	
	
	@PostMapping("/proveedores")
	public Proveedores salvarProveedores(@RequestBody Proveedores proveedor) {
		
		return proveedoresServiceImpl.guardarProveedor(proveedor);
	}
	
	
	@GetMapping("/proveedores/{id}")
	public Proveedores proveedorXID(@PathVariable(name="id") String id) {
		
		Proveedores proveedor_xid= new Proveedores();
		
		proveedor_xid=proveedoresServiceImpl.proveedorXID(id);
		
		return proveedor_xid;
	}
	
	@PutMapping("/proveedores/{id}")
	public Proveedores actualizarProveedor(@PathVariable(name="id")String id,@RequestBody Proveedores pieza) {
		
		Proveedores proveedor_seleccionado= new Proveedores();
		Proveedores proveedor_actualizado= new Proveedores();
		
		proveedor_seleccionado= proveedoresServiceImpl.proveedorXID(id);
		
		proveedor_seleccionado.setNombre(pieza.getNombre());
		
		proveedor_actualizado = proveedoresServiceImpl.actualizarProveedor(proveedor_seleccionado);
		
		return proveedor_actualizado;
	}
	
	@DeleteMapping("/proveedores/{id}")
	public void eliminarProveedor(@PathVariable(name="id")String id) {
		proveedoresServiceImpl.eliminarProveedor(id);
	}
	
	
}
