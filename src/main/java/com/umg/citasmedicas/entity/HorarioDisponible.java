package com.umg.citasmedicas.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "horarios_disponibles")
@Data @NoArgsConstructor @AllArgsConstructor
public class HorarioDisponible {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;
    
    @Column(nullable = false)
    private LocalDateTime fechaHoraInicio;
    
    @Column(nullable = false)
    private LocalDateTime fechaHoraFin;
    
    private boolean disponible = true;
}