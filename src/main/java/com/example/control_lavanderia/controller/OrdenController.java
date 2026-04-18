package com.example.control_lavanderia.controller;

import com.example.control_lavanderia.model.entity.Orden;
import com.example.control_lavanderia.model.entity.Prenda;
import com.example.control_lavanderia.service.OrdenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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