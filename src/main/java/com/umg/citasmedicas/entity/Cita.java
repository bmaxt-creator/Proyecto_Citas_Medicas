package com.umg.citasmedicas.entity;

import com.umg.citasmedicas.enums.EstadoCita;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "citas")
@Data @NoArgsConstructor @AllArgsConstructor
public class Cita {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Usuario paciente; 
    
    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;
    
    @Column(nullable = false)
    private LocalDateTime fechaHora;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoCita estado; // Enum: PENDIENTE, COMPLETADA, CANCELADA
    
    private String motivo;
    
    @Column(columnDefinition = "TEXT")
    private String diagnostico;
    
    // --- CAMPOS DE AUDITORÍA (Ahora dentro de la clase) ---
    @org.hibernate.annotations.CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime fechaCreacion;

    @org.hibernate.annotations.UpdateTimestamp
    private LocalDateTime fechaActualizacion;
}