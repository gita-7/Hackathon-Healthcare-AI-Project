package com.Healthcare_AI.Healthcare.AI.repository;

import com.Healthcare_AI.Healthcare.AI.entity.HealthReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HealthReportRepository extends JpaRepository<HealthReport, Long> {
    List<HealthReport> findByUserId(Long userID);
}
