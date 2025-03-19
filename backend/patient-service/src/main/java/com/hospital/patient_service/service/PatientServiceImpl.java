package com.hospital.patient_service.service;

import com.hospital.patient_service.dto.PatientDTO;
import com.hospital.patient_service.entity.Patient;
import com.hospital.patient_service.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    @Override
    public PatientDTO createPatient(PatientDTO patientDTO){
        Patient patient=Patient.builder()
                .firstName(patientDTO.getFirstName())
                .lastName(patientDTO.getLastName())
                .email(patientDTO.getEmail())
                .age(patientDTO.getAge())
                .gender(patientDTO.getGender())
                .address(patientDTO.getAddress())
                .admissionDate(patientDTO.getAdmissionDate())
                .build();
        Patient savedPatient =patientRepository.save(patient);
        return convertToDTO(savedPatient) ;
    }

    @Override
    public List<PatientDTO> getAllPatients(){
        return patientRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PatientDTO getPatientById(Long id){
        return patientRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }


    private PatientDTO convertToDTO(Patient patient){
        return PatientDTO.builder()
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .email(patient.getEmail())
                .age(patient.getAge())
                .gender(patient.getGender())
                .address(patient.getAddress())
                .admissionDate(patient.getAdmissionDate())
                .build();
    }
}
