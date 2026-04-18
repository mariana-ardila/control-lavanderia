package com.example.control_lavanderia.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "prendas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Prenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoPrenda tipo;

    @Column(nullable = false, length = 50)
    private String color;

    private String instruccionesEspeciales;

    @ManyToOne
    @JoinColumn(name = "orden_id", nullable = false)
    private Orden orden;
}