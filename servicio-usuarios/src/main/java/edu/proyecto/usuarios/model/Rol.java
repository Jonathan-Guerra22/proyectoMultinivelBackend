package edu.proyecto.usuarios.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Rol implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRol;
	
    private String nombreRol;
    private Double gananciaLvl1;
    private Double gananciaLvl2;
    private Double gananciaLvl3;
    

	public Long getIdRol() {
		return idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public Double getGananciaLvl1() {
		return gananciaLvl1;
	}

	public void setGananciaLvl1(Double gananciaLvl1) {
		this.gananciaLvl1 = gananciaLvl1;
	}

	public Double getGananciaLvl2() {
		return gananciaLvl2;
	}

	public void setGananciaLvl2(Double gananciaLvl2) {
		this.gananciaLvl2 = gananciaLvl2;
	}

	public Double getGananciaLvl3() {
		return gananciaLvl3;
	}

	public void setGananciaLvl3(Double gananciaLvl3) {
		this.gananciaLvl3 = gananciaLvl3;
	}

	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof Rol)){
			return false;
		}
		
		Rol roll = (Rol) obj;
		return this.idRol!=null && this.idRol.equals(roll.getIdRol());
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8753041098538055880L;
}
