package com.Healthcare_AI.Healthcare.AI.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "health_reports")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HealthReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String healthData;
    private Date reportDate;
}
