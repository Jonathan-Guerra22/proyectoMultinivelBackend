package edu.proyecto.usuarios.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "grupos")
public class Grupo implements Serializable {

	@Id
	private Long id;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Vendedor> vendedores;
	
	
	public List<Vendedor> getVendedores() {
		return vendedores;
	}
	
	public void setVendedores(List<Vendedor> vendedores) {
		this.vendedores = vendedores;
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Grupo)) {
			return false;
		}

		Grupo group = (Grupo) obj;
		return this.id != null && this.id.equals(group.getId());
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7881601675955351807L;
}
