package com.proyecto.restaurante.security;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;
import com.proyecto.restaurante.dao.UsuarioDAO;
import com.proyecto.restaurante.entity.Usuario;



@Service
public class UserService implements UserDetailsService {

	@Autowired
	UsuarioDAO usuarioDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDet = null;
		Usuario bean;
		bean = usuarioDAO.iniciarSesion(username);
		
		Set<GrantedAuthority> authority = new HashSet<GrantedAuthority>();
		authority.add(new SimpleGrantedAuthority(bean.getRolUsuario().getDescripcion()));
		
		userDet = new User(username, bean.getPassword() , authority );
		
		return userDet;
	}

}
