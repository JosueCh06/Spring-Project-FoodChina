package com.proyecto.restaurante.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.restaurante.entity.CategoriaProveedor;

public interface CategoriaProveedorDAO extends JpaRepository<CategoriaProveedor, Integer>{
	
}
