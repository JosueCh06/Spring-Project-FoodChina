package com.proyecto.restaurante.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.restaurante.entity.Enlace;
import com.proyecto.restaurante.entity.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Integer>{
	
	@Query("select u from Usuario u where u.login=?1")
	public Usuario iniciarSesion(String login);
	
	@Query("select e from RolEnlace re join re.enlace e where re.rol.idRol=?1")
	public List<Enlace> traearEnlaces(int idRol);
}
