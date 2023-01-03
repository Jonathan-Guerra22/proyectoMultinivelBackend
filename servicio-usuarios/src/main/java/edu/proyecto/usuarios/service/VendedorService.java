package edu.proyecto.usuarios.service;

import java.util.List;
import java.util.Optional;

import edu.proyecto.usuarios.model.Vendedor;
import edu.proyecto.ventas.model.Venta;

public interface VendedorService {

	public Iterable<Vendedor> findAll();
	public Optional<Vendedor> findById(Long cedulavendedor);
	public Vendedor save(Vendedor entity);
	
	public Venta buscarVenta(Long id);
	public List<Venta> buscarVentaVendedor(Long cedulavendedor);
	
	
	public List<Vendedor> findByGrupo(Long grupo);
	
	public Iterable<Vendedor> buscarVentasGrupo();
}
