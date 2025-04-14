package com.cs489.LibrarySystem.dto.response;

import com.cs489.LibrarySystem.model.Address;

public record PublisherResponseDto (
        int id,
        String name,
        AddressResponseDto addressResponseDto
){
}
