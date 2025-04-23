package org.cs489.dentalsurgeries.service.impl;

import lombok.RequiredArgsConstructor;
import org.cs489.dentalsurgeries.dto.request.AppointmentRequest;
import org.cs489.dentalsurgeries.dto.response.AppointmentResponse;
import org.cs489.dentalsurgeries.exception.user.BadRequest;
import org.cs489.dentalsurgeries.exception.user.DataNotFound;
import org.cs489.dentalsurgeries.exception.user.DuplicateDataException;
import org.cs489.dentalsurgeries.mapper.AppointmentMapper;
import org.cs489.dentalsurgeries.model.*;
import org.cs489.dentalsurgeries.repository.AppointmentRepository;
import org.cs489.dentalsurgeries.repository.DentistRepository;
import org.cs489.dentalsurgeries.repository.PatientRepository;
import org.cs489.dentalsurgeries.repository.SurgeryRepository;
import org.cs489.dentalsurgeries.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    private final PatientRepository patientRepository;
    private final DentistRepository dentistRepository;
    private final SurgeryRepository surgeryRepository;

    @Override
    public AppointmentResponse saveAppointment(AppointmentRequest appointmentRequest) {

        Optional<Appointment> foundAppointment=
                appointmentRepository.findByAppointmentCode(appointmentRequest.appointmentCode());
        if(foundAppointment.isPresent()) {
            throw new DuplicateDataException("Appointment code is already exists");
        }

        List<Appointment> appointmentList=
                appointmentRepository.findByAppointmentStatusNotAndPatient_Id(AppointmentStatus.PAID,
                                                                              appointmentRequest.patientId());
        if(!appointmentList.isEmpty()) {
            throw new BadRequest("Unpaid or One Appointment is already exists");
        }

        Optional<Patient> patient     =patientRepository.findById(appointmentRequest.patientId());
        if(!patient.isPresent()) {
            throw new DataNotFound("Patient not found");
        }

        Optional<Dentist> dentist     = dentistRepository.findById(appointmentRequest.dentistId());
        if(!dentist.isPresent()) {
            throw new DataNotFound("Dentist not found");
        }

        Optional<Surgery> surgery     =surgeryRepository.findById(appointmentRequest.surgeryId());
        if(!surgery.isPresent()) {
            throw new DataNotFound("Surgery not found");
        }

        List<Appointment> appointments=appointmentRepository.findByAppointmentDateBetweenAndAppointmentStatusAndDentist_Id(
                appointmentRequest.appointmentDate(),
                appointmentRequest.appointmentDate().plusDays(7),
                AppointmentStatus.SCHEDULED,
                appointmentRequest.dentistId());
        if(appointments.size() >=5){
            throw new BadRequest("Dentist is full of schedule");
        }

        Appointment createAppointment=appointmentMapper.dtoToAppointment(appointmentRequest);
        createAppointment.setPatient(patient.get());
        createAppointment.setDentist(dentist.get());
        createAppointment.setSurgery(surgery.get());
        Appointment       appointment =appointmentRepository.save(createAppointment);

        return appointmentMapper.appointmentToDto(appointment);
    }

    @Override
    public AppointmentResponse updateAppointment(AppointmentRequest appointmentRequest) {
        return null;
    }

    @Override
    public void deleteAppointment(String appointmentCode) {

    }

    @Override
    public AppointmentResponse getAppointmentByCode(String appointmentCode) {
        return null;
    }

    @Override
    public List<AppointmentResponse> getAllAppointments() {
        return appointmentMapper.appointmentListToDtoList(appointmentRepository.findAll());
    }
}
