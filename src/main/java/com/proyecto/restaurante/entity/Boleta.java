package com.proyecto.restaurante.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_boleta")
public class Boleta implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="num_bol")
	private int numeroBoleta;
	
	@ManyToOne
	@JoinColumn(name = "cod_usu")
	private Usuario usuario;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fec_emi_bol")
	private Date fecha;
	
	@Column(name = "total_pagar")
	private double totalPagar;
	
	@JsonIgnore
	@OneToMany(mappedBy = "boleta")
	private List<PlatilloHasBoleta> listaPlatilloHasBoleta;

	/*
	 * 
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}

	public List<PlatilloHasBoleta> getListaPlatilloHasBoleta() {
		return listaPlatilloHasBoleta;
	}

	public void setListaPlatilloHasBoleta(List<PlatilloHasBoleta> listaPlatilloHasBoleta) {
		this.listaPlatilloHasBoleta = listaPlatilloHasBoleta;
	}
	
	
	
}
