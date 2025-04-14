package org.cs489.userprofile.dto.response;

import java.time.LocalDate;

public record ProfileResponseDto (
        Long id,
        String firstName,
        String lastName,
//        LocalDate dateOfBirth,
//        String email,
//        String phone,
        String bio
){
}
