package com.hospital.patient_service.repository;

import com.hospital.patient_service.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
