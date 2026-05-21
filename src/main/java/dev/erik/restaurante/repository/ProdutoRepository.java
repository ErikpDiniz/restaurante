package dev.erik.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.erik.restaurante.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
