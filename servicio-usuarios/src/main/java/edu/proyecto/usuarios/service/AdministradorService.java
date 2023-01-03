package edu.proyecto.usuarios.service;

import java.util.Optional;

import edu.proyecto.usuarios.model.Administrador;

public interface AdministradorService {

	public Iterable<Administrador> findAll();
	public Optional<Administrador> findById(Long cedulaadministrador);
	public Administrador save(Administrador entity);
	
}