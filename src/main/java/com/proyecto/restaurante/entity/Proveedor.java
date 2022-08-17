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
@Table(name = "tb_proveedor")
public class Proveedor  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_proveedor")
	private int idProveedor;
	
	@Column(name = "nomb_proveedor")
	private String nombre;
	
	@Column(name = "representante")
	private String representante;
	
	@Column(name = "cel_proveedor")
	private String celular;
	
	@Column(name = "dir_proveedor")
	private String direccion;
	
	@JsonIgnore
	@OneToMany(mappedBy = "proveedor")
	private List<Ingrediente> listaIngredientes;

	@ManyToOne
	@JoinColumn(name="id_categoriaP")
	private CategoriaProveedor categoriaProveedor;
	
	/*
	 * 
	 * 
	 * 
	 *
	 */
	
	public Proveedor() {
	}
	public Proveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}
	
	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public List<Ingrediente> getListaIngredientes() {
		return listaIngredientes;
	}

	public void setListaIngredientes(List<Ingrediente> listaIngredientes) {
		this.listaIngredientes = listaIngredientes;
	}

	public CategoriaProveedor getCategoriaProveedor() {
		return categoriaProveedor;
	}

	public void setCategoriaProveedor(CategoriaProveedor categoriaProveedor) {
		this.categoriaProveedor = categoriaProveedor;
	}

	
	
	
}
