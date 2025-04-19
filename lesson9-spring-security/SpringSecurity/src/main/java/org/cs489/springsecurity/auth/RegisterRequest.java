package org.cs489.springsecurity.auth;

import org.cs489.springsecurity.user.Role;

public record RegisterRequest(
        String firstName,
        String lastName,
        String username,
        String password,
        Role role
) {
}
