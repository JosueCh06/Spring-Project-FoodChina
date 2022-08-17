package com.proyecto.restaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.restaurante.dao.UsuarioDAO;
import com.proyecto.restaurante.entity.Enlace;
import com.proyecto.restaurante.entity.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	public Usuario iniciarSesion(String login) {
		return usuarioDAO.iniciarSesion(login);
	}

	public List<Enlace> traearEnlaces(int idRol) {
		return usuarioDAO.traearEnlaces(idRol);
	}
}
