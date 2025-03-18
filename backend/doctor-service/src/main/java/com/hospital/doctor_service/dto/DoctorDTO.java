package com.hospital.doctor_service.dto;

import jakarta.persistence.Entity;
import lombok.*;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {
    private Long id;
    private String name;
    private String specialization;
    private String email;
    private String phone;
}