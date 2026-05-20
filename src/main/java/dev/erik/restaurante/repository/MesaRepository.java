package dev.erik.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.erik.restaurante.entity.Mesa;

public interface MesaRepository extends JpaRepository<Mesa, Long> {

}
