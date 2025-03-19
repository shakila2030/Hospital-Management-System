package com.hospital.appointment_service.dto;

import com.hospital.appointment_service.entity.Appointment;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentDTO {
    private Long id;
    private LocalDate date;
    private LocalTime time;
    private Long patientId;
    private Long doctorId;


    public AppointmentDTO(Appointment appointment) {
        this.id = appointment.getId();
        this.patientId = appointment.getPatientId();
        this.doctorId = appointment.getDoctorId();
        this.date = appointment.getDate();
        this.time=appointment.getTime();
    }
}

