package edu.proyecto.categorias.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="servicio-ventas")
public interface ProductoFeignClient {
	/*
	@GetMapping("/ListarVentas")
	public Producto listarVentas();
	*/
}
