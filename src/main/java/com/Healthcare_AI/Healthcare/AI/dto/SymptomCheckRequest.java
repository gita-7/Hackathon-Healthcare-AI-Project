package com.Healthcare_AI.Healthcare.AI.dto;

import lombok.Data;

@Data
public class SymptomCheckRequest {
    private Long userId;
    private String symptoms;
}
