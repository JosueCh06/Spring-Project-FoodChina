package com.proyecto.restaurante.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.restaurante.entity.Platillo;


public interface PlatilloDAO extends JpaRepository<Platillo, Integer>{
	
}
