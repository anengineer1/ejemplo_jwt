package com.teto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teto.dao.IProveedoresDAO;
import com.teto.dto.Proveedores;


@Service
public class ProveedoresServiceImpl implements IProveedoresService {

	@Autowired
	IProveedoresDAO iProveedoresDAO;

	@Override
	public List<Proveedores> listarProveedores() {
		return iProveedoresDAO.findAll();
	}

	@Override
	public Proveedores guardarProveedor(Proveedores proveedor) {
		return iProveedoresDAO.save(proveedor);
	}

	@Override
	public Proveedores proveedorXID(String id) {
		return iProveedoresDAO.findById(id).get();
	}

	@Override
	public Proveedores actualizarProveedor(Proveedores proveedor) {
		return iProveedoresDAO.save(proveedor);
	}

	@Override
	public void eliminarProveedor(String id) {
		iProveedoresDAO.deleteById(id);
	}

}
