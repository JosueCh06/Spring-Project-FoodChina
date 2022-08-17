package com.proyecto.restaurante.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.restaurante.entity.Ingrediente;

public interface IngredienteDAO extends JpaRepository<Ingrediente, Integer>{

	
}
