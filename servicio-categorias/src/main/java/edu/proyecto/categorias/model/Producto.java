package edu.proyecto.categorias.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="productos")
public class Producto implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idproducto;
	
	private String estadoproducto;
	
	@NotEmpty(message="No puede estar vacio")
	private String nombreproducto;
	
	@Lob
	@JsonIgnore
	private byte[] fotoproducto;
	
	//@NotEmpty(message="No puede estar vacio")
	private double precioproducto;
	
	@NotEmpty(message="No puede estar vacio")
	private String colorproducto;
	
	@NotEmpty(message="No puede estar vacio")
	private String tallaproducto;
	
	@NotEmpty(message="No puede estar vacio")
	private String descripcionproducto;
	
	//@NotEmpty(message="No puede estar vacio")
	@ManyToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","productos"})
	private Categoria categoria;
	
	public Producto() {
		
	}


	public Long getIdproducto() {
		return idproducto;
	}


	public void setIdproducto(Long idproducto) {
		this.idproducto = idproducto;
	}


	public String getEstadoproducto() {
		return estadoproducto;
	}


	public void setEstadoproducto(String estadoproducto) {
		this.estadoproducto = estadoproducto;
	}


	public String getNombreproducto() {
		return nombreproducto;
	}


	public void setNombreproducto(String nombreproducto) {
		this.nombreproducto = nombreproducto;
	}


	public byte[] getFotoproducto() {
		return fotoproducto;
	}


	public void setFotoproducto(byte[] fotoproducto) {
		this.fotoproducto = fotoproducto;
	}
	public Integer getFotoproductoHashCode() {
		return (this.fotoproducto!=null)? fotoproducto.hashCode():null;
	}

	public double getPrecioproducto() {
		return precioproducto;
	}


	public void setPrecioproducto(double precioproducto) {
		this.precioproducto = precioproducto;
	}


	public String getColorproducto() {
		return colorproducto;
	}


	public void setColorproducto(String colorproducto) {
		this.colorproducto = colorproducto;
	}


	public String getTallaproducto() {
		return tallaproducto;
	}


	public void setTallaproducto(String tallaproducto) {
		this.tallaproducto = tallaproducto;
	}


	public String getDescripcionproducto() {
		return descripcionproducto;
	}


	public void setDescripcionproducto(String descripcionproducto) {
		this.descripcionproducto = descripcionproducto;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	
 
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof Producto)){
			return false;
		}
		
		Producto prod = (Producto) obj;
		return this.idproducto!=null && this.idproducto.equals(prod.getIdproducto());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -3149528028633441038L;
	
}
