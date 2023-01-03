package edu.proyecto.usuarios.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.proyecto.ventas.model.Venta;

@FeignClient(name="servicio-ventas")
public interface UsuariosFeignClient {
	
	@GetMapping("/Venta/{id}")
	public Venta listarVenta(@PathVariable Long id);
	
	
	@GetMapping("/ListarVentasCCVendedor/{cedulavendedor}")
	public List<Venta> buscarPorVendedor(@PathVariable Long cedulavendedor);
}
