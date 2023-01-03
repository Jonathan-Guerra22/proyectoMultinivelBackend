package edu.proyecto.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.proyecto.ventas.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
