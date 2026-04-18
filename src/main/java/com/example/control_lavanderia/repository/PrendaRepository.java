package com.example.control_lavanderia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.control_lavanderia.model.entity.Prenda;
import com.example.control_lavanderia.model.entity.TipoPrenda;

import java.util.List;

@Repository
public interface PrendaRepository extends JpaRepository<Prenda, Long> {
List<Prenda> findByOrdenId(Long ordenId);
List<Prenda> findByTipo(TipoPrenda tipo);
}
