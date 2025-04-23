package org.cs489.dentalsurgeries.controller;

import lombok.RequiredArgsConstructor;
import org.cs489.dentalsurgeries.dto.request.AppointmentRequest;
import org.cs489.dentalsurgeries.dto.response.AppointmentResponse;
import org.cs489.dentalsurgeries.dto.response.PatientResponse;
import org.cs489.dentalsurgeries.service.AppointmentService;
import org.cs489.dentalsurgeries.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping()
    public ResponseEntity<AppointmentResponse> addPatient(@Validated @RequestBody AppointmentRequest appointmentRequest) {
        AppointmentResponse appointmentResponse =appointmentService.saveAppointment(appointmentRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentResponse);
    }
}
