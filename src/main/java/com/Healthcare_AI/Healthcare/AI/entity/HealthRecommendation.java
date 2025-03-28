package com.Healthcare_AI.Healthcare.AI.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "health_recommendations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HealthRecommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String recommendation;
}
