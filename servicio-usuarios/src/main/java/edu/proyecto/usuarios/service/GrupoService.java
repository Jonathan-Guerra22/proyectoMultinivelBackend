package edu.proyecto.usuarios.service;

import java.util.Optional;

import edu.proyecto.usuarios.model.Grupo;

public interface GrupoService {
	public Iterable<Grupo> findAll();
	public Optional<Grupo> findById(Long id);
	public Grupo save(Grupo entity);
}
