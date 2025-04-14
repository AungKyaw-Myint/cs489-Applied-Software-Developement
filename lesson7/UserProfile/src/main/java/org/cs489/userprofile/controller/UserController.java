package org.cs489.userprofile.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.cs489.userprofile.dto.request.UserRequestDto;
import org.cs489.userprofile.dto.response.UserResponseDto;
import org.cs489.userprofile.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = userService.createUser(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);
    }
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<UserResponseDto> userResponseDto = userService.findAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    @PutMapping("/{username}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable String username, @Valid @RequestBody UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto=userService.updateUser(userRequestDto,username);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
