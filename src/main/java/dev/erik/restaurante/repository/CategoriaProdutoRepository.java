package dev.erik.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.erik.restaurante.entity.CategoriaProduto;

public interface CategoriaProdutoRepository extends JpaRepository<CategoriaProduto, Long> {

}
