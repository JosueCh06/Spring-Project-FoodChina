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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_categoria_platillo")
public class CategoriaPlatillo implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria_platillo")
	private int idCategoria;
	
	@Column(name = "desc_cat_platillo")
	private String descripcionCategoria;

	@JsonIgnore
	@OneToMany(mappedBy = "categoria")
	private List<Platillo> listaPlatillo;
	
	/*
	 * 
	 * 
	 */
	public CategoriaPlatillo() {
	}
	
	public CategoriaPlatillo(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	
	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescripcionCategoria() {
		return descripcionCategoria;
	}

	public void setDescripcionCategoria(String descripcionCategoria) {
		this.descripcionCategoria = descripcionCategoria;
	}

	public List<Platillo> getListaPlatillo() {
		return listaPlatillo;
	}

	public void setListaPlatillo(List<Platillo> listaPlatillo) {
		this.listaPlatillo = listaPlatillo;
	}
	
	
	
}
