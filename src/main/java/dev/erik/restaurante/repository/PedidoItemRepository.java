package dev.erik.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.erik.restaurante.entity.PedidoItem;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {
    
}
