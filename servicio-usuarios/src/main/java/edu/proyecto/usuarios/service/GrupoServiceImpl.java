package edu.proyecto.usuarios.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.proyecto.usuarios.model.Grupo;
import edu.proyecto.usuarios.repository.GruposRespository;

@Service
public class GrupoServiceImpl implements GrupoService{

	@Autowired
	protected GruposRespository repo;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Grupo> findAll() {
		return repo.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Grupo> findById(Long id) {
		return repo.findById(id);
	}

	@Override
	public Grupo save(Grupo entity) {
		return repo.save(entity);
	}

}
