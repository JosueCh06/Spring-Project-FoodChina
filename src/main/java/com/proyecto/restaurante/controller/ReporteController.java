package com.proyecto.restaurante.controller;

import java.io.File;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.restaurante.entity.Boleta;
import com.proyecto.restaurante.entity.Ingrediente;
import com.proyecto.restaurante.service.BoletaService;
import com.proyecto.restaurante.service.IngredienteService;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/reporte")
public class ReporteController {

	@Autowired
	private IngredienteService ingredienteService;
	
	@Autowired
	private BoletaService boletaService;
	
	@RequestMapping("/ingredientes")
	public void ingredientes(HttpServletResponse response) {
		try {
			List<Ingrediente> lista = ingredienteService.list();
			File file = ResourceUtils.getFile("classpath:ReporteIngredientesStock.jrxml");
			JasperReport jasper = JasperCompileManager.compileReport(file.getAbsolutePath());
			JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(lista);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasper, null, data);
			response.setContentType("application/pdf");
			OutputStream salida = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, salida);		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/ganadores")
	public void reporteBoleta(HttpServletResponse response,@RequestParam("suma") double suma ) {
		try {
			List<Boleta> lista = boletaService.listBoletaXMonto(suma);
			File file=ResourceUtils.getFile("classpath:ReportePromocion.jrxml");
			JasperReport jasper=JasperCompileManager.compileReport(file.getAbsolutePath());
			JRBeanCollectionDataSource data=new JRBeanCollectionDataSource(lista);
			JasperPrint jasperPrint=JasperFillManager.fillReport(jasper,null, data); 
			response.setContentType("application/pdf");
			OutputStream salida=response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, salida);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
