package org.cs489.userprofile.mapper;

import org.cs489.userprofile.dto.request.UserRequestDto;
import org.cs489.userprofile.dto.response.UserResponseDto;
import org.cs489.userprofile.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = ProfileMapper.class)
public interface UserMapper {

    @Mapping(source = "profileRequestDto",target = "profile")
    User dtoToUser(UserRequestDto userRequestDto);

    @Mapping(source = "profile",target = "profileRequestDto")
    UserResponseDto userToDto(User user);

    @Mapping(source = "profile",target = "profileRequestDto")
    List<UserResponseDto> dtoToUserList(List<User> userList);
}
