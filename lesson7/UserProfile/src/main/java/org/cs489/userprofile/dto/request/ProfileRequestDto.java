package org.cs489.userprofile.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ProfileRequestDto(

        @NotBlank(message = "firstname cannot be Blank/empty/null")
        String firstName,
        @NotBlank(message = "lastname cannot be Blank/empty/null")
        String lastName,
        @NotNull(message = "dob cannot be null")
        LocalDate dateOfBirth,
        @Email(message = "invalid email format")
        String email,
        @NotBlank(message = "phoneNumber cannot be Blank/empty/null")
        String phone,
        @NotBlank(message = "username cannot be Blank/empty/null")
        String bio
) {
}
