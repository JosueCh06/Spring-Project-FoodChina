package com.proyecto.restaurante.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.restaurante.entity.CategoriaProveedor;
import com.proyecto.restaurante.entity.Enlace;
import com.proyecto.restaurante.entity.Proveedor;
import com.proyecto.restaurante.entity.Usuario;
import com.proyecto.restaurante.service.CategoriaProveedorService;
import com.proyecto.restaurante.service.ProveedorService;
import com.proyecto.restaurante.service.UsuarioService;

@Controller
@RequestMapping(value = "/proveedor")
public class ProveedorController {

	@Autowired
	private CategoriaProveedorService categoriaProveedorService;
	
	@Autowired
	private ProveedorService proveedorService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/")
	public String index(Model model, HttpSession session) {
		model.addAttribute("proveedores", proveedorService.list());
		model.addAttribute("categorias", categoriaProveedorService.list());
		
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
		
		return "proveedor";
	}
	
	@RequestMapping(value = "/guardar")
	public String guardar(@RequestParam("codigo") int cod,
						  @RequestParam("nombre") String nom,
						  @RequestParam("representante") String representante,
						  @RequestParam("celular") String celular,
						  @RequestParam("direccion") String direccion,
						  @RequestParam("categoria") int CodCat,
						  RedirectAttributes redirect) {
		try {
			Proveedor bean = new Proveedor();
			bean.setNombre(nom);
			bean.setRepresentante(representante);
			bean.setCelular(celular);
			bean.setDireccion(direccion);
			bean.setCategoriaProveedor(new CategoriaProveedor(CodCat));
			if(cod!=0) {
				bean.setIdProveedor(cod);
				proveedorService.update(bean);
				redirect.addFlashAttribute("MENSAJE", "Proveedor actualizado...");
			}
			else {
				proveedorService.save(bean);
				redirect.addFlashAttribute("MENSAJE", "Proveedor registrado...");
			}
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE", "Error al guardar proveedor...");
			e.printStackTrace();
		}
		return "redirect:/proveedor/";
	}
	
	@RequestMapping(value = "/buscar")
	@ResponseBody
	public Proveedor buscar(@RequestParam("codigo") int cod) {
		Proveedor bean = null;
		try {
			bean = proveedorService.buscar(cod);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	@RequestMapping(value = "/eliminar")
	public String eliminar(@RequestParam("codigo") int cod,RedirectAttributes redirect) {
		try {
			proveedorService.delete(cod);
			redirect.addFlashAttribute("MENSAJE","Proveedor eliminado");
			
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("MENSAJE","Error en la eliminación");
		}
		return "redirect:/proveedor/";
	}
	
	
	//Consulta 
		@RequestMapping(value = "/consulta")
		public String consultaProveedor(Model model, HttpSession session) {
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
			
			
			model.addAttribute("categorias", categoriaProveedorService.list());		
			return "consultaProveedor";
		}
	
	@RequestMapping("/PorCategoria")
	@ResponseBody
	public List<Proveedor> consulta(@RequestParam("catProducto") int codCatProducto){
		List<Proveedor> lista = proveedorService.listProveedorXCategoria(codCatProducto);
		return lista;
	}
	
}
