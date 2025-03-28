package com.Healthcare_AI.Healthcare.AI.controller;

import com.Healthcare_AI.Healthcare.AI.dto.AppointmentRequest;
import com.Healthcare_AI.Healthcare.AI.entity.Appointment;
import com.Healthcare_AI.Healthcare.AI.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Appointment> bookAppointment(@RequestBody AppointmentRequest request) {
        Appointment appointment = appointmentService.bookAppointment(request);
        return ResponseEntity.ok(appointment);
    }

    @CrossOrigin
    @GetMapping("/{userId}")
    public ResponseEntity<List<Appointment>> getUserAppointments(@PathVariable Long userId) {
        List<Appointment> appointments = appointmentService.getAppointmentsByUser(userId);
        return ResponseEntity.ok(appointments);
    }
}
