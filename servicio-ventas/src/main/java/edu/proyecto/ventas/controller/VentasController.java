package edu.proyecto.ventas.controller;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.proyecto.ventas.client.VentasFeignClient;
import edu.proyecto.ventas.model.Pedido;
import edu.proyecto.ventas.model.Venta;
import edu.proyecto.ventas.service.PedidoServiceImpl;
import edu.proyecto.ventas.service.VentaServiceImpl;

@RestController
@CrossOrigin(origins = "*")
public class VentasController {

	
///////////////////---Venta 
	
	@Autowired
	protected VentaServiceImpl serviceVenta;
	
	@Autowired
	protected VentasFeignClient clientVentaFeign;
	
	
	@GetMapping("/ListarVentas")
	public ResponseEntity<?> listarVentas(){
		
		Iterable<Venta> ventas = serviceVenta.findAll();
		
		for(Venta venta : ventas) {
			
			for(Pedido pedido:venta.getPedidos()) {
				pedido.setProducto(clientVentaFeign.listarProducto(pedido.getIdproducto()));
			}
		}
		
		return ResponseEntity.ok().body(ventas);
	}
	
	@GetMapping("/ListarVentasCCVendedor/{cedula}")
	public ResponseEntity<?> buscarPorVendedor(@PathVariable Long cedula){
		Iterable<Venta> ventas = serviceVenta.findByCedulavendedor(cedula);
		
		for(Venta venta : ventas) {
			
			for(Pedido pedido:venta.getPedidos()) {
				pedido.setProducto(clientVentaFeign.listarProducto(pedido.getIdproducto()));
			}
		}
		return ResponseEntity.ok().body(ventas);
		//return ResponseEntity.ok().body(serviceVenta.findByCedulavendedor(cedula));
	}
	
	@GetMapping("/Venta/{id}")
	public ResponseEntity<?> listarVenta(@PathVariable Long id){		
		Optional<Venta> optional = serviceVenta.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Iterable<Venta> ventas = serviceVenta.findAll();
		
		for(Venta venta : ventas) {
			
			for(Pedido pedido:venta.getPedidos()) {
				pedido.setProducto(clientVentaFeign.listarProducto(pedido.getIdproducto()));
			}
		}
		return ResponseEntity.ok(optional.get());
	}
	
/*
	 
	@GetMapping("/ListarVentasUsuario/{cedula}")
	public ResponseEntity<?> listarVentasUsuario(@PathVariable Long cedula){
	
			
		return ResponseEntity.ok().body(serviceVenta.findById(cedula));
	}
	
*/
	
	@PostMapping("/CrearVenta")
	public ResponseEntity<?> crearVenta(@RequestBody Venta entity, BindingResult result){
		
		if(result.hasErrors()) {
			return this.validar(result);
		}
		
		Venta entityBD = serviceVenta.save(entity);
//		for(Pedido pedido: entity.getPedidos()) {
//			pedido.setProducto(clientVentaFeign.listarProducto(pedido.getIdPedido()));
//		}
		return ResponseEntity.status(HttpStatus.CREATED).body(entityBD);
	}
	
	
///////////////////--- Pedido

	@Autowired
	protected PedidoServiceImpl servicePedido;
	
	
	@GetMapping("/ListarPedidos")
	public ResponseEntity<?> listarPedidos(){	
		
		Iterable<Pedido> pedi = servicePedido.findAll();
		
		for(Pedido pedido:pedi) {
			pedido.setProducto(clientVentaFeign.listarProducto(pedido.getIdproducto()));
		}
		
		return ResponseEntity.ok().body(pedi);
	}
	
	@PostMapping("/CrearPedido")
	public ResponseEntity<?> crearPedido(@RequestBody Pedido entity, BindingResult result){
		
		if(result.hasErrors()) {
			return this.validar(result);
		}
		
		Pedido entityBD = servicePedido.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(entityBD);
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
