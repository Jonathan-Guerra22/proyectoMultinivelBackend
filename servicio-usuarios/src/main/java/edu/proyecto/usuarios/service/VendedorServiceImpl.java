package edu.proyecto.usuarios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.proyecto.usuarios.client.UsuariosFeignClient;
import edu.proyecto.usuarios.model.Vendedor;
import edu.proyecto.usuarios.repository.VendedorRepository;
import edu.proyecto.ventas.model.Venta;

@Service
public class VendedorServiceImpl implements VendedorService{

	@Autowired
	protected VendedorRepository repositoryRepo;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Vendedor> findAll() {
		return repositoryRepo.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Vendedor> findById(Long cedulavendedor) {
		return repositoryRepo.findById(cedulavendedor);
	}

	@Override
	public Vendedor save(Vendedor entity) {
		return repositoryRepo.save(entity);
	}
	
	
	@Autowired
	protected UsuariosFeignClient usuariosFeignClient;

	@Override
	@Transactional(readOnly = true)
	public Venta buscarVenta(Long id) {
		return usuariosFeignClient.listarVenta(id);
	}
	@Override
	@Transactional(readOnly = true)
	public List<Venta> buscarVentaVendedor(Long cedulavendedor) {
		return usuariosFeignClient.buscarPorVendedor(cedulavendedor);
	}
	@Override
	@Transactional(readOnly = true)
	public List<Vendedor> findByGrupo(Long grupo) {
		return repositoryRepo.findByGrupo(grupo);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Vendedor> buscarVentasGrupo() {
		return repositoryRepo.ventasGrupo();
	}

	
}
