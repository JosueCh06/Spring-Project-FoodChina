package com.proyecto.restaurante.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_enlace")
public class Enlace implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_enlace")
	private Integer idEnlace;

	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name = "ruta")
	private String link;
	
	@OneToMany(mappedBy = "enlace")
	private List<RolEnlace> listaRolEnlace;

	/*
	 * 
	 * 
	 * 
	 * 
	 */
	
	public int getIdEnlace() {
		return idEnlace;
	}

	public void setIdEnlace(int idEnlace) {
		this.idEnlace = idEnlace;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<RolEnlace> getListaRolEnlace() {
		return listaRolEnlace;
	}

	public void setListaRolEnlace(List<RolEnlace> listaRolEnlace) {
		this.listaRolEnlace = listaRolEnlace;
	}
}
