package edu.proyecto.categorias.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.proyecto.categorias.model.Categoria;
import edu.proyecto.categorias.model.Producto;
import edu.proyecto.categorias.service.CategoriaServiceImpl;
import edu.proyecto.categorias.service.ProductoServiceImpl;

@RestController
@CrossOrigin(origins = "*")
public class CategoriaController {

/////////////////////--- Crud Categoria
	@Autowired
	protected CategoriaServiceImpl service;
	
	@GetMapping("/Categorias")
	public ResponseEntity<?> listarCategorias(){		
		return ResponseEntity.ok().body(service.findAll());		
	}

	@GetMapping("/Categoria/{nombre}")
	public ResponseEntity<?> buscarCategoria(@PathVariable String nombre){
		return ResponseEntity.ok().body(service.findByNombre(nombre));
	}
	
	@PostMapping("/Agregarcategoria")
	public ResponseEntity<?> crearCat(@Valid @RequestBody Categoria entity, BindingResult result){
		
		if(result.hasErrors()) {
			return this.validar(result);
		}
		entity.setEstado("Activo");
		Categoria entityBD = service.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(entityBD);
	}

	@DeleteMapping("/EliminarCategoria/{nombre}")
	public ResponseEntity<?> eliminarCategoria(@PathVariable String nombre){
			
		service.deleteByNombre(nombre);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/DeshabilitarCategoria/{id}")
	public ResponseEntity<?> DeshabilitarCategoria(@RequestBody Categoria categoria, BindingResult result, @PathVariable Long id){
		if (result.hasErrors()) {
			return this.validar(result);
		}
		
		Optional <Categoria> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Categoria cate = optional.get();
		//Optional<Producto> optionalP = serviceproducto.findById();
		if(cate.getNombre().equals("1")) {
			
		}
		// Activo | Dehabilitado
		cate.setEstado(categoria.getEstado());
		
		//Iterable<Producto> productos =service.findByNombre(serviceproducto.)
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cate));
	}	
	
	
	
///////////////////--- Crud Producto
	
	@Autowired
	protected ProductoServiceImpl serviceproducto;
	
	@GetMapping("/Productos")
	public ResponseEntity<?> listarProductos(){		
		return ResponseEntity.ok().body(serviceproducto.findAll());		
	}
	@GetMapping("/Producto/{idproducto}")
	public ResponseEntity<?> listarProducto(@PathVariable Long idproducto){		
		Optional<Producto> optional = serviceproducto.findById(idproducto);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(optional.get());
	}
	
	@PostMapping("/AgregarProducto")
	public ResponseEntity<?> crearProducto( @RequestBody Producto entity, BindingResult result){
		
		if(result.hasErrors()) {
			return this.validar(result);
		}
		entity.setEstadoproducto("Habilitado");
		Producto entityBD = serviceproducto.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(entityBD);
	}
	
	
// crear con imagen
	@PostMapping
	public ResponseEntity<?> crear( @RequestBody Producto entity, BindingResult result){

		if(result.hasErrors()) {
			return this.validar(result);
		}
		entity.setEstadoproducto("Habilitado");
		Producto entityBD = serviceproducto.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(entityBD);
	}
	
	@PostMapping("/crear-producto-con-imagen")
	public ResponseEntity<?> crearConImagen( Producto producto, BindingResult result, @RequestParam MultipartFile archivo) throws IOException {
		if(!archivo.isEmpty()) {
			producto.setFotoproducto(archivo.getBytes());
		}
		
		return crear(producto, result);
	}
	
	@PutMapping("/DeshabilitarProducto/{idproducto}")
	public ResponseEntity<?> deshabilitarProducto(@RequestBody Producto producto, BindingResult result, @PathVariable Long idproducto){
		if (result.hasErrors()) {
			return this.validar(result);
		}
		
		Optional <Producto> optional = serviceproducto.findById(idproducto);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Producto prod = optional.get();
		prod.setEstadoproducto(prod.getEstadoproducto());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceproducto.save(prod));
	}
	
	@PutMapping("/editarProducto/{idproducto}")
	public ResponseEntity<?> modificarProducto(Producto producto, BindingResult result, @PathVariable Long idproducto,@RequestParam MultipartFile archivo) throws IOException{
		if (result.hasErrors()) {
			return this.validar(result);
		}
		
		Optional <Producto> optional = serviceproducto.findById(idproducto);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Producto prod = optional.get();
		prod.setNombreproducto(prod.getNombreproducto());
		if(!archivo.isEmpty()) {
			prod.setFotoproducto(archivo.getBytes());
		}else {			
			prod.setFotoproducto(prod.getFotoproducto());
		}
		//prod.setPrecioproducto(prod.getPrecioproducto());
		prod.setColorproducto(prod.getColorproducto());
		prod.setTallaproducto(prod.getTallaproducto());
		prod.setDescripcionproducto(prod.getDescripcionproducto());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceproducto.save(prod));
	}
	
	
// funciona
	@PutMapping("/Subirimagen/{id}")
	public ResponseEntity<?> subirImagen(@Valid Producto producto, BindingResult result, @PathVariable Long id ,@RequestParam MultipartFile archivo) throws IOException{
		
		if(result.hasErrors()) {
			return this.validar(result);
		}
		
		Optional<Producto> optional = serviceproducto.findById(id);
		if(!optional.isPresent()){
			return ResponseEntity.notFound().build();
		}
		
		Producto prod = optional.get();
		if(!archivo.isEmpty()) {
			prod.setFotoproducto(archivo.getBytes());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceproducto.save(prod)); 
	}
	
	@GetMapping("/verImagen/img/{id}")
	public ResponseEntity<?> verImagen(@PathVariable Long id){
		Optional<Producto> optional = serviceproducto.findById(id);
		if(!optional.isPresent() || optional.get().getFotoproducto()==null) {
			return ResponseEntity.notFound().build();
		}
		Resource img = new ByteArrayResource(optional.get().getFotoproducto());
		
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(img);
	}
	
	
///////////////////--- Validacion	
	
	protected ResponseEntity<?> validar(BindingResult result){
		Map<String, Object> errores = new HashMap<>();
		result.getFieldErrors().forEach(err ->{
			errores.put(err.getField(),"El atributo "+err.getField()+" "+err.getDefaultMessage());
		});
		return ResponseEntity.badRequest().body(errores);
	}
}