package com.Healthcare_AI.Healthcare.AI.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Table(name = "appointment")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String doctorName;
    private LocalDateTime appointmentTime;
    private String notes;
}
