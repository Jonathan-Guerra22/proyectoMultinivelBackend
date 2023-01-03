package edu.proyecto.usuarios.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.proyecto.usuarios.model.Rol;
import edu.proyecto.usuarios.repository.RolRepository;

@Service
public class RolServiceImpl implements RolService{

	@Autowired
	protected RolRepository repositoryRol;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Rol> findAll() {
		return repositoryRol.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Rol> findById(Long idRol) {
		return repositoryRol.findById(idRol);
	}

}
