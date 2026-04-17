package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.entity.Prenda;
import com.example.model.entity.TipoPrenda;
import java.util.List;

@Repository
public interface PrendaRepository extends JpaRepository<Prenda, Long> {
List<Prenda> findByOrdenId(Long ordenId);
List<Prenda> findByTipo(TipoPrenda tipo);
}
