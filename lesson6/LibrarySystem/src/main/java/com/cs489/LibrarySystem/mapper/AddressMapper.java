package com.cs489.LibrarySystem.mapper;

import com.cs489.LibrarySystem.dto.request.AddressRequestDto;
import com.cs489.LibrarySystem.dto.response.AddressResponseDto;
import com.cs489.LibrarySystem.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AddressMapper {

    Address addressRequestToAddress(AddressRequestDto addressRequestDto);
    AddressResponseDto addressToAddressResponseDto(Address address);
}
