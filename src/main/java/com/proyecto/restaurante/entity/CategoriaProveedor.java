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
@Table(name = "tb_categoria_proveedor")
public class CategoriaProveedor implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_categoriaP")
	private int idCategoriaP;
	
	@Column(name="desc_categoriaP")
	private String descripcionCategoriaP;
	
	@OneToMany(mappedBy = "categoriaProveedor")
	@JsonIgnore
	private List<Proveedor> listaProveedor;

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public CategoriaProveedor() {
	}
	
	public CategoriaProveedor(int codCategoria) {
		this.idCategoriaP = codCategoria;
	}
	
	
	public int getIdCategoriaP() {
		return idCategoriaP;
	}

	public void setIdCategoriaP(int idCategoriaP) {
		this.idCategoriaP = idCategoriaP;
	}

	public String getDescripcionCategoriaP() {
		return descripcionCategoriaP;
	}

	public void setDescripcionCategoriaP(String descripcionCategoriaP) {
		this.descripcionCategoriaP = descripcionCategoriaP;
	}

	public List<Proveedor> getListaProveedor() {
		return listaProveedor;
	}

	public void setListaProveedor(List<Proveedor> listaProveedor) {
		this.listaProveedor = listaProveedor;
	}
	
}
