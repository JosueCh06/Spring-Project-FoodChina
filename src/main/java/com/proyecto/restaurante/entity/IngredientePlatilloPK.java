package com.proyecto.restaurante.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

@Embeddable
public class IngredientePlatilloPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int idIngrediente;
	private int idPlatillo;
	
	@Override
	public int hashCode() {
		return Objects.hash(idIngrediente, idPlatillo);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IngredientePlatilloPK other = (IngredientePlatilloPK) obj;
		return idPlatillo == other.idPlatillo && idIngrediente == other.idIngrediente;
	}
	
	/*
	 * 
	 * 
	 * 
	 * 
	 */
	
	public int getIdIngrediente() {
		return idIngrediente;
	}

	public void setIdIngrediente(int idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public int getIdPlatillo() {
		return idPlatillo;
	}

	public void setIdPlatillo(int idPlatillo) {
		this.idPlatillo = idPlatillo;
	}
	
	
}
