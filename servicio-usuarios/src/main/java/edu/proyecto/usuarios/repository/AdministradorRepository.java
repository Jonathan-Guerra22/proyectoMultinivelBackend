package edu.proyecto.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.proyecto.usuarios.model.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long>{

}
