package edu.proyecto.categorias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.proyecto.categorias.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	public Iterable<Categoria> findByNombre(String nombre);
	public void deleteByNombre(String nombre);
	
}
