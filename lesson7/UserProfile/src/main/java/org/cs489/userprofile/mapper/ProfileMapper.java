package org.cs489.userprofile.mapper;

import org.cs489.userprofile.dto.request.ProfileRequestDto;
import org.cs489.userprofile.dto.response.ProfileResponseDto;
import org.cs489.userprofile.model.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProfileMapper {

    Profile dtoToProfile(ProfileRequestDto profileRequestDto);

    ProfileResponseDto profileToDto(Profile profile);

    List<ProfileResponseDto> profislesToDtoList(List<Profile> profiles);
}
