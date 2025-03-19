package com.hospital.appointment_service.service;

import com.hospital.appointment_service.client.DoctorClient;
import com.hospital.appointment_service.client.PatientClient;
import com.hospital.appointment_service.dto.AppointmentDTO;
import com.hospital.appointment_service.dto.DoctorDTO;
import com.hospital.appointment_service.dto.PatientDTO;
import com.hospital.appointment_service.entity.Appointment;
import com.hospital.appointment_service.exception.ResourceNotFoundException;
import com.hospital.appointment_service.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientClient patientClient;
    private final DoctorClient doctorClient;

    @Override
    public AppointmentDTO createAppointment(AppointmentDTO appointmentDTO) {
        // Fetch patient and doctor details
        PatientDTO patient = patientClient.getPatientById(appointmentDTO.getPatientId());
        DoctorDTO doctor = doctorClient.getDoctorById(appointmentDTO.getDoctorId());

        if (patient == null || doctor == null) {
            throw new RuntimeException("Patient or Doctor not found");
        }

        Appointment appointment = new Appointment();
        appointment.setPatientId(appointmentDTO.getPatientId());
        appointment.setDoctorId(appointmentDTO.getDoctorId());
        appointment.setDate(appointmentDTO.getDate());
        appointment.setTime(appointmentDTO.getTime());

        appointment = appointmentRepository.save(appointment);
        return new AppointmentDTO(appointment);
    }

    @Override
    public AppointmentDTO getAppointmentById(Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow();
        return new AppointmentDTO(appointment);
    }



    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    private AppointmentDTO convertToDTO(Appointment appointment) {
        return AppointmentDTO.builder()
                .id(appointment.getId())
                .date(appointment.getDate())
                .time(appointment.getTime())
                .patientId(appointment.getPatientId())
                .doctorId(appointment.getDoctorId())
                .build();
    }
}
