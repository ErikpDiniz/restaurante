package dev.erik.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.erik.restaurante.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
