package com.cs489.LibrarySystem.dto.request;

import com.cs489.LibrarySystem.model.Address;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public record PublisherRequestDto(
        String name,
        AddressRequestDto addressRequestDto
) {
}
