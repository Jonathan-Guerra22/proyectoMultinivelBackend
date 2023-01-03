package edu.proyecto.ventas.service;

import java.util.Optional;


import edu.proyecto.ventas.model.Venta;

public interface VentaService {
	
	public Iterable<Venta> findAll();
	public Optional<Venta> findById(Long idVenta);
	public Venta save(Venta entity);
	
	public Iterable<Venta> findByCedulavendedor(Long cedulavendedor);

}
