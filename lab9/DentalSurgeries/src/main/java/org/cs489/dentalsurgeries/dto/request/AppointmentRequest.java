package org.cs489.dentalsurgeries.dto.request;

import java.time.LocalDate;

public record AppointmentRequest(
        String title,
        String appointmentCode,
        String description,
        LocalDate appointmentDate,
        String    appointmentType,
        String appointmentStatus,
        PatientRequest patient,
        SurgeryRequest surgery,
        DentistRequest dentist
) {
}
