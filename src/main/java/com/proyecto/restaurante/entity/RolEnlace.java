package com.proyecto.restaurante.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_rol_enlace")
public class RolEnlace implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private RolEnlacePK id;
	
	@ManyToOne
	@JoinColumn(name = "id_rol", referencedColumnName = "id_rol", insertable = false, updatable = false)
	private Rol rol;
	
	@ManyToOne
	@JoinColumn(name = "id_enlace", referencedColumnName = "id_enlace", insertable = false, updatable = false)
	private Enlace enlace;

	/*
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	public RolEnlacePK getId() {
		return id;
	}

	public void setId(RolEnlacePK id) {
		this.id = id;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Enlace getEnlace() {
		return enlace;
	}

	public void setEnlace(Enlace enlace) {
		this.enlace = enlace;
	}

}
