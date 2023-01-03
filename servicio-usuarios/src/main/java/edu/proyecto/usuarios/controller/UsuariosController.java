package edu.proyecto.usuarios.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.proyecto.usuarios.client.UsuariosFeignClient;
import edu.proyecto.usuarios.model.Administrador;
import edu.proyecto.usuarios.model.Rol;
import edu.proyecto.usuarios.model.Usuario;
import edu.proyecto.usuarios.model.Vendedor;
import edu.proyecto.usuarios.service.AdministradorServiceImpl;
import edu.proyecto.usuarios.service.RolServiceImpl;
import edu.proyecto.usuarios.service.UsuarioServiceImpl;
import edu.proyecto.usuarios.service.VendedorServiceImpl;


@RestController
@CrossOrigin(origins = "*")
public class UsuariosController {
	
///////////////////--- Usuario
	@Autowired
	protected UsuarioServiceImpl serviceUsuario;
	
	@GetMapping("/Usuarios")
	public ResponseEntity<?> listarUsuarios(){		
		return ResponseEntity.ok().body(serviceUsuario.findAll());		
	}
	
	@PostMapping("/AgregarUsuario")
	public ResponseEntity<?> crearUsuario(@RequestBody Usuario entity, BindingResult result){
		
		if(result.hasErrors()) {
			return this.validar(result);
		}
		entity.setEstado("Activo");
		Usuario entityBD = serviceUsuario.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(entityBD);
	}	

	@PutMapping("/ModificarUsuario/{id}")
	public ResponseEntity<?> modificarUsuario(@RequestBody Usuario usuario, BindingResult result, @PathVariable Long id){
		if (result.hasErrors()) {
			return this.validar(result);
		}
		
		Optional <Usuario> optional = serviceUsuario.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Usuario usu = optional.get();
		usu.setNomusuario(usu.getNomusuario());
		usu.setCorreo(usu.getCorreo());
		usu.setContrasena(usu.getContrasena());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceUsuario.save(usu));
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
	
///////////////////--- Vendedor
	
	@Autowired
	protected VendedorServiceImpl serviceVendedor;
	
	@Autowired
	protected UsuariosFeignClient clientUsuarioFeign;
	
	@GetMapping("/Vendedores")
	public ResponseEntity<?> listarVendedores(){
		
		Iterable<Vendedor> ven = serviceVendedor.findAll();
		
		for(Vendedor vendedor : ven) {
				vendedor.setVentas(clientUsuarioFeign.buscarPorVendedor(vendedor.getCedulavendedor()));
		}
		
		return ResponseEntity.ok().body(ven);
	}
	
	
	@GetMapping("/Vendedor/{id}")
	public ResponseEntity<?> listarVendedores(@PathVariable Long id){
		
		Optional<Vendedor> optional = serviceVendedor.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Iterable<Vendedor> ven = serviceVendedor.findAll();
		
		for(Vendedor vendedor : ven) {
				vendedor.setVentas(clientUsuarioFeign.buscarPorVendedor(vendedor.getCedulavendedor()));
		}
		return ResponseEntity.ok(optional.get());
	}
	
	@Autowired
	protected RolServiceImpl s;
	
	@PostMapping("/AgregarVendedor")
	public ResponseEntity<?> crearVendedor(@RequestBody Vendedor entity, BindingResult result){		
		
		if(result.hasErrors()) {
			return this.validar(result);
		}
		
		// Generacion de Rol Automatico
		
		Optional <Vendedor> optionalV = serviceVendedor.findById(entity.getVendedoreAfiliador().getCedulavendedor());
		Vendedor venAuto = optionalV.get();
		if(entity.getVendedoreAfiliador().getCedulavendedor()==1) {			
			Optional <Rol> optional = s.findById((long)1);
			Rol rolw = optional.get();
			rolw.setIdRol((long)1);
			List<Rol> rol=new ArrayList<>();
			rol.add(0, rolw);
			entity.setRoles(rol);
		}else if(entity.getVendedoreAfiliador()!=null && venAuto.getRoles().get(0).getIdRol()<3){
			Long nivelauto= (long)1;
			
			//System.out.println("Aca entro esto  segundo "+venAuto.getRoles().get(0).getIdRol());
			
			nivelauto=nivelauto+venAuto.getRoles().get(0).getIdRol();
			
			Optional <Rol> optional = s.findById(nivelauto);
			
			Rol rolw = optional.get();
			rolw.setIdRol(nivelauto);
			List<Rol> rol=new ArrayList<>();
			rol.add(0, rolw);
			entity.setRoles(rol);			
		}else {
			return ResponseEntity.ok("El id Automatico para el usuario "+entity.getNombreVendedor()+" no se le puede asignar porque exede el limite de Niveles existentes");
		}
		entity.setEstadoVendedor("Activo");
		Vendedor entityBD = serviceVendedor.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(entityBD);
	}
	
	@PutMapping("/ModificarVendedor/{id}")
	public ResponseEntity<?> modificarVendedor(@RequestBody Vendedor vendedor, BindingResult result, @PathVariable Long id){
		if (result.hasErrors()) {
			return this.validar(result);
		}
		
		Optional <Vendedor> optional = serviceVendedor.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Vendedor ven = optional.get();
		ven.setCelularVendedor(vendedor.getCelularVendedor());
		ven.setCiudadVendedor(vendedor.getCiudadVendedor());
		ven.setDireccion(vendedor.getDireccion());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceVendedor.save(ven));
	}
	
	@PutMapping("/DeshabilitarVendedor/{id}")
	public ResponseEntity<?> deshabilitarVendedor(@RequestBody Vendedor vendedor, BindingResult result, @PathVariable Long id){
		if (result.hasErrors()) {
			return this.validar(result);
		}
		
		Optional <Vendedor> optional = serviceVendedor.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Vendedor ven = optional.get();
		ven.setEstadoVendedor(vendedor.getEstadoVendedor());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceVendedor.save(ven));
	}
	
	@GetMapping("/VentasGrupo/{id}")
	public ResponseEntity<?> buscarGrupo(@PathVariable Long id){
		
		List<Vendedor> ven = serviceVendedor.findByGrupo(id);
		
		ArrayList<Object> a = new ArrayList<>();
		
		for(Vendedor vendedor : ven) {	
			vendedor.setVentas(clientUsuarioFeign.buscarPorVendedor(vendedor.getCedulavendedor()));
			
			a.add(clientUsuarioFeign.buscarPorVendedor(vendedor.getCedulavendedor()));
		}
		
		return ResponseEntity.ok(a);
		//return ResponseEntity.ok().body(serviceVendedor.findByGrupo(id));
	}
	
	
	
///////////////////--- Admin
	
	@Autowired
	protected AdministradorServiceImpl serviceAdministrador;
	
	@PostMapping("/AgregarAdministrador")
	public ResponseEntity<?> crearAdministrador(@RequestBody Administrador entity, BindingResult result){
		
		if(result.hasErrors()) {
			return this.validar(result);
		}
		entity.setEstado("Activo");
		Administrador entityBD = serviceAdministrador.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(entityBD);
	}
	
	@PutMapping("/ModificarAdministrador/{id}")
	public ResponseEntity<?> modificarAdministrador(@RequestBody Administrador administrador, BindingResult result, @PathVariable Long id){
		if (result.hasErrors()) {
			return this.validar(result);
		}
		
		Optional <Administrador> optional = serviceAdministrador.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Administrador admin = optional.get();
		//admin.getUsuario().setCorreo(administrador.getUsuario().getContrasena());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceAdministrador.save(admin));
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
