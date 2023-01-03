package edu.proyecto.usuarios.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.proyecto.usuarios.model.Administrador;
import edu.proyecto.usuarios.repository.AdministradorRepository;

@Service
public class AdministradorServiceImpl implements AdministradorService{

	@Autowired
	protected AdministradorRepository repositoryAdmin;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Administrador> findAll() {
		return repositoryAdmin.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Administrador> findById(Long cedulaadministrador) {
		return repositoryAdmin.findById(cedulaadministrador);
	}

	@Override
	public Administrador save(Administrador entity) {
		return repositoryAdmin.save(entity);
	}

}