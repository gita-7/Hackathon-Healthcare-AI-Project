package com.Healthcare_AI.Healthcare.AI.repository;

import com.Healthcare_AI.Healthcare.AI.entity.HealthRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HealthRecommendationRepository extends JpaRepository<HealthRecommendation, Long> {
    List<HealthRecommendation> findByUserId(Long userID);
}
