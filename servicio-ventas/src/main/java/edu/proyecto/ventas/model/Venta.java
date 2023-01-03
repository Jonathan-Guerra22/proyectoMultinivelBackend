package edu.proyecto.ventas.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "ventas")
public class Venta implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVenta;

	private Date fecha;
	private String nombreComprador;
	private String apellidoComprador;
	private Long telefonoComprador;
	private String correoComprador;
	private String ciudadComprador;
	private String direccionComprador;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="idventa")
	private List<Pedido> pedidos;
	private Long cedulavendedor;
	/*
	 * @JoinColumn(name="cedulavendedor")
	 * 
	 * 
	 * @Transient private Vendedor vendedor;
	 * 
	 */

	public Long getCedulavendedor() {
		return cedulavendedor;
	}

	public void setCedulavendedor(Long cedulavendedor) {
		this.cedulavendedor = cedulavendedor;
	}

	public Double getTotal() {

		Double total = 0.0;
		for (Pedido item : pedidos) {
			total += item.getValorTotal();
		}
		return total;
	}

	@PrePersist
	public void prePersist() {
		this.fecha = new Date();
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Long getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Long idVenta) {
		this.idVenta = idVenta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNombreComprador() {
		return nombreComprador;
	}

	public void setNombreComprador(String nombreComprador) {
		this.nombreComprador = nombreComprador;
	}

	public String getApellidoComprador() {
		return apellidoComprador;
	}

	public void setApellidoComprador(String apellidoComprador) {
		this.apellidoComprador = apellidoComprador;
	}

	public Long getTelefonoComprador() {
		return telefonoComprador;
	}

	public void setTelefonoComprador(Long telefonoComprador) {
		this.telefonoComprador = telefonoComprador;
	}

	public String getCorreoComprador() {
		return correoComprador;
	}

	public void setCorreoComprador(String correoComprador) {
		this.correoComprador = correoComprador;
	}

	public String getCiudadComprador() {
		return ciudadComprador;
	}

	public void setCiudadComprador(String ciudadComprador) {
		this.ciudadComprador = ciudadComprador;
	}

	public String getDireccionComprador() {
		return direccionComprador;
	}

	public void setDireccionComprador(String direccionComprador) {
		this.direccionComprador = direccionComprador;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Venta)) {
			return false;
		}

		Venta vent = (Venta) obj;
		return this.idVenta != null && this.idVenta.equals(vent.getIdVenta());
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -3745549260429612381L;

}
