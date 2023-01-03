package edu.proyecto.usuarios.service;

import java.util.Optional;

import edu.proyecto.usuarios.model.Usuario;

public interface UsuarioService {
	
	public Iterable<Usuario> findAll();
	public Optional<Usuario> findById(Long cedula);
	public Usuario save(Usuario entity);
}
