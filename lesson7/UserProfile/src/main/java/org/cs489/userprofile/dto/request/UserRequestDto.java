package org.cs489.userprofile.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UserRequestDto(

        @NotBlank(message = "username cannot be Blank/empty/null")
        String username,

        @NotBlank(message = "password cannot be Blank/empty/null")
        @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[?*+!])[A-Za-z0-9?*+!]{4,8}$")
        String password,
        @NotNull(message = "Profile cannot be null")
        ProfileRequestDto profileRequestDto
) {
}
