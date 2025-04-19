package org.cs489.dentalsurgeries.auth;

import lombok.RequiredArgsConstructor;
import org.cs489.dentalsurgeries.dto.request.UserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    private ResponseEntity<AuthenticationResponse> register(@RequestBody UserRequest userRequest) {

        AuthenticationResponse response=authenticationService.register(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/authenticate")
    private ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        AuthenticationResponse response=authenticationService.authenticate(authenticationRequest);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
