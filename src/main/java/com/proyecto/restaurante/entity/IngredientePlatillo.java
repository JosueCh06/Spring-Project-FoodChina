package com.proyecto.restaurante.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_ingrediente_platillo")
public class IngredientePlatillo implements Serializable{
	private static final long serialVersionUID = 1L;
	

	@EmbeddedId
	private IngredientePlatilloPK id;
	
	@ManyToOne
	@JoinColumn(name = "idPlatillo", referencedColumnName = "id_platillo", insertable = false, updatable = false)
	private Platillo platillo;
	
	@ManyToOne
	@JoinColumn(name = "idIngrediente", referencedColumnName = "id_ingrediente", insertable = false, updatable = false)
	private Ingrediente ingrediente;

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	public IngredientePlatilloPK getId() {
		return id;
	}

	public void setId(IngredientePlatilloPK id) {
		this.id = id;
	}

	public Platillo getPlatillo() {
		return platillo;
	}

	public void setPlatillo(Platillo platillo) {
		this.platillo = platillo;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}
	
	

}
