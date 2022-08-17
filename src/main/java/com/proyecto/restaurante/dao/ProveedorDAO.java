package com.proyecto.restaurante.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.restaurante.entity.Proveedor;

public interface ProveedorDAO extends JpaRepository<Proveedor, Integer>{
	
	@Query("select p from Proveedor p where p.categoriaProveedor.idCategoriaP=?1")
	public List<Proveedor> listarPorCategoria(int codCategoria);
	
	@Query("select pr from Proveedor pr where pr.categoriaProveedor.idCategoriaP=?1")
	public List<Proveedor> listProveedorXCategoria(int catProducto);
}
