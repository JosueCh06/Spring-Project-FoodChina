package com.proyecto.restaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.restaurante.dao.PlatilloDAO;
import com.proyecto.restaurante.entity.Platillo;

@Service
public class PlatilloService{

	@Autowired
	private PlatilloDAO platilloDAO;
	
	public void registrar(Platillo bean) {
		platilloDAO.save(bean);
	}

	public void actualizar(Platillo bean) {
		platilloDAO.save(bean);
	}

	public void eliminar(int cod) {
		platilloDAO.deleteById(cod);
	}

	public Platillo buscar(int cod) {
		return platilloDAO.findById(cod).orElse(null);
	}

	public List<Platillo> listarTodos() {
		return platilloDAO.findAll();
	}

}
