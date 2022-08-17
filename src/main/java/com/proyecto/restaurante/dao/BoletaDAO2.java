package com.proyecto.restaurante.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.restaurante.entity.Boleta;

public interface BoletaDAO2 extends JpaRepository<Boleta, Integer>{
	
	@Query("select b from Boleta b where b.totalPagar>=?1")
	public List<Boleta> listBoletaXMonto(double monto);

}
