package org.cs489.dentalsurgeries.auth;

import lombok.RequiredArgsConstructor;
import org.cs489.dentalsurgeries.config.JwtService;
import org.cs489.dentalsurgeries.dto.request.UserRequest;
import org.cs489.dentalsurgeries.exception.user.DataNotFound;
import org.cs489.dentalsurgeries.mapper.UserMapper;
import org.cs489.dentalsurgeries.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository  userRepository;
    private final UserMapper      userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService            jwtService;

    @Transactional
    public AuthenticationResponse register(UserRequest userRequest) {
        User user=userMapper.dtoToUser(userRequest);
        user.setPassword(passwordEncoder.encode(userRequest.password()));

        User savedUser=userRepository.save(user);

        String token =jwtService.generateToken(savedUser);

        return new AuthenticationResponse(token);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.username(),
                        authenticationRequest.password()));

        var user=(User)authentication.getPrincipal();

        String token =jwtService.generateToken(user);;

        return new AuthenticationResponse(token);
    }

    public User getUser() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return userRepository.findByUsername(username).orElseThrow(() -> new DataNotFound("User id not found"));
    }
}
