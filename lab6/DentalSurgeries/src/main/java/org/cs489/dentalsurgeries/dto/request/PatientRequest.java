package org.cs489.dentalsurgeries.dto.request;

import java.time.LocalDate;

public record PatientRequest(
         String firstName,
         String lastName,
         String gender,
         LocalDate birthDate,
         AddressReqeust address
) {
}
