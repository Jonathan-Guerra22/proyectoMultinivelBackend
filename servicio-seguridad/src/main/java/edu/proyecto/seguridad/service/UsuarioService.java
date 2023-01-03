package edu.proyecto.seguridad.service;

import java.util.Optional;

import edu.proyecto.seguridad.model.Usuario;

public interface UsuarioService {
	
	public Iterable<Usuario> findAll();
	public Optional<Usuario> findById(Long cedula);
	public Usuario save(Usuario entity);
}
