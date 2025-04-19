package org.cs489.dentalsurgeries.auth;

public record AuthenticationRequest(
        String username,
        String password
) {
}
