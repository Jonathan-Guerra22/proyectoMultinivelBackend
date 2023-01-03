package edu.proyecto.seguridad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.proyecto.seguridad.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
