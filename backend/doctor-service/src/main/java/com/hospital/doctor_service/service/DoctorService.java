package com.hospital.doctor_service.service;

import com.hospital.doctor_service.dto.DoctorDTO;
import com.hospital.doctor_service.entity.Doctor;

import java.util.List;
import java.util.stream.Collectors;

public interface DoctorService {



     List<DoctorDTO> getAllDoctors();

     DoctorDTO getDoctorById(Long id);

     DoctorDTO addDoctor(DoctorDTO doctorDTO) ;

     DoctorDTO updateDoctor(Long id, DoctorDTO doctorDTO);

     void deleteDoctor(Long id);
}
