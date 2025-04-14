package org.cs489.dentalsurgeries.dto.request;

public record DentistRequest(
         String firstName,
         String lastName,
         String email,
         String phone
) {
}
