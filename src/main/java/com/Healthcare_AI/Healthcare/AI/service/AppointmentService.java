package com.Healthcare_AI.Healthcare.AI.service;

import com.Healthcare_AI.Healthcare.AI.dto.AppointmentRequest;
import com.Healthcare_AI.Healthcare.AI.entity.Appointment;
import com.Healthcare_AI.Healthcare.AI.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment bookAppointment(AppointmentRequest request) {
        Appointment appointment = Appointment.builder()
                .userId(request.getUserId())
                .doctorName(request.getDoctorName())
                .appointmentTime(request.getAppointmentTime())
                .notes(request.getNotes())
                .build();
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAppointmentsByUser(Long userId) {
        return appointmentRepository.findByUserId(userId);
    }
}
