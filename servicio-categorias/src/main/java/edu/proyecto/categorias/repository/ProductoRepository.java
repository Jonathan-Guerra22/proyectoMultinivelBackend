package edu.proyecto.categorias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.proyecto.categorias.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
