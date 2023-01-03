package edu.proyecto.ventas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.proyecto.ventas.model.Venta;
import edu.proyecto.ventas.repository.VentaRepository;

@Service
public class VentaServiceImpl implements VentaService{

	@Autowired
	protected VentaRepository repositoryVenta;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Venta> findAll() {
		return repositoryVenta.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Venta> findById(Long idVenta) {
		return repositoryVenta.findById(idVenta);
	}

	@Override
	public Venta save(Venta entity) {
		return repositoryVenta.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Venta> findByCedulavendedor(Long cedulavendedor) {
		return repositoryVenta.findByCedulavendedor(cedulavendedor);
	}


}