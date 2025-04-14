package org.cs489.userprofile.service;

import org.cs489.userprofile.dto.request.UserRequestDto;
import org.cs489.userprofile.dto.response.UserResponseDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserResponseDto createUser(UserRequestDto userRequestDto);
    UserResponseDto updateUser(UserRequestDto userRequestDto,String username);
    void deleteUser(String username);
    UserResponseDto findUserByUsername(String username);
    List<UserResponseDto> findAllUsers();
}
