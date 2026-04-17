package com.example.control_lavanderia.service;


import com.example.model.entity.Prenda;
import com.example.model.entity.TipoPrenda;
import com.example.repository.PrendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrendaService {

    private final PrendaRepository prendaRepository;

    public PrendaService(PrendaRepository prendaRepository) {
        this.prendaRepository = prendaRepository;
    }

    public List<Prenda> obtenerPorOrden(Long ordenId) {
        return prendaRepository.findByOrdenId(ordenId);
    }

    public List<Prenda> obtenerPorTipo(TipoPrenda tipo) {
        return prendaRepository.findByTipo(tipo);
    }
}