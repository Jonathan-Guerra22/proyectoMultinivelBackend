package edu.proyecto.seguridad.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.proyecto.seguridad.model.Usuario;
import edu.proyecto.seguridad.service.UsuarioServiceImpl;


@RestController
public class UsuariosController {

///////////////////--- Usuario
	@Autowired
	protected UsuarioServiceImpl serviceUsuario;
	
	@PostMapping("/AgregarUsuario")
	public ResponseEntity<?> crearUsuario(@RequestBody Usuario entity, BindingResult result){
		
		if(result.hasErrors()) {
			return this.validar(result);
		}
		
		Usuario entityBD = serviceUsuario.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(entityBD);
	}	
	
	@PutMapping("/DeshabilitarUsuario/{id}")
	public ResponseEntity<?> deshabilitarUsuario(@RequestBody Usuario usuario, BindingResult result, @PathVariable Long id){
		if (result.hasErrors()) {
			return this.validar(result);
		}
		
		Optional <Usuario> optional = serviceUsuario.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Usuario usua = optional.get();
		usua.setEstado(usua.getEstado());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceUsuario.save(usua));
	}
	
///////////////////--- Validacion	

	protected ResponseEntity<?> validar(BindingResult result) {
		Map<String, Object> errores = new HashMap<>();
		result.getFieldErrors().forEach(err -> {
			errores.put(err.getField(), "El atributo " + err.getField() + " " + err.getDefaultMessage());
		});
		return ResponseEntity.badRequest().body(errores);
	}
	
}
