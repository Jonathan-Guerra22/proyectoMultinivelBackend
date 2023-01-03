package edu.proyecto.ventas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.proyecto.ventas.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long>{
	
	public Iterable<Venta> findByCedulavendedor(Long cedulavendedor);
	
}
