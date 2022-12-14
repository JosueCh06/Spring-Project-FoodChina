package com.proyecto.restaurante.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PlatilloHasBoletaPK implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column(name = "num_bol")
	private int numeroBoleta;
	
	@Column(name = "id_platillo")
	private int codigoPlatillo;
	
	/*
	 * 
	 * 
	 * 
	 * 
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoPlatillo;
		result = prime * result + numeroBoleta;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlatilloHasBoletaPK other = (PlatilloHasBoletaPK) obj;
		if (codigoPlatillo != other.codigoPlatillo)
			return false;
		if (numeroBoleta != other.numeroBoleta)
			return false;
		return true;
	}
	
	/*
	 * 
	 * 
	 * 
	 */
	
	public int getNumeroBoleta() {
		return numeroBoleta;
	}
	public void setNumeroBoleta(int numeroBoleta) {
		this.numeroBoleta = numeroBoleta;
	}
	public int getCodigoPlatillo() {
		return codigoPlatillo;
	}
	public void setCodigoPlatillo(int codigoPlatillo) {
		this.codigoPlatillo = codigoPlatillo;
	}
	
	
}
