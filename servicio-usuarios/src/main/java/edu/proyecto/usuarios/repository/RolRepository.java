package edu.proyecto.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.proyecto.usuarios.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Long>{

}
