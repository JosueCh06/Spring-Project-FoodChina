package com.proyecto.restaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.restaurante.dao.BoletaDAO;
import com.proyecto.restaurante.dao.BoletaDAO2;
import com.proyecto.restaurante.entity.Boleta;

@Service
public class BoletaService {

	@Autowired
	private BoletaDAO boletaDAO;
	
	@Autowired
	private BoletaDAO2 boletaDAO2;
	
	public void guardarBoleta(Boleta bol) {
		boletaDAO.saveBoleta(bol);
	}
	
	public List<Boleta> listBoletaXMonto(double monto){
		return boletaDAO2.listBoletaXMonto(monto);
	}
	
}
