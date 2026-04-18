package com.example.control_lavanderia.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.control_lavanderia.model.entity.Orden;

import java.util.List;


@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {
List<Orden> findByClienteId(Long clienteId);
List<Orden> findByFechaRecibidoBetween(LocalDateTime desde, LocalDateTime hasta);

}
