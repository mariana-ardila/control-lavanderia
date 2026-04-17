package com.example.control_lavanderia.service;

import com.example.model.entity.*;
import com.example.repository.OrdenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrdenService {

    private final OrdenRepository ordenRepository;
    private final ClienteService clienteService;

    public OrdenService(OrdenRepository ordenRepository, ClienteService clienteService) {
        this.ordenRepository = ordenRepository;
        this.clienteService = clienteService;
    }

    @Transactional
    public Orden crearOrden(Long clienteId, List<Prenda> prendas) {

        Cliente cliente = clienteService.obtenerPorId(clienteId);


//Validar que no se acepten más de 20 prendas en una sola orden.
        if (prendas.size() > 20) {
            throw new RuntimeException("Máximo 20 prendas por orden");
        }

        Orden orden = new Orden();
        orden.setCliente(cliente);
        orden.setFechaRecibido(LocalDateTime.now());

        //Asignar fecha de entrega: +24 horas si son menos de 5 prendas, +48 horas si son más.
        if (prendas.size() < 5) {
            orden.setFechaEntregaEstimada(LocalDateTime.now().plusHours(24));
        } else {
            orden.setFechaEntregaEstimada(LocalDateTime.now().plusHours(48));
        }

        double total = 0;
        double prendaMasBarata = Double.MAX_VALUE;

        for (Prenda prenda : prendas) {
            double precio = obtenerTarifa(prenda.getTipo());
            total += precio;

            if (precio < prendaMasBarata) {
                prendaMasBarata = precio;
            }

            prenda.setOrden(orden);
        }

        // Si el cliente tiene 50 puntos, aplicar descuento total a la prenda más barata.
        if (cliente.getPuntosLealtad() >= 50) {
            total -= prendaMasBarata;
        }

        orden.setTotal(total);
        orden.setPrendas(prendas);

        // Sumar puntos de lealtad al cliente por cada orden (1 punto por cada $10.000).
        int puntos = (int) (total / 10000);
        cliente.setPuntosLealtad(cliente.getPuntosLealtad() + puntos);

        return ordenRepository.save(orden);
    }


    //Calcular el total basado en una tarifa fija por tipo de prenda.
    private double obtenerTarifa(TipoPrenda tipo) {
        switch (tipo) {
            case CAMISA: return 5000;
            case PANTALON: return 8000;
            case VESTIDO: return 10000;
            case ROPA_INTERIOR: return 3000;
            default: return 4000;
        }
    }
}