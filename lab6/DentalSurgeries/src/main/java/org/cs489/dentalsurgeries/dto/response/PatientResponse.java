package org.cs489.dentalsurgeries.dto.response;

public record PatientResponse(
        Long id,
         String firstName,
         String lastName,
         String gender,
         String birthDate,
         AddressResponse address
) {
}
