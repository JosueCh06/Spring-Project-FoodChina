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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.restaurante.entity.Enlace;
import com.proyecto.restaurante.entity.Ingrediente;
import com.proyecto.restaurante.entity.Proveedor;
import com.proyecto.restaurante.entity.Usuario;
import com.proyecto.restaurante.service.CategoriaProveedorService;
import com.proyecto.restaurante.service.IngredienteService;
import com.proyecto.restaurante.service.ProveedorService;
import com.proyecto.restaurante.service.UsuarioService;


@Controller
@RequestMapping(value = "/ingrediente")
public class IngredienteController {
	
	@Autowired
	private IngredienteService ingredienteService;
	@Autowired
	private CategoriaProveedorService categoriaPService;
	@Autowired
	private ProveedorService proveedorService;
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/")
	private String Index(Model model, HttpSession session) {
		model.addAttribute("ingredientes", ingredienteService.list());
		model.addAttribute("categorias", categoriaPService.list());
		
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
		
		return "ingrediente";
	}
	
	@RequestMapping(value = "/guardar")
	public String guardar(@RequestParam("idIngrediente") int cod,
						  @RequestParam("descripcion") String desc,
						  @RequestParam("stock") int stock,
						  @RequestParam("uMedida") String uMedida,
						  @RequestParam("idProveedor") int idProveedor,
						  RedirectAttributes redirect) {
		try {
			Ingrediente bean = new Ingrediente();
			bean.setDescripcion(desc);
			bean.setStock(stock);
			bean.setUnidadMedida(uMedida);
			bean.setProveedor(new Proveedor(idProveedor));
			if(cod!=0) {
				bean.setIdIngrediente(cod);
				ingredienteService.update(bean);
				redirect.addFlashAttribute("MENSAJE", "Ingrediente Actualizado");
			}
			else {
				ingredienteService.save(bean);
				redirect.addFlashAttribute("MENSAJE", "Ingrediente registrado");
			}
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE", "Error al guardar ingrediente");
			e.printStackTrace();
		}
		return "redirect:/ingrediente/";
	}
	
	@RequestMapping(value = "/buscar")
	@ResponseBody
	public Ingrediente buscar(@RequestParam("id") int cod) {
		Ingrediente bean = null;
		try {
			bean = ingredienteService.buscar(cod);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	@RequestMapping(value = "/eliminar")
	public String eliminar(@RequestParam("idIngrediente") int cod,RedirectAttributes redirect) {
		try {
			ingredienteService.delete(cod);
			redirect.addFlashAttribute("MENSAJE","Ingrediente eliminado");
			
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("MENSAJE","Error en la eliminación");
		}
		return "redirect:/ingrediente/";
	}
	
	@RequestMapping(value = "/listarProveedorPorCategoria")
	@ResponseBody
	public List<Proveedor> listarTiposAtLaboratorio(@RequestParam("codCate") int codigo){
		List<Proveedor> lista=null;
		try {
			lista=proveedorService.listarPorCategoria(codigo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}
