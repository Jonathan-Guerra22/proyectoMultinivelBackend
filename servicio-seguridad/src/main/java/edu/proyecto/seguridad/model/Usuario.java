package edu.proyecto.seguridad.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario implements Serializable{

	@Id
	private Long cedula;
	
	private String contrasena;
	private String estado;
	


	public Long getCedula() {
		return cedula;
	}

	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof Usuario)){
			return false;
		}
		
		Usuario usua = (Usuario) obj;
		return this.cedula!=null && this.cedula.equals(usua.getCedula());
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7444938583059521023L;
}
