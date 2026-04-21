package com.example.control_lavanderia.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.control_lavanderia.model.entity.Orden;
import com.example.control_lavanderia.service.OrdenService;


import java.util.List;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenController {

    private final OrdenService ordenService;

    public OrdenController(OrdenService ordenService) {
        this.ordenService = ordenService;
    }

    @PostMapping
    public ResponseEntity<Orden> crear(@RequestBody Orden orden) {
        Orden nuevaOrden = ordenService.crearOrden(orden.getCliente().getId(), orden.getPrendas());
        return ResponseEntity.ok(nuevaOrden);
    }

    @GetMapping
    public ResponseEntity<List<Orden>> listar() {
        return ResponseEntity.ok(ordenService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orden> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(ordenService.buscarPorId(id));
    }
}