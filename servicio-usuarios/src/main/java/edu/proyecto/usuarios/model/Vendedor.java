package edu.proyecto.usuarios.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import edu.proyecto.ventas.model.Venta;

@Entity
@Table(name = "vendedores")
public class Vendedor implements Serializable {

	@Id
	private Long cedulavendedor;

	private String nombreVendedor;
	private String apellidoVendedor;
	private Long celularVendedor;
	private String ciudadVendedor;
	private String direccion;
	private String estadoVendedor;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "vendedor_rol", joinColumns = @JoinColumn(name = "cedulavendedor"), inverseJoinColumns = @JoinColumn(name = "idrol"))
	private List<Rol> roles;

	/*
	 * @ManyToMany(fetch = FetchType.LAZY)
	 * 
	 * @JoinTable(name="persona_rol", joinColumns = @JoinColumn(name="persona_id"),
	 * inverseJoinColumns = @JoinColumn(name="rol_id")) private List<Rol> roles;
	 */

	@OneToOne(cascade = CascadeType.ALL)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "vendedor_afiliador")
	private Vendedor vendedoreAfiliador;


	private Long grupo;

	// relacion vendedor - venta
	@JoinColumn(name = "idventa")
	private Long idventa;
	@Transient
	private List<Venta> ventas;

	/*
	 * IdRolVendedor INTEGER, foreign key(IdRolVendedor) REFERENCES Roles(IdRol),
	 * 
	 * 
	 * OK CedulaVendedorAsociado bigint, foreign key(CedulaVendedorAsociado)
	 * REFERENCES vendedores(CedulaVendedor),
	 * 
	 * 
	 * OK CedulaUsuario bigint, foreign key(CedulaUsuario) REFERENCES
	 * usuarios(CedulaUsuario)
	 */

	
	
	public Long getGrupo() {
		return grupo;
	}
	
	public void setGrupo(Long grupo) {
		this.grupo = grupo;
	}
	
	
	public Long getIdventa() {
		return idventa;
	}


	public void setIdventa(Long idventa) {
		this.idventa = idventa;
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public Vendedor getVendedoreAfiliador() {
		return vendedoreAfiliador;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public void setVendedoreAfiliador(Vendedor vendedoreAfiliador) {
		this.vendedoreAfiliador = vendedoreAfiliador;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getCedulavendedor() {
		return cedulavendedor;
	}

	public void setCedulavendedor(Long cedulavendedor) {
		this.cedulavendedor = cedulavendedor;
	}

	public String getEstadoVendedor() {
		return estadoVendedor;
	}

	public void setEstadoVendedor(String estadoVendedor) {
		this.estadoVendedor = estadoVendedor;
	}

	public String getNombreVendedor() {
		return nombreVendedor;
	}

	public void setNombreVendedor(String nombreVendedor) {
		this.nombreVendedor = nombreVendedor;
	}

	public String getApellidoVendedor() {
		return apellidoVendedor;
	}

	public void setApellidoVendedor(String apellidoVendedor) {
		this.apellidoVendedor = apellidoVendedor;
	}

	public Long getCelularVendedor() {
		return celularVendedor;
	}

	public void setCelularVendedor(Long celularVendedor) {
		this.celularVendedor = celularVendedor;
	}

	public String getCiudadVendedor() {
		return ciudadVendedor;
	}

	public void setCiudadVendedor(String ciudadVendedor) {
		this.ciudadVendedor = ciudadVendedor;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Vendedor)) {
			return false;
		}

		Vendedor vend = (Vendedor) obj;
		return this.cedulavendedor != null && this.cedulavendedor.equals(vend.getCedulavendedor());
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 9205612964037553903L;

}
