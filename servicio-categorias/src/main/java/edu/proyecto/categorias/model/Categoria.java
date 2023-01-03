package edu.proyecto.categorias.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name="categorias")
public class Categoria implements Serializable{

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="estadocategoria")
	private String estado;
	
	@NotEmpty(message="No puede estar vacio")
	@Size(min=1,max=30, message="El numero de caracteres debe estar entre 1 y 30")
	@Column(name="nombrecategoria")
	private String nombre;
	
	@NotEmpty(message="No puede estar vacio")
	@Size(min=1,max=30, message="El numero de caracteres debe estar entre 1 y 30")
	@Column(name="generocategoria")
	private String genero;
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}

	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof Categoria)){
			return false;
		}
		
		Categoria cate = (Categoria) obj;
		return this.id!=null && this.id.equals(cate.getId());
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1341147993273894988L;
	
}
