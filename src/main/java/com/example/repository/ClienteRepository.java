package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.model.entity.Cliente;
import java.util.List;
import java.util.Optional;

@Repository

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
Optional<Cliente> findByTelefono(String telefono);
List<Cliente> findByNombreContainingIgnoreCase(String nombre);

}
