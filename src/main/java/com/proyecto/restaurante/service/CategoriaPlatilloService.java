package com.proyecto.restaurante.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.restaurante.dao.CategoriaPlatilloDAO;
import com.proyecto.restaurante.entity.CategoriaPlatillo;


@Service
public class CategoriaPlatilloService{

	@Autowired
	private CategoriaPlatilloDAO categoriaPlatilloDAO;
	
	public List<CategoriaPlatillo> listarCategoriasPlatillo() {
		return categoriaPlatilloDAO.findAll();
	}

	
}
