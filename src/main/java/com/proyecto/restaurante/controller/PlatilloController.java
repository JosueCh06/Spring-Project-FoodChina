package com.proyecto.restaurante.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.restaurante.entity.CategoriaPlatillo;
import com.proyecto.restaurante.entity.Enlace;
import com.proyecto.restaurante.entity.Platillo;
import com.proyecto.restaurante.entity.Usuario;
import com.proyecto.restaurante.service.CategoriaPlatilloService;
import com.proyecto.restaurante.service.PlatilloService;
import com.proyecto.restaurante.service.UsuarioService;

@Controller
@RequestMapping(value="/platillo")
public class PlatilloController {
	
	@Autowired
	private PlatilloService platilloService;
	@Autowired
	private CategoriaPlatilloService categoriaPlatilloService;
	@Autowired
	private UsuarioService usuarioService;

	
	@RequestMapping(value = "/")
	private String index(Model model, HttpSession session, RedirectAttributes redirect) {
			
		model.addAttribute("platillos", platilloService.listarTodos());
		model.addAttribute("categorias", categoriaPlatilloService.listarCategoriasPlatillo());

		Usuario u = (Usuario) session.getAttribute("usuario");
		List<Enlace> lista=usuarioService.traearEnlaces(u.getRolUsuario().getIdRol());
		List<Enlace> lista2 = new ArrayList<Enlace>();
		for(var a: lista) {
			Enlace e = new Enlace();
			e.setIdEnlace(a.getIdEnlace());
			e.setDescripcion(a.getDescripcion());
			e.setLink("../"+a.getLink());
			e.setListaRolEnlace(null);
			lista2.add(e);
		}
		
		String usu = u.getNombre()+" "+u.getApellido()+" ";
		String loginUsu = u.getLogin()+" | ";

		model.addAttribute("usuario", usu); 	
		model.addAttribute("user", loginUsu);
		model.addAttribute("menus",lista2); 
		
		return "platillo";
	}
	
	@RequestMapping(value = "/guardar")
	public String guardar(@RequestParam("descripcion") String desc, @RequestParam("codigo") int cod, 
						  @RequestParam("precio") double precio, @RequestParam("categoria") int categoria,
						  @RequestParam("imagen") MultipartFile file, RedirectAttributes redirect){
		
		try {
			String folder="src//main//resources//static//resources//cargas//platillos//";
			if (!file.isEmpty()) {
				try {
					Platillo bean=new Platillo();
					bean.setDescripccion(desc);
					bean.setPrecio(precio);
					bean.setCategoria(new CategoriaPlatillo(categoria));
					String ruta="/resources/cargas/platillos/";
					
					byte [] bytes= file.getBytes();
					Path path = Paths.get( folder+file.getOriginalFilename() );
					Files.write(path, bytes);				
					
					bean.setLinkImagen(ruta+file.getOriginalFilename());
					
					if(cod!=0) {
						bean.setIdPlatillo(cod);
						platilloService.actualizar(bean);
						redirect.addFlashAttribute("MENSAJE","Platillo actualizado");
					}
					else {
						platilloService.registrar(bean);
						redirect.addFlashAttribute("MENSAJE","Platillo registrado");
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error al guardar");
			e.printStackTrace();
		}
		
		return "redirect:/platillo/";
	}
	
	@RequestMapping(value = "/buscar")
	@ResponseBody
	public Platillo buscar(@RequestParam("idPlatillo") int cod) {
		Platillo bean=null;
		try {
			bean=platilloService.buscar(cod);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	@RequestMapping(value = "/eliminar")
	public String eliminar(@RequestParam("idPlatillo") int cod,RedirectAttributes redirect) {
		try {
			platilloService.eliminar(cod);
			redirect.addFlashAttribute("MENSAJE","Platillo eliminado");
			
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("MENSAJE","Ocurrio un error en la eliminacion");
		}
		return "redirect:/platillo/";
	}

}
