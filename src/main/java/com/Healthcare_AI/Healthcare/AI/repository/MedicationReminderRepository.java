package com.Healthcare_AI.Healthcare.AI.repository;

import com.Healthcare_AI.Healthcare.AI.entity.MedicationReminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicationReminderRepository extends JpaRepository<MedicationReminder, Long> {
    List<MedicationReminder> findByUserId(Long userId);
}
