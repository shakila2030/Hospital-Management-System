package com.hospital.appointment_service.service;

import com.hospital.appointment_service.dto.AppointmentDTO;

import java.util.List;

public interface AppointmentService {
    AppointmentDTO createAppointment(AppointmentDTO appointmentDTO);
    AppointmentDTO getAppointmentById(Long id);
    List<AppointmentDTO> getAppointmentsByPatientId(Long patientId);
    void deleteAppointment(Long id);
}
