package edu.proyecto.usuarios.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="administradores")
public class Administrador implements Serializable{

	@Id
	private Long cedulaAdministrador;
	
    private String nombreAdmin;
    private String estado;
    
	@OneToOne(cascade = CascadeType.ALL)
	private Usuario usuario;
	
    /*
    CedulaUsuario BIGINT,
    FOREIGN KEY(CedulaUsuario) REFERENCES usuarios(CedulaUsuario)
     */
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Long getCedulaAdministrador() {
		return cedulaAdministrador;
	}
	public void setCedulaAdministrador(Long cedulaAdministrador) {
		this.cedulaAdministrador = cedulaAdministrador;
	}
	public String getNombreAdmin() {
		return nombreAdmin;
	}
	public void setNombreAdmin(String nombreAdmin) {
		this.nombreAdmin = nombreAdmin;
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
		if(!(obj instanceof Administrador)){
			return false;
		}
		
		Administrador adm = (Administrador) obj;
		return this.cedulaAdministrador!=null && this.cedulaAdministrador.equals(adm.getCedulaAdministrador());
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6989860717231998434L;

}
