package org.cs489.userprofile.service.impl;

import lombok.RequiredArgsConstructor;
import org.cs489.userprofile.dto.request.UserRequestDto;
import org.cs489.userprofile.dto.response.UserResponseDto;
import org.cs489.userprofile.exception.user.DuplicateUserException;
import org.cs489.userprofile.exception.user.UserNotFoundException;
import org.cs489.userprofile.mapper.UserMapper;
import org.cs489.userprofile.model.User;
import org.cs489.userprofile.repository.UserRepository;
import org.cs489.userprofile.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper     userMapper;


    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        Optional<User> optionalUser =userRepository.findByUsername(userRequestDto.username());

        if(optionalUser.isPresent()) {
            throw new DuplicateUserException("Username already exists");
        }
        User user=userMapper.dtoToUser(userRequestDto);
        System.out.println("Before save"+user.getProfile());
        User savedUser=userRepository.save(user);
        System.out.println("After save"+savedUser.getProfile());

        return userMapper.userToDto(savedUser);
    }

    @Override
    public UserResponseDto updateUser(UserRequestDto userRequestDto, String username) {

        Optional<User> optionalUser =userRepository.findByUsername(username);
        if(optionalUser.isPresent()) {
            User user=optionalUser.get();

            User mapUser=userMapper.dtoToUser(userRequestDto);
            mapUser.setId(user.getId());

            if(mapUser.getProfile() != null){
                mapUser.getProfile().setId(user.getProfile().getId());
            }

            User updatedUser=userRepository.save(mapUser);

            return userMapper.userToDto(updatedUser);
        }
        throw new UserNotFoundException(username+"User not found");
    }

    @Override
    @Transactional
    public void deleteUser(String username) {
//        userRepository.findByUsername(username).ifPresent(user -> {
//            userRepository.delete(user);
//        });

        Optional<User> optionalUser =userRepository.findByUsername(username);
        if(optionalUser.isPresent()) {
            userRepository.deleteByUsername(username);
        }else{
            throw new UserNotFoundException(username+"User not found");
        }
    }

    @Override
    public UserResponseDto findUserByUsername(String username) {
        return null;
    }

    @Override
    public List<UserResponseDto> findAllUsers() {
        List<User> userResponse = userRepository.findAll();
        return userMapper.dtoToUserList(userResponse);
    }
}
