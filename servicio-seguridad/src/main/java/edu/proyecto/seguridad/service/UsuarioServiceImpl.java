package edu.proyecto.seguridad.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.proyecto.seguridad.model.Usuario;
import edu.proyecto.seguridad.repository.UsuarioRepository;


@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	protected UsuarioRepository repositoryUsuario;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Usuario> findAll() {
		return repositoryUsuario.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findById(Long cedula) {
		return repositoryUsuario.findById(cedula);
	}

	@Override
	public Usuario save(Usuario entity) {
		return repositoryUsuario.save(entity);
	}

}
