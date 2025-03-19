package com.hospital.appointment_service.dto;

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
}

