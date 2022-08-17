package com.proyecto.restaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.restaurante.dao.IngredienteDAO;
import com.proyecto.restaurante.entity.Ingrediente;

@Service
public class IngredienteService {

	@Autowired
	private IngredienteDAO ingredienteDAO;
	
	public void save(Ingrediente bean) {
		ingredienteDAO.save(bean);
	}

	public void update(Ingrediente bean) {
		ingredienteDAO.save(bean);
	}

	public void delete(int cod) {
		ingredienteDAO.deleteById(cod);
	}

	public Ingrediente buscar(int cod) {
		return ingredienteDAO.findById(cod).orElse(null);
	}

	public List<Ingrediente> list() {
		return ingredienteDAO.findAll();
	}

}
