package org.cs489.dentalsurgeries.service.impl;

import lombok.RequiredArgsConstructor;
import org.cs489.dentalsurgeries.dto.request.AppointmentRequest;
import org.cs489.dentalsurgeries.dto.response.AppointmentResponse;
import org.cs489.dentalsurgeries.mapper.AppointmentMapper;
import org.cs489.dentalsurgeries.model.Appointment;
import org.cs489.dentalsurgeries.repository.AppointmentRepository;
import org.cs489.dentalsurgeries.service.AppointmentService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppoitmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper     appointmentMapper;

    @Override
    public AppointmentResponse saveAppointment(AppointmentRequest appointmentRequest) {

        Optional<Appointment> foundAppointment=
                appointmentRepository.findByAppointmentCode(appointmentRequest.appointmentCode());
        if(foundAppointment.isPresent()) {
            return null;
        }
        Appointment appointment=appointmentRepository.save(appointmentMapper.dtoToAppointment(appointmentRequest));

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
