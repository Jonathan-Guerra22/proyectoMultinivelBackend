package edu.proyecto.categorias.service;

import java.util.Optional;

import edu.proyecto.categorias.model.Categoria;

public interface CategoriaService{

	public Iterable<Categoria> findAll();
	
	public Optional<Categoria> findById(Long id);
	public Iterable<Categoria> findByNombre(String nombre);
	
	public Categoria save(Categoria entity);
	public void deleteById(Long id);
	public void deleteByNombre(String nombre);
}
