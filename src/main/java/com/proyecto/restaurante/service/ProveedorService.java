package com.proyecto.restaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.restaurante.dao.ProveedorDAO;
import com.proyecto.restaurante.entity.Proveedor;

@Service
public class ProveedorService{

	@Autowired
	private ProveedorDAO proveedorDAO;
	
	public void save(Proveedor bean) {
		proveedorDAO.save(bean);
	}

	public void update(Proveedor bean) {
		proveedorDAO.save(bean);
	}

	public void delete(int cod) {
		proveedorDAO.deleteById(cod);
	}

	public List<Proveedor> list() {
		return proveedorDAO.findAll();
	}

	public Proveedor buscar(int cod) {
		return proveedorDAO.findById(cod).orElse(null);
	}

	public List<Proveedor> listarPorCategoria(int codCategoria) {
		return proveedorDAO.listarPorCategoria(codCategoria);
	}
	
	public List<Proveedor> listProveedorXCategoria(int catProducto) {
		return proveedorDAO.listProveedorXCategoria(catProducto);
	}

}
