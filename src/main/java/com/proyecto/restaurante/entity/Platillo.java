package com.proyecto.restaurante.entity;

import java.io.Serializable;
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


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_platillo")
public class Platillo implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_platillo")
	private int idPlatillo;
	
	@Column(name = "desc_platillo")
	private String descripcion;
	
	@Column(name = "precio")
	private double precio;
	
	@ManyToOne
	@JoinColumn(name="id_cat_platillo")
	private CategoriaPlatillo categoria;
	
	@JsonIgnore
	@OneToMany(mappedBy = "platillo")
	private List<IngredientePlatillo> listaIngredientePlatillo;
	
	@Column(name = "rutaImagen")
	private String linkImagen;
	
	@JsonIgnore
	@OneToMany(mappedBy = "platillo")
	private List<PlatilloHasBoleta> listaPlatilloHasBoleta;

	/*
	 * 
	 * 
	 */
	
	public Platillo() {
		
	}
	public Platillo(int idPlatillo) {
		this.idPlatillo = idPlatillo;
	}
	
	public int getIdPlatillo() {
		return idPlatillo;
	}

	public void setIdPlatillo(int idPlatillo) {
		this.idPlatillo = idPlatillo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripccion(String descripccion) {
		this.descripcion = descripccion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public CategoriaPlatillo getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaPlatillo categoria) {
		this.categoria = categoria;
	}

	public List<IngredientePlatillo> getListaIngredientePlatillo() {
		return listaIngredientePlatillo;
	}

	public void setListaIngredientePlatillo(List<IngredientePlatillo> listaIngredientePlatillo) {
		this.listaIngredientePlatillo = listaIngredientePlatillo;
	}

	public String getLinkImagen() {
		return linkImagen;
	}

	public void setLinkImagen(String linkImagen) {
		this.linkImagen = linkImagen;
	}

	

	

	
		
}
