package org.cs489.dentalsurgeries.service;

import org.cs489.dentalsurgeries.dto.request.AppointmentRequest;
import org.cs489.dentalsurgeries.dto.response.AppointmentResponse;

import java.util.List;

public interface AppointmentService{

    AppointmentResponse saveAppointment(AppointmentRequest appointmentRequest);
    AppointmentResponse updateAppointment(AppointmentRequest appointmentRequest);
    void deleteAppointment(String appointmentCode);
    AppointmentResponse getAppointmentByCode(String appointmentCode);
    List<AppointmentResponse> getAllAppointments();
}
