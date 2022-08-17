package com.proyecto.restaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.restaurante.dao.CategoriaProveedorDAO;
import com.proyecto.restaurante.entity.CategoriaProveedor;

@Service
public class CategoriaProveedorService{

	@Autowired
	private CategoriaProveedorDAO categoriaProveedorDAO;
	
	public List<CategoriaProveedor> list() {
		return categoriaProveedorDAO.findAll();
	}

}
