package edu.proyecto.categorias.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.proyecto.categorias.model.Categoria;
import edu.proyecto.categorias.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	protected CategoriaRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Categoria> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Categoria> findById(Long id) {
		return repository.findById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Categoria> findByNombre(String nombre) {
		return repository.findByNombre(nombre);
	}

	@Override
	@Transactional
	public Categoria save(Categoria entity) {
		return repository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	@Override
	@Transactional
	public void deleteByNombre(String nombre) {
		repository.deleteByNombre(nombre);
	}

}