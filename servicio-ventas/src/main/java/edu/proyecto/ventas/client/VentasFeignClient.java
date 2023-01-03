package edu.proyecto.ventas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.proyecto.categorias.model.Producto;

@FeignClient(name="servicio-categorias")
public interface VentasFeignClient {

	@GetMapping("/Producto/{idproducto}")
	public Producto listarProducto(@PathVariable Long idproducto);
	
	
	
}
