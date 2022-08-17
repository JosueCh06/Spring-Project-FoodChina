package com.proyecto.restaurante.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_platillo_has_boleta")
public class PlatilloHasBoleta implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@EmbeddedId
	private PlatilloHasBoletaPK pk;
	
	@ManyToOne
	@JoinColumn(name = "num_bol", referencedColumnName = "num_bol", insertable = false, updatable = false)
	private Boleta boleta;

	@ManyToOne
	@JoinColumn(name = "id_platillo", referencedColumnName = "id_platillo", insertable = false, updatable = false)
	private Platillo platillo;
	
	@Column(name = "precio")
	private double precio;
	
	@Column(name = "cantidad")
	private int cantidad;
	
	@Column(name = "sub_total")
	private double subTotal;
	
	/*
	 * 
	 * 
	 * 
	 * 
	 */

	public PlatilloHasBoletaPK getPk() {
		return pk;
	}

	public void setPk(PlatilloHasBoletaPK pk) {
		this.pk = pk;
	}

	public Boleta getBoleta() {
		return boleta;
	}

	public void setBoleta(Boleta boleta) {
		this.boleta = boleta;
	}

	public Platillo getPlatillo() {
		return platillo;
	}

	public void setPlatillo(Platillo platillo) {
		this.platillo = platillo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	
	
	
}
