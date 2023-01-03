package edu.proyecto.usuarios.service;

import java.util.Optional;

import edu.proyecto.usuarios.model.Rol;

public interface RolService {

	public Iterable<Rol> findAll();
	public Optional<Rol> findById(Long idRol);
}
