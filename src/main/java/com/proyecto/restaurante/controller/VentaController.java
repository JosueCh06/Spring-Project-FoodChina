package com.proyecto.restaurante.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.restaurante.entity.Boleta;
import com.proyecto.restaurante.entity.Detalle;
import com.proyecto.restaurante.entity.Enlace;
import com.proyecto.restaurante.entity.Platillo;
import com.proyecto.restaurante.entity.PlatilloHasBoleta;
import com.proyecto.restaurante.entity.Usuario;
import com.proyecto.restaurante.service.BoletaService;
import com.proyecto.restaurante.service.PlatilloService;
import com.proyecto.restaurante.service.UsuarioService;

@Controller
@RequestMapping(value = "/venta")
public class VentaController {

	@Autowired
	private PlatilloService platilloService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private BoletaService boletaService;
	
	
	@RequestMapping(value = "/")
	public String index(Model model, HttpSession session) {
		List<Detalle> lista;
		if(session.getAttribute("detalle")==null) {
			lista = new ArrayList<Detalle>();
		}else {
			lista = (List<Detalle>) session.getAttribute("detalle");
		}
		
		Usuario u = (Usuario) session.getAttribute("usuario");
		List<Enlace> lista0=usuarioService.traearEnlaces(u.getRolUsuario().getIdRol());
		List<Enlace> lista2 = new ArrayList<Enlace>();
		for(var a: lista0) {
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
		model.addAttribute("carrito", "listaDetalle");
		model.addAttribute("platillos", platilloService.listarTodos());
		model.addAttribute("detalle", lista);
		return "platilloVenta";
	}
	
	@RequestMapping(value = "/listaDetalle")
	private String listaDetalle(Model model, HttpSession session) {
		
		List<Detalle> lista = (List<Detalle>) session.getAttribute("detalle");
		double total= 0;
		
		if(lista == null) {
			
		}else {
			for(Detalle e : lista) {
				total += e.getSubTotal();
				model.addAttribute("totalPagar", total);
			}
		}
		model.addAttribute("detalle", lista);
		
		Usuario u = (Usuario) session.getAttribute("usuario");
		List<Enlace> lista0=usuarioService.traearEnlaces(u.getRolUsuario().getIdRol());
		List<Enlace> lista2 = new ArrayList<Enlace>();
		for(var a: lista0) {
			Enlace e = new Enlace();
			e.setIdEnlace(a.getIdEnlace());
			e.setDescripcion(a.getDescripcion());
			e.setLink("../"+a.getLink());
			e.setListaRolEnlace(null);
			lista2.add(e);
		}
		
		int cod = u.getIdUsuario();
		String usu = u.getNombre()+" "+u.getApellido()+" ";
		String loginUsu = u.getLogin()+" | ";
		
		String fecha =new Date().toString();
		
		model.addAttribute("codigoUsuario", cod);
		model.addAttribute("usuario", usu); 
		model.addAttribute("fecha", fecha);
		model.addAttribute("user", loginUsu);
		model.addAttribute("menus",lista2); 
		model.addAttribute("carrito", "listaDetalle");
		
		return "detalleVenta";
	}
	
	@RequestMapping("/adicionar")
	@ResponseBody
	public List<Detalle> adicionar(@RequestParam("cod") int cod, @RequestParam("nombre") String nom,
								@RequestParam("cantidad") int can, @RequestParam("precio") double pre,
								@RequestParam("image") String ruta, HttpSession session, RedirectAttributes redirect) {
		List<Detalle> lista;
		if(session.getAttribute("detalle")==null) {
			lista = new ArrayList<Detalle>();
		}else {
			lista = (List<Detalle>) session.getAttribute("detalle");
		}	
		
		int platillos = 0;
		platillos = lista.size();
				
		Detalle det = new Detalle();
		det.setCodPlatillo(cod);
		det.setNomPlatillo(nom);
		det.setCantidad(can);
		det.setPrecio(pre);
		det.setRuta(ruta);
		int index=-1;
		
		for(Detalle d : lista) {
			if(d.getCodPlatillo() == det.getCodPlatillo()) {
				int cant = det.getCantidad();
				cant +=   d.getCantidad();
				det.setCantidad(cant);			
				index = lista.indexOf(d);
				redirect.addFlashAttribute("MENSAJE", "Se agrego al carrito");
			}
		}		
		lista.add(det);
		if(index!= -1) {
			lista.remove(index);
		}
		
		if(platillos < lista.size()) {
			redirect.addFlashAttribute("MENSAJE", "Se agrego al carrito");
		}else {
			redirect.addFlashAttribute("MENSAJE", "Error al agregar");
		}
		
		session.setAttribute("detalle", lista);
		
		
		return lista;
	}
	
	
	@RequestMapping("/eliminar")
	@ResponseBody
	public List<Detalle> eliminar(@RequestParam("cod") int cod, HttpSession session) {	
		List<Detalle> lista = (List<Detalle>) session.getAttribute("detalle");
		for(Detalle det : lista) {
			if(det.getCodPlatillo()==cod) {
				lista.remove(det);
				break;
			}
		}
		session.setAttribute("detalle", lista);
		
		return lista;
	}
	
	@RequestMapping("/grabar")
	public String grabar(HttpSession session, @RequestParam("codigoCliente") int cod, 
							@RequestParam("total") double total ,RedirectAttributes redirect) {
		
		try {
			Boleta bol = new Boleta();
			bol.setFecha(new Date());
			bol.setTotalPagar(total);
			
			Usuario u;
			u = (Usuario) session.getAttribute("usuario");
			bol.setUsuario(u);
			
			List<Detalle> lista = (List<Detalle>) session.getAttribute("detalle");
			List<PlatilloHasBoleta> datos = new ArrayList<PlatilloHasBoleta>();
			for(Detalle d : lista) {
				PlatilloHasBoleta phb = new PlatilloHasBoleta();
				phb.setPlatillo(new Platillo(d.getCodPlatillo()));
				phb.setPrecio(d.getPrecio());
				phb.setCantidad(d.getCantidad());
				phb.setSubTotal(d.getSubTotal());
				datos.add(phb);
			}
			
			bol.setListaPlatilloHasBoleta(datos);
			boletaService.guardarBoleta(bol);
			
			lista.clear();
			session.setAttribute("detalle", lista);
			redirect.addFlashAttribute("MENSAJE", "Pedido registrado!");
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("MENSAJE", "Error al registrar el pedido");
		}
		
		
		return "redirect:/venta/";
	}
	
	
	@RequestMapping("/consulta")
	public String consultaBoleta(Model model ,HttpSession session) {
		
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
		
		return "consultaPromocion";
	}
	
	@RequestMapping("/porMonto")
	@ResponseBody
	public List<Boleta> consulta(@RequestParam("suma") double monto){
		List<Boleta> lista = boletaService.listBoletaXMonto(monto);
		return lista;
	}
	
	
	
	
	
}
