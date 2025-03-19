package com.hospital.patient_service.controller;

import com.hospital.patient_service.dto.PatientDTO;
import com.hospital.patient_service.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/patients")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientDTO> createPatient(@RequestBody PatientDTO patientDTO){
        return new ResponseEntity<>(patientService.createPatient(patientDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public List<PatientDTO> getAllPatients(){return patientService.getAllPatients();}

    @GetMapping("/{id}")
    public PatientDTO getPatientById(@PathVariable Long id){
        return patientService.getPatientById(id);
    }


}
