package org.cs489.springsecurity.auth;

public record AuthenticationRequest(
        String username,
        String password
) {
}
