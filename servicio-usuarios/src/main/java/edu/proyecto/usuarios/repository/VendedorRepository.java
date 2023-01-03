package edu.proyecto.usuarios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.proyecto.usuarios.model.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long>{
	
	public List<Vendedor> findByGrupo(Long grupo);
	
	@Query(value="select grupo from vendedores",nativeQuery=true)
	Iterable<Vendedor> ventasGrupo(); 
}
