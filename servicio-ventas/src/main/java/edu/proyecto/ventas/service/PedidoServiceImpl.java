package edu.proyecto.ventas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.proyecto.categorias.model.Producto;
import edu.proyecto.ventas.client.VentasFeignClient;
import edu.proyecto.ventas.model.Pedido;
import edu.proyecto.ventas.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService{

	@Autowired
	protected PedidoRepository repositoryPedido;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Pedido> findAll() {
		return repositoryPedido.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Pedido> findById(Long idPedido) {
		return repositoryPedido.findById(idPedido);
	}

	@Override
	public Pedido save(Pedido entity) {
		return repositoryPedido.save(entity);
	}

	@Autowired
	protected VentasFeignClient ventasfeign;
	
	@Transactional(readOnly = true)
	public Producto buscraProducto(Long idproducto) {
		return ventasfeign.listarProducto(idproducto);
	}
}