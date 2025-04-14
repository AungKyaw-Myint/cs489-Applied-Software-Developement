package org.cs489.userprofile.dto.response;

import org.cs489.userprofile.dto.request.ProfileRequestDto;

import java.time.LocalDate;

public record UserResponseDto(
        Long id,
        String username,
//        String password,
        ProfileRequestDto profileRequestDto
) {
}
