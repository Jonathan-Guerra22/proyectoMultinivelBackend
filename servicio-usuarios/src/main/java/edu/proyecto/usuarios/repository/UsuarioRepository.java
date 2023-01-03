package edu.proyecto.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.proyecto.usuarios.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
