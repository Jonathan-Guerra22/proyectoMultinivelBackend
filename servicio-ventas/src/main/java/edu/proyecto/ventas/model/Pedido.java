package edu.proyecto.ventas.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import edu.proyecto.categorias.model.Producto;


@Entity
@Table(name="pedidos")
public class Pedido implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPedido;
	
	private Long unidades;
	
	
//	@ManyToOne
//	@JsonIgnoreProperties("pedidos")
//	private Venta venta;
//	
	
	@JoinColumn(name="idproducto")
	private Long idproducto;
	
	@Transient
	private Producto producto;

	
	/*
	 * 
	 *  IdVenta INTEGER,
     *	FOREIGN KEY(IdVenta) REFERENCES ventas(IdVenta),
     *
     *	IdProducto INTEGER,
     *	FOREIGN KEY(IdProducto) REFERENCES productos(IdProducto)
	 * 
	 * */
	
	public Double getValorTotal() {
		
		return this.producto.getPrecioproducto()*this.unidades;
	}
	
	public Long getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(Long idproducto) {
		this.idproducto = idproducto;
	}
	public Producto getProducto() {
		if(this.producto==null) {
			this.producto=new Producto();
		}
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
//	public Venta getVenta() {
//		return venta;
//	}
//	public void setVenta(Venta venta) {
//		this.venta = venta;
//	}

	public Long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	public Long getUnidades() {
		return unidades;
	}
	public void setUnidades(Long unidades) {
		this.unidades = unidades;
	}
	
	
	
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof Pedido)){
			return false;
		}
		
		Pedido ped = (Pedido) obj;
		return this.getIdPedido()!=null && this.idPedido.equals(ped.getIdPedido());
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -178540597179490532L;

}
