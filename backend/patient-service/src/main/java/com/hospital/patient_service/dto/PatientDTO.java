package com.hospital.patient_service.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private int age;

    private String gender;

    private String address;

    private LocalDate admissionDate;
}
