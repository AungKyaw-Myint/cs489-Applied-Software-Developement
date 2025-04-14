package org.cs489.dentalsurgeries.dto.request;

public record PatientRequest(
         String firstName,
         String lastName,
         String gender,
         String birthDate,
         AddressReqeust address
) {
}
