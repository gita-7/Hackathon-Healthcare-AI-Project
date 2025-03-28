package com.Healthcare_AI.Healthcare.AI.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentRequest {
    private Long userId;
    private String doctorName;
    private LocalDateTime appointmentTime;
    private String notes;
}
