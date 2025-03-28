package com.Healthcare_AI.Healthcare.AI.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicationReminderRequest {
    private Long userId;
    private String medicationName;
    private LocalDateTime reminderTime;
    private String dosage;
}
