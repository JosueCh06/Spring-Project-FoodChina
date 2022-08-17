package com.proyecto.restaurante.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.proyecto.restaurante.entity.Enlace;
import com.proyecto.restaurante.entity.Usuario;
import com.proyecto.restaurante.service.UsuarioService;



@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@RequestMapping(value = "/login")
	public String inicio() {
		return "login2"; 
	}
	
	@RequestMapping(value = "/menu")
	public String menu(Authentication auth, Model model, HttpSession session) {
		String nomUsu = auth.getName();
		Usuario bean = usuarioService.iniciarSesion(nomUsu);
		session.setAttribute("usuario", bean);
		List<Enlace> lista=usuarioService.traearEnlaces(bean.getRolUsuario().getIdRol());
		String usu = bean.getNombre()+" "+bean.getApellido()+" ";
		String loginUsu = bean.getLogin()+" | ";
		model.addAttribute("usuario", usu); 	
		model.addAttribute("user", loginUsu); 
		model.addAttribute("menus",lista); 	
		if(bean.getRolUsuario().getIdRol()== 1) {
			model.addAttribute("carrito", "venta/listaDetalle");
			model.addAttribute("rol", bean.getRolUsuario().getIdRol());
		}
		
		return "menu";
	}
	
}
