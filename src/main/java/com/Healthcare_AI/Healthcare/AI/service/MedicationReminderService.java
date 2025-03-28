package com.Healthcare_AI.Healthcare.AI.service;

import com.Healthcare_AI.Healthcare.AI.dto.MedicationReminderRequest;
import com.Healthcare_AI.Healthcare.AI.entity.MedicationReminder;
import com.Healthcare_AI.Healthcare.AI.repository.MedicationReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationReminderService {
    @Autowired
    private MedicationReminderRepository medicationReminderRepository;

    public MedicationReminder setMedicationReminder(MedicationReminderRequest request) {
        MedicationReminder reminder = MedicationReminder.builder()
                .userId(request.getUserId())
                .medicationName(request.getMedicationName())
                .reminderTime(request.getReminderTime())
                .dosage(request.getDosage())
                .build();
        return medicationReminderRepository.save(reminder);
    }

    public List<MedicationReminder> getRemindersByUser(Long userId) {
        return medicationReminderRepository.findByUserId(userId);
    }
}
