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
@Table(name = "tb_ingrediente")
public class Ingrediente implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ingrediente")
	private int idIngrediente;
	
	@Column(name = "desc_ingrediente")
	private String descripcion;
	
	@Column(name = "stock")
	private int stock;
	
	//@Column(name = "uMedida")
	//private String uMedida;
	
	@Column(name = "u_medida")
	private String unidadMedida;
	
	@ManyToOne
	@JoinColumn(name = "id_proveedor")
	private Proveedor proveedor;
	
	@JsonIgnore
	@OneToMany(mappedBy = "ingrediente")
	private List<IngredientePlatillo> listaIngredientePlatillo;

	/*
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public List<IngredientePlatillo> getListaIngredientePlatillo() {
		return listaIngredientePlatillo;
	}

	public void setListaIngredientePlatillo(List<IngredientePlatillo> listaIngredientePlatillo) {
		this.listaIngredientePlatillo = listaIngredientePlatillo;
	}

	/*public String getuMedida() {
		return uMedida;
	}

	public void setuMedida(String uMedida) {
		this.uMedida = uMedida;
	}*/

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

}
