package com.example.control_lavanderia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Repository;

import com.example.control_lavanderia.model.entity.Cliente;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaAuditing
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByTelefono(String telefono);

    List<Cliente> findByNombreContainingIgnoreCase(String nombre);

}
