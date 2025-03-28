package com.Healthcare_AI.Healthcare.AI.controller;

import com.Healthcare_AI.Healthcare.AI.dto.MedicationReminderRequest;
import com.Healthcare_AI.Healthcare.AI.entity.MedicationReminder;
import com.Healthcare_AI.Healthcare.AI.service.MedicationReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medication-reminders")
public class MedicationReminderController {
    @Autowired
    private MedicationReminderService medicationReminderService;

    @CrossOrigin
    @PostMapping
    public ResponseEntity<MedicationReminder> setMedicationReminder(@RequestBody MedicationReminderRequest request)
    {
        MedicationReminder reminders = medicationReminderService.setMedicationReminder(request);
        return ResponseEntity.ok(reminders);
    }
}
