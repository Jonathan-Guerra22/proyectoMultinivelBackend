package edu.proyecto.categorias.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.proyecto.categorias.model.Producto;
import edu.proyecto.categorias.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	protected ProductoRepository repositoryp;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Producto> findAll() {
		return repositoryp.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Producto> findById(Long idproducto) {
		return repositoryp.findById(idproducto);
	}

	@Override
	@Transactional
	public Producto save(Producto entity) {
		return repositoryp.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long idproducto) {
		repositoryp.deleteById(idproducto);
	}

}
