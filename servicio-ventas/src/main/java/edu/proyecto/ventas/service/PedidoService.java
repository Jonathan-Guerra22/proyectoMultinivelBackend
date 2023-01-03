package edu.proyecto.ventas.service;

import java.util.Optional;

import edu.proyecto.categorias.model.Producto;
import edu.proyecto.ventas.model.Pedido;

public interface PedidoService {
	
	public Iterable<Pedido> findAll();
	public Optional<Pedido> findById(Long idPedido);
	public Pedido save(Pedido entity);
	
	public Producto buscraProducto(Long idproducto);
}
