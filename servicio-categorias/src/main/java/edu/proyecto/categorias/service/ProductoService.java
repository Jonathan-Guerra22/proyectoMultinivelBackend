package edu.proyecto.categorias.service;

import java.util.Optional;

import edu.proyecto.categorias.model.Producto;

public interface ProductoService {
	
	public Iterable<Producto> findAll();
	public Optional<Producto> findById(Long idproducto);
	public Producto save(Producto entity);
	
	public void deleteById(Long idproducto);
	
}
